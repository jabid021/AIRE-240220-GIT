package model;

public class Stagiaire extends Personne {

	private int age;
	private String filiere;

	public Stagiaire(String prenom, String nom, int age, String filiere) {
		super(prenom, nom);
		this.age = age;
		this.filiere = filiere;
	}

	
	public String getFiliere() {
		return filiere;
	}

	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}


	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


	@Override
	public String toString() {
		return "Stagiaire [age=" + age + ", filiere=" + filiere + "]";
	}
	
}
