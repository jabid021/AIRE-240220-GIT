package model;

public abstract class Personne {

	protected String prenom;
	protected String nom;
	protected String civilite;


	public Personne(String prenom, String nom,String civilite) {
		this.prenom = prenom;
		this.nom = nom;
		this.civilite=civilite;
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

	
	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	
	
}
