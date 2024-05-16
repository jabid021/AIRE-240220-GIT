package fr.formation.eventconsumer;

import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.formation.repo.CommentaireRepository;

@Component("onCommentaireRejected")
public class CommentaireRejectedEventConsumer implements Consumer<String> {
    @Autowired
    private CommentaireRepository repository;

    @Override
    public void accept(String commentaireId) {
        this.repository.deleteById(commentaireId);
    }
}
