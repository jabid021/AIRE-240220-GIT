package fr.formation.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.service.SolarReaderService;

@RestController
@RequestMapping("/api/solar")
public class SolarApiController {
    @Autowired
    private SolarReaderService readerService;
    
    @PostMapping
    public void readAndSave() {
        
    }
}
