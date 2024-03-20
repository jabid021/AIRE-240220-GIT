package model;

public abstract class Personne {

	protected String prenom;
	protected String nom;
	


	public Personne(String prenom, String nom) {
		this.prenom = prenom;
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Personne [prenom=" + prenom + ", nom=" + nom + "]";
	}

	
}
