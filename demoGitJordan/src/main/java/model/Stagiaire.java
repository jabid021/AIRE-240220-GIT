package model;

public class Stagiaire extends Personne {

	private int age;

	public Stagiaire(String prenom, String nom, int age,String civilite) {
		super(prenom, nom,civilite);
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Stagiaire [prenom=" + prenom + ", nom=" + nom + ", civilite=" + civilite + ", age=" + age + "]";
	}

	
	
}
