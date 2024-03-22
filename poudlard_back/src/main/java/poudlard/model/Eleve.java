package poudlard.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("student")
public class Eleve extends Sorcier {

	private int annee;
	
	@ManyToOne
	@JoinColumn(name="residence_eleve")
	private Maison maison;
	
	
	public Eleve() {}

	public Eleve(String nom, String prenom, Stats statistiques, int annee,Maison maison) {
		super(nom, prenom, statistiques);
		this.annee = annee;
		this.maison=maison;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}
	

	public Maison getMaison() {
		return maison;
	}

	public void setMaison(Maison maison) {
		this.maison = maison;
	}

	@Override
	public String toString() {
		return "Eleve [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", statistiques=" + statistiques + ", annee="
				+ annee + ", maison=" + maison + "]";
	}

	
	
}
