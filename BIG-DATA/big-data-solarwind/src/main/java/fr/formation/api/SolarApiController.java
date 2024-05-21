package fr.formation.api;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/solar")
public class SolarApiController {
    @PostMapping
    public void readAndSave() {
        
    }
}
