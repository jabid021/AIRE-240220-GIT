package fr.formation.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.feignclient.CommentaireFeignClient;
import fr.formation.model.Produit;
import fr.formation.repo.ProduitRepository;
import fr.formation.request.CreateProduitRequest;
import fr.formation.response.ProduitResponse;

@RestController
@RequestMapping("/api/produit")
@CrossOrigin("*")
public class ProduitApiController {
    @Autowired
    private ProduitRepository repository;

    @Autowired
    private CommentaireFeignClient commentaireFeignClient;

    @GetMapping
    public List<ProduitResponse> findAll() {
        List<Produit> produits = this.repository.findAll();
        List<ProduitResponse> response = new ArrayList<>();

        for (Produit produit : produits) {
            ProduitResponse produitResponse = new ProduitResponse();

            BeanUtils.copyProperties(produit, produitResponse);

            response.add(produitResponse);

            Integer note = this.commentaireFeignClient.getNoteByProduitId(produit.getId());
            
            if (note != null) {
                produitResponse.setNote(note);
            }
        }
        
        return response;
    }
    
    @GetMapping("/{id}/is-notable")
    public Boolean isNotableById(@PathVariable String id) {
        Optional<Produit> optProduit = this.repository.findById(id);

        return optProduit.isPresent() && optProduit.get().isNotable();
    }

    @GetMapping("/{id}/name")
    public String getNameById(@PathVariable String id) {
        Optional<Produit> optProduit = this.repository.findById(id);

        if (optProduit.isPresent()) {
            return optProduit.get().getName();
        }

        return "- product not found -";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestBody CreateProduitRequest request) {
        Produit produit = new Produit();
        
        BeanUtils.copyProperties(request, produit);

        this.repository.save(produit);

        return produit.getId();
    }
}
