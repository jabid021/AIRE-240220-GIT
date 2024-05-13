package fr.formation.request;

public class CreateCommentaireRequest {
    private String text;
    private int note;
    private String produitId;
    
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        this.note = note;
    }

    public String getProduitId() {
        return produitId;
    }

    public void setProduitId(String produitId) {
        this.produitId = produitId;
    }
}
