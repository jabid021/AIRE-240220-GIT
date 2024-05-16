package fr.formation.eventconsumer;

import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

import fr.formation.event.CommentaireCreatedEvent;
import fr.formation.model.Produit;
import fr.formation.repo.ProduitRepository;

@Component("onCommentaireCreated")
public class CommentaireCreatedEventConsumer implements Consumer<CommentaireCreatedEvent> {
    @Autowired
    private ProduitRepository repository;

    @Autowired
    private StreamBridge streamBridge;

    @Override
    public void accept(CommentaireCreatedEvent evt) {
        Optional<Produit> optProduit = this.repository.findById(evt.getProduitId());

        if (optProduit.isPresent() && optProduit.get().isNotable()) {
            // C'est notable !
            this.streamBridge.send("commentaire.validated", evt.getCommentaireId());
        }
        
        else {
            // C'est pas notable !
            this.streamBridge.send("commentaire.rejected", evt.getCommentaireId());
        }
    }
}
