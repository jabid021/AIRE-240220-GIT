package poudlard.model.heritage;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity	
@Table(name="car")
public class Voiture extends Vehicule {

	private String marque;
	private String couleur;
	
	public Voiture() {}
	public Voiture(int nbRoues, String marque, String couleur) {
		super(nbRoues);
		this.marque = marque;
		this.couleur = couleur;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	@Override
	public String toString() {
		return "Voiture [id=" + id + ", nbRoues=" + nbRoues + ", marque=" + marque + ", couleur=" + couleur + "]";
	}
	
	
	
}
