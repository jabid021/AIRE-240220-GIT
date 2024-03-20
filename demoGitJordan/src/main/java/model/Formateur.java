package model;

public class Formateur extends Personne{

	public Formateur(String prenom, String nom, String civilite) {
		super(prenom, nom, civilite);
	}

	@Override
	public String toString() {
		return "Formateur [prenom=" + prenom + ", nom=" + nom + ", civilite=" + civilite + "]";
	}
	
	

}
