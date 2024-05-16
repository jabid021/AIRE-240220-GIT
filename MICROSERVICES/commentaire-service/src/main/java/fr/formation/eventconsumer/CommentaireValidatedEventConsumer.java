package fr.formation.eventconsumer;

import java.util.Optional;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.formation.enumerator.CommentaireEtat;
import fr.formation.model.Commentaire;
import fr.formation.repo.CommentaireRepository;

@Component("onCommentaireValidated")
public class CommentaireValidatedEventConsumer implements Consumer<String> {
    @Autowired
    private CommentaireRepository repository;

    @Override
    public void accept(String commentaireId) {
        Optional<Commentaire> optCommentaire = this.repository.findById(commentaireId);

        if (optCommentaire.isPresent()) {
            Commentaire commentaire = optCommentaire.get();

            commentaire.setEtat(CommentaireEtat.OK);

            this.repository.save(commentaire);
        }
    }
}
