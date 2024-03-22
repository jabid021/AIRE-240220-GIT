package poudlard.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("teacher")
public class Professeur extends Sorcier{

	@Column(length = 20)
	private String matiere;
	
	@OneToOne
	@JoinColumn(name="responsable_maison")
	private Maison maisonDontJeSuisPrincipal;
	
	
	public Professeur() {}

	
	
	
	public Professeur(String nom, String prenom, Stats statistiques, String matiere) {
		super(nom, prenom, statistiques);
		this.matiere = matiere;
	}




	public String getMatiere() {
		return matiere;
	}




	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}




	public Maison getMaisonDontJeSuisPrincipal() {
		return maisonDontJeSuisPrincipal;
	}




	public void setMaisonDontJeSuisPrincipal(Maison maisonDontJeSuisPrincipal) {
		this.maisonDontJeSuisPrincipal = maisonDontJeSuisPrincipal;
	}




	@Override
	public String toString() {
		return "Professeur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", statistiques=" + statistiques
				+ ", matiere=" + matiere + "]";
	}

	

	
	

}
