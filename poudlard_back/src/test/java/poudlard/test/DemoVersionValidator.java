package poudlard.test;

import java.util.Scanner;

import poudlard.context.Singleton;
import poudlard.dao.IDAOMaison;
import poudlard.dao.IDAOSorcier;
import poudlard.model.Maison;
import poudlard.model.Sorcier;

public class DemoVersionValidator {
	public static String saisieString(String message) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(message);
		return sc.nextLine();
	}
	
	public static int saisieInt(String message) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(message);
		int variable = sc.nextInt();
		return variable;
	}

	
	public static void main(String[] args) {
		
		IDAOSorcier daoSorcier = Singleton.getInstance().getDaoSorcier();
		IDAOMaison daoMaison = Singleton.getInstance().getDaoMaison();
		
		
		
		Maison maison1 = daoMaison.findById(2);
		
		System.out.println(maison1);
		
		maison1.setScore(4);
		daoMaison.save(maison1);
		
		
		
		Sorcier sorcier1 = daoSorcier.findById(7);
		
		System.out.println(sorcier1);
		
		String nouveauPrenom = saisieString("Saisir le nouveau prenom du sorcier : ");
		
		sorcier1.setPrenom(nouveauPrenom);

		
		 sorcier1= daoSorcier.save(sorcier1);
		
		 System.out.println("Apres modif");
		 System.out.println(sorcier1);
		
		
		 
		 
		

	}

}
