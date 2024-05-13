package fr.formation.api;

import java.util.List;
import java.util.Optional;

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

import fr.formation.exception.ProduitNotFoundOrNotNotableException;
import fr.formation.model.Commentaire;
import fr.formation.model.Produit;
import fr.formation.repo.CommentaireRepository;
import fr.formation.repo.ProduitRepository;
import fr.formation.request.CreateCommentaireRequest;
import fr.formation.response.CommentaireResponse;

@RestController
@RequestMapping("/api/commentaire")
@CrossOrigin("*")
public class CommentaireApiController {
    @Autowired
    private CommentaireRepository repository;

    @Autowired
    private ProduitRepository produitRepository;

    @GetMapping
    public List<CommentaireResponse> findAll() {
        return this.repository.findAll().stream()
            // .map(commentaire -> this.map(commentaire))
            .map(this::map)
            .toList();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestBody CreateCommentaireRequest request) {
        Optional<Produit> optProduit = this.produitRepository.findById(request.getProduitId());

        if (optProduit.isEmpty() || !optProduit.get().isNotable()) {
            // Pas la peine d'aller plus loin
            throw new ProduitNotFoundOrNotNotableException();
        }

        Commentaire commentaire = new Commentaire();

        BeanUtils.copyProperties(request, commentaire);

        commentaire.setProduit(optProduit.get());

        this.repository.save(commentaire);

        return commentaire.getId();
    }

    private CommentaireResponse map(Commentaire commentaire) {
        CommentaireResponse response = new CommentaireResponse();

        BeanUtils.copyProperties(commentaire, response);

        response.setProduitId(commentaire.getProduit().getId());
        response.setProduitName(commentaire.getProduit().getName());

        return response;
    }
}
