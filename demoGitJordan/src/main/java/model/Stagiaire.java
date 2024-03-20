package model;

public class Stagiaire extends Personne {

	private int age;

	public Stagiaire(String prenom, String nom, int age) {
		super(prenom, nom);
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
		return "Stagiaire [age=" + age + ", prenom=" + prenom + ", nom=" + nom + "]";
	}
	
	
}
