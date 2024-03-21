package poudlard.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("student")
public class Eleve extends Sorcier {

	private int annee;
	
	public Eleve() {}

	public Eleve(String nom, String prenom, Stats statistiques, int annee) {
		super(nom, prenom, statistiques);
		this.annee = annee;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	@Override
	public String toString() {
		return "Eleve [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", statistiques=" + statistiques + ", annee="
				+ annee + "]";
	}
	
	
	
	
}
