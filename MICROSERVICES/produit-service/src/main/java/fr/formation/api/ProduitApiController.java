package fr.formation.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import fr.formation.model.Commentaire;
import fr.formation.model.Produit;
import fr.formation.repo.CommentaireRepository;
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
    private CommentaireRepository commentaireRepository;

    @GetMapping
    public List<ProduitResponse> findAll() {
        List<Produit> produits = this.repository.findAll();
        List<ProduitResponse> response = new ArrayList<>();

        for (Produit produit : produits) {
            ProduitResponse produitResponse = new ProduitResponse();

            BeanUtils.copyProperties(produit, produitResponse);

            response.add(produitResponse);

            // Calcul de la note moyenne - V1
            List<Commentaire> commentaires = this.commentaireRepository.findAllByProduitId(produit.getId());
            
            produitResponse.setNote(-1);

            if (!commentaires.isEmpty()) {
                int somme = 0;

                for (Commentaire commentaire : commentaires) {
                    somme += commentaire.getNote();
                }

                produitResponse.setNote(somme / commentaires.size());
            }

            // Calcul de la note moyenne - V2
            int moyenne = (int)commentaires.stream()
                // .mapToInt(commentaire -> commentaire.getNote())
                .mapToInt(Commentaire::getNote)
                .average()
                .orElse(-1);
            
            produitResponse.setNote(moyenne);

            // Calcul de la note moyenne - V3
            moyenne = this.commentaireRepository.getNoteMoyenneByProduitId(produit.getId())
                .orElse(-1);
            
            produitResponse.setNote(moyenne);
        }
        
        return response;
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
