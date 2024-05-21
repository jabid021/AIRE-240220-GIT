package fr.formation.api;

import java.math.BigDecimal;

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
        for (int i = 0; i < 2_000; i++) {
            Produit produit = new Produit();

            produit.setName("Produit " + i);
            produit.setPrice(new BigDecimal(i));

            this.repository.save(produit);
        }
    }
}
