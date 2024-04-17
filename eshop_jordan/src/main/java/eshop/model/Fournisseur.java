package eshop.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;

import eshop.view.Views;

@Entity
@DiscriminatorValue("supplier")
public class Fournisseur extends Personne {

	@Column(name="company",length = 40)
	@JsonView(Views.Common.class)
	private String societe;


	@OneToMany(mappedBy = "fournisseur")
	@JsonView(Views.FournisseurWithStock.class)
	private List<Produit> stock;

	public Fournisseur() {}

	public Fournisseur(String nom, String prenom, Adresse adresse, String societe) {
		super(nom, prenom, adresse);
		this.societe = societe;
	}

	public String getSociete() {
		return societe;
	}

	public void setSociete(String societe) {
		this.societe = societe;
	}


	public List<Produit> getStock() {
		return stock;
	}

	public void setStock(List<Produit> stock) {
		this.stock = stock;
	}


	public String getInfos() {
		return this.id + " - " + this.nom + " - " + this.prenom;
		
	}
	

	@Override
	public String toString() {
		return "Fournisseur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", societe="
				+ societe + "]";
	}



}
