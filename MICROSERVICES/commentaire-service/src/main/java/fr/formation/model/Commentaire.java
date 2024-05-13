package fr.formation.model;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "commentaire")
public class Commentaire {
    @Id
    @UuidGenerator
    private String id;

    private String text;

    @Column //(nullable = false)
    private int noteQuality;

    @Column //(nullable = false)
    private int notePrice;

    @Column //(nullable = false)
    private int noteEase;

    @ManyToOne
    private Produit produit;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }
}
