package quest.test;

import java.time.LocalDate;

import quest.model.Adresse;
import quest.model.Filiere;
import quest.model.Formateur;
import quest.model.Marque;
import quest.model.Matiere;
import quest.model.Ordinateur;
import quest.model.Stagiaire;
import quest.model.Module;

public class Test {

	public static void main(String[] args) {

		Matiere matiere1 = new Matiere("Algorithmie");
		Matiere matiere2 = new Matiere("Java Objet");
		Matiere matiere3 = new Matiere("Init Bdd et SQL");
		Matiere matiere4 = new Matiere("XML et JSON");
		Matiere matiere5 = new Matiere("Agile SCRUM");
		Matiere matiere6 = new Matiere("Angular");
	 
		Filiere filiere1 = new Filiere("I-240220-DIS-560-AIRE-DEVCLOUD",LocalDate.parse("2024-02-20"),LocalDate.parse("2024-06-17"));
		
		Adresse adresse1 = new Adresse("numero","voie","ville","cp");
		Adresse adresse2 = new Adresse("numero2","voie2","ville2","cp2");
		Adresse adresse3 = new Adresse("numero3","voie3","ville3","cp3");
		
		Stagiaire stagiaire1 = new Stagiaire("hajar@email.com","password","Hajar","BOUAMOUT",adresse1,filiere1);
		Stagiaire stagiaire2 = new Stagiaire("hana@email.com","password","Hana","AZID",adresse2,filiere1);
		Stagiaire stagiaire3 = new Stagiaire("marieantoine@email.com","password","Marie Antoine","SAMY",adresse3,filiere1);
		
		Formateur formateur1 = new Formateur("jordan@email.com","password","Jordan","ABID",250.50);
		Formateur formateur2 = new Formateur("eric@email.com","password","Eric","SULTAN",450.50);
		Formateur formateur3 = new Formateur("didier@email.com","password","Didier","RAZON",400);
		
	
		Ordinateur ordinateur1 = new Ordinateur(8,Marque.Asus,stagiaire1);
		Ordinateur ordinateur2 = new Ordinateur(16,Marque.Asus,stagiaire2);
		Ordinateur ordinateur3 = new Ordinateur(8,Marque.Acer);
		Ordinateur ordinateur4 = new Ordinateur(32,Marque.Dell,stagiaire3);
		Ordinateur ordinateur5 = new Ordinateur(4,Marque.HP);
		
		System.out.println(ordinateur1);
		
		Module module1 = new Module(LocalDate.parse("2024-02-23"),LocalDate.parse("2024-02-27"),1887,filiere1,matiere1,formateur1);
		Module module2 = new Module(LocalDate.parse("2024-02-28"),LocalDate.parse("2024-03-04"),3310,filiere1,matiere2,formateur1);
		Module module3 = new Module(LocalDate.parse("2024-03-06"),LocalDate.parse("2024-06-08"),8666,filiere1,matiere3,formateur1);
		Module module4 = new Module(LocalDate.parse("2024-03-11"),LocalDate.parse("2024-03-11"),3123,filiere1,matiere4,formateur1);
		Module module5 = new Module(LocalDate.parse("2024-04-29"),LocalDate.parse("2024-05-03"),1234,filiere1,matiere5);
		Module module6 = new Module(LocalDate.parse("2024-04-19"),LocalDate.parse("2024-04-26"),9598,filiere1,matiere6,formateur2);
	
		System.out.println(module6);
		
		
	}

}
