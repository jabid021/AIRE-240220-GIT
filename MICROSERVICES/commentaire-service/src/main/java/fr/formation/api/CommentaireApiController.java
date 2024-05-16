package fr.formation.api;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import fr.formation.command.CreateCommentaireCommand;
import fr.formation.enumerator.CommentaireEtat;
import fr.formation.model.Commentaire;
import fr.formation.repo.CommentaireRepository;
import fr.formation.request.CreateCommentaireRequest;
import fr.formation.response.CommentaireResponse;

@RestController
@RequestMapping("/api/commentaire")
@CrossOrigin("*")
public class CommentaireApiController {
    @Autowired
    private CommentaireRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CircuitBreakerFactory circuitBreakerFactory;

    @Autowired
    private StreamBridge streamBridge;

    @GetMapping
    public List<CommentaireResponse> findAll() {
        return this.repository.findAllByEtat(CommentaireEtat.OK).stream()
            // .map(commentaire -> this.map(commentaire))
            .map(this::map)
            .toList();
    }

    @GetMapping("/note/by-produit-id/{produitId}")
    public int getNoteByProduitId(@PathVariable String produitId) {
        // Calcul de la note moyenne - V1
        List<Commentaire> commentaires = this.repository.findAllByProduitIdAndEtat(produitId, CommentaireEtat.OK);
        int note = -1;
        
        if (!commentaires.isEmpty()) {
            int somme = 0;

            for (Commentaire commentaire : commentaires) {
                somme += (commentaire.getNoteQuality() + commentaire.getNotePrice() + commentaire.getNoteEase()) / 3;
            }

            note = somme / commentaires.size();
        }

        // Calcul de la note moyenne - V2
        note = (int)commentaires.stream()
            .mapToInt(commentaire -> (commentaire.getNoteQuality() + commentaire.getNotePrice() + commentaire.getNoteEase()) / 3)
            .average()
            .orElse(-1);
        
        // Calcul de la note moyenne - V3
        note = this.repository.getNoteMoyenneByProduitId(produitId)
            .orElse(-1);
        
        return note;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String create(@RequestBody CreateCommentaireRequest request) {
        // Boolean isNotable = this.restTemplate
        //     .getForObject("http://localhost:8081/api/produit/" + request.getProduitId() + "/is-notable", Boolean.class);
        // Boolean isNotable = this.restTemplate
        //     .getForObject("lb://produit-service/api/produit/" + request.getProduitId() + "/is-notable", Boolean.class);
        
        // Boolean isNotable = this.circuitBreakerFactory.create("produitService").run(
        //     () -> this.restTemplate
        //                 .getForObject("lb://produit-service/api/produit/" + request.getProduitId() + "/is-notable", Boolean.class)
        //     ,
        //     ex -> false
        // );

        // if (isNotable == null || !isNotable) {
        //     // Pas la peine d'aller plus loin
        //     throw new ProduitNotFoundOrNotNotableException();
        // }

        Commentaire commentaire = new Commentaire();
        CreateCommentaireCommand command = new CreateCommentaireCommand();

        BeanUtils.copyProperties(request, commentaire);

        commentaire.setEtat(CommentaireEtat.ATTENTE);

        this.repository.save(commentaire);

        command.setCommentaireId(commentaire.getId());
        command.setProduitId(commentaire.getProduitId());

        this.streamBridge.send("commentaire.created", command);

        return commentaire.getId();
    }

    private CommentaireResponse map(Commentaire commentaire) {
        CommentaireResponse response = new CommentaireResponse();

        BeanUtils.copyProperties(commentaire, response);

        // String name = this.restTemplate
        //     .getForObject("http://localhost:8081/api/produit/" + commentaire.getProduitId() + "/name", String.class);
        // String name = this.restTemplate
        //     .getForObject("lb://produit-service/api/produit/" + commentaire.getProduitId() + "/name", String.class);

        String name = this.circuitBreakerFactory.create("produitService").run(
            () -> this.restTemplate.getForObject("lb://produit-service/api/produit/" + commentaire.getProduitId() + "/name", String.class)
            ,
            t -> "- no name -"
        );

        response.setProduitName(name);

        return response;
    }
}
