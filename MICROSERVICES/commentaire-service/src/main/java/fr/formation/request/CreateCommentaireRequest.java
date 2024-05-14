package fr.formation.request;

public class CreateCommentaireRequest {
    private String text;
    private int noteQuality;
    private int notePrice;
    private int noteEase;
    private String produitId;
    
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getNoteQuality() {
        return noteQuality;
    }

    public void setNoteQuality(int noteQuality) {
        this.noteQuality = noteQuality;
    }

    public int getNotePrice() {
        return notePrice;
    }

    public void setNotePrice(int notePrice) {
        this.notePrice = notePrice;
    }

    public int getNoteEase() {
        return noteEase;
    }

    public void setNoteEase(int noteEase) {
        this.noteEase = noteEase;
    }

    public String getProduitId() {
        return produitId;
    }

    public void setProduitId(String produitId) {
        this.produitId = produitId;
    }
}
