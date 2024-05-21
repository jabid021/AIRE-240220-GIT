package fr.formation.api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.dto.SolarWindDto;
import fr.formation.service.SolarReaderService;

@RestController
@RequestMapping("/api/solar")
public class SolarApiController {
    private static final Logger log = LoggerFactory.getLogger(SolarApiController.class);

    @Autowired
    private SolarReaderService readerService;

    @PostMapping
    public void readAndSave() {
        List<SolarWindDto> winds = this.readerService.read("D:/Developpement/perso/data/solarwinds/dscovr/compiled/2017/201701.csv");

        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/solarwind", "postgres", "root")) {
            connection.setAutoCommit(false);

            // Récupérer un Statement pour exécuter la requête (un PreparedStatement est encore mieux !)
            try (PreparedStatement statement = connection.prepareStatement("INSERT INTO wind (date, speed, density, bt, bz) VALUES (?, ?, ?, ?, ?)")) {
                int batchIndex = 0;
                
                for (SolarWindDto wind : winds) {
                    statement.setString(1, wind.getDate());
                    statement.setFloat(2, wind.getSpeed() == null ? 0 : wind.getSpeed());
                    statement.setFloat(3, wind.getDensity() == null ? 0 : wind.getDensity());
                    statement.setFloat(4, wind.getBt() == null ? 0 : wind.getBt());
                    statement.setFloat(5, wind.getBz() == null ? 0 : wind.getBz());

                    statement.addBatch();

                    if (batchIndex == 10_000) {
                        statement.executeBatch();
                        connection.commit();
                        batchIndex = -1;
                    }

                    batchIndex++;
                }

                statement.executeBatch();
                connection.commit();
            }
        }

        catch (Exception ex) {
            ex.printStackTrace();
            log.error("Impossible de se connecter, ou problème dans la requête ...");
        }
    }
}
