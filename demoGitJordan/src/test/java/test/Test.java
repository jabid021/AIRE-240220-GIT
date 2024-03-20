package test;

import model.Formateur;
import model.Personne;
import model.Stagiaire;

public class Test {

	public static void main(String[] args) {

		Personne p1 = new Stagiaire("Jordan","Abid",30,"homme","AIRE");
		System.out.println(p1);
		
		Personne p2 = new Formateur("Eric","Sultan","homme");
	}

}
