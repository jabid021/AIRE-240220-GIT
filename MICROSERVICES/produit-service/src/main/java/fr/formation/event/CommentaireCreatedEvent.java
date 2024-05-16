package fr.formation.event;

public class CommentaireCreatedEvent {
    private String commentaireId;
    private String produitId;
    
    public String getCommentaireId() {
        return commentaireId;
    }
    
    public void setCommentaireId(String commentaireId) {
        this.commentaireId = commentaireId;
    }
    
    public String getProduitId() {
        return produitId;
    }
    
    public void setProduitId(String produitId) {
        this.produitId = produitId;
    }
}
