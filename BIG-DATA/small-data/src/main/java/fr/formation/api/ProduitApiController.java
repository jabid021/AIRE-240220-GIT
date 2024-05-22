package fr.formation.api;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.model.Produit;
import fr.formation.repo.ProduitRepository;

@RestController
@RequestMapping("/api/small-data")
public class ProduitApiController {
    @Autowired
    private ProduitRepository repository;

    @PostMapping
    public void generate() {
        List<Produit> produits = new ArrayList<>();

        for (int i = 0; i < 2_000; i++) {
            Produit produit = new Produit();

            produit.setName("Produit " + i);
            produit.setPrice(new BigDecimal(i));

            // this.repository.save(produit);
            produits.add(produit);
        }

        this.repository.saveAll(produits);
    }

    @PostMapping("/jdbc")
    public void generateJdbc() {
        // Récupérer une connexion JDBC

        // Syntaxe try-with-resources : C'est Java qui va appeler la méthode close() de la connection
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/small_data", "root", "root")) {
            connection.setAutoCommit(false);

            // Récupérer un Statement pour exécuter la requête (un PreparedStatement est encore mieux !)
            try (PreparedStatement statement = connection.prepareStatement("INSERT INTO produit (name, price) VALUES (?, ?)")) {
                int batchIndex = 0;
                
                for (int i = 0; i < 500_000; i++) {
                    Produit produit = new Produit();
        
                    produit.setName("Produit " + i);
                    produit.setPrice(new BigDecimal(i));
        
                    statement.setString(1, produit.getName());
                    statement.setBigDecimal(2, produit.getPrice());
        
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
            System.out.println("ERREUR");
        }

    }
}
