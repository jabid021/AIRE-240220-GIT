package quest.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Stagiaire extends Compte {

	@Embedded
	private Adresse adresse;
	
	@ManyToOne
	@JoinColumn(name="filiere")
	private Filiere filiere;

	public Stagiaire() {}
	
	public Stagiaire(Integer id,String email, String password, String prenom, String nom, Adresse adresse, Filiere filiere) {
		super(id,email, password, prenom, nom);
		this.adresse = adresse;
		this.filiere = filiere;
	}
	public Stagiaire(Integer id,String email, String password, String prenom, String nom,String numero,String voie,String ville,String cp, Filiere filiere) {
		super(id,email, password, prenom, nom);
		this.adresse = new Adresse(numero,voie,ville,cp);
		this.filiere = filiere;
	}
	
	public Stagiaire(String email, String password, String prenom, String nom, Adresse adresse, Filiere filiere) {
		super(email, password, prenom, nom);
		this.adresse = adresse;
		this.filiere = filiere;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Filiere getFiliere() {
		return filiere;
	}

	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}

	@Override
	public String toString() {
		return "Stagiaire [id=" + id + ", email=" + email + ", password=" + password + ", prenom=" + prenom + ", nom="
				+ nom + ", adresse=" + adresse + ", filiere=" + filiere + "]";
	}

	
	
	
}
