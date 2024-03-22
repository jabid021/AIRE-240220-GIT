package hopital.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import hopital.context.Singleton;
import hopital.dao.DAOCompte;
import hopital.dao.DAOPatient;
import hopital.dao.DAOVisite;
import hopital.model.Compte;
import hopital.model.Medecin;
import hopital.model.Patient;
import hopital.model.Secretaire;
import hopital.model.Visite;

public class App {

	static DAOCompte daoCompte = Singleton.getInstance().getDaoCompte();
	static DAOVisite daoVisite = Singleton.getInstance().getDaoVisite();
	static DAOPatient daoPatient = Singleton.getInstance().getDaoPatient();

	static LinkedList<Patient> fileAttente = new LinkedList();
	static Compte connected=null ;
	static boolean pause = false;

	public static int saisieInt(String message) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(message);
		int variable = sc.nextInt();
		return variable;
	}

	public static double saisieDouble(String message) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(message);
		return sc.nextDouble();
	}

	public static String saisieString(String message) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(message);
		return sc.nextLine();
	}
	public static boolean saisieBoolean(String message) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(message);
		return sc.nextBoolean();
	}




	private static void menuPrincipal() {
		System.out.println("\n---------Menu Hopital--------");
		System.out.println("1 - Se connecter");
		System.out.println("2 - Stop");

		int choix = saisieInt("Choisir un menu");

		switch(choix) 
		{
		case 1 : seConnecter();break;
		case 2 : System.exit(0);break;

		}

		menuPrincipal();
	}





	private static void seConnecter() {
		String login = saisieString("Saisir votre login");
		String password = saisieString("Saisir votre password");

		connected = daoCompte.findByLoginAndPassword(login, password);

		if(connected instanceof Medecin) 
		{
			int salle = saisieInt("Dans quelle salle ?");
			((Medecin) connected).setSalle(salle);
			menuMedecin();
		}
		else if(connected instanceof Secretaire) 
		{
			if(pause) 
			{
				menuSecretairePause();
			}
			else 
			{
				menuSecretaire();
			}
		}
		else 
		{
			System.out.println("Identifiants invalides");
		}

	}

	private static void menuSecretaire() {
		System.out.println("\n---------Menu Secretaire--------");
		System.out.println("1 - Recevoir un patient");
		System.out.println("2 - Consulter les anciennes visites d'un patient");
		System.out.println("3 - Afficher l'etat de la file d'attente");
		System.out.println("4 - Partir en pause");
		System.out.println("5 - Se deconnecter");

		int choix = saisieInt("Choisir un menu");
		switch(choix) 
		{
		case 1 : inscriptionPatient();break;
		case 2 : consulterVisites();break;
		case 3 : afficherFileAttente();break;
		case 4 : partirPause();break;
		case 5 : menuPrincipal();break;
		}
		menuSecretaire();
	}


	private static void partirPause() {

		File f = new File("fileAttente.txt");

		try(
				FileOutputStream fos = new FileOutputStream(f);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				)
		{
			oos.writeObject(fileAttente);
			pause=true;
			fileAttente.clear();
			menuSecretairePause();
		}
		catch(Exception e) {e.printStackTrace();
		}

	}

	private static void afficherFileAttente() {
		if(fileAttente.isEmpty()) 
		{
			System.out.println("La file d'attente est vide");
		}
		else 
		{
			for(Patient p : fileAttente) 
			{
				System.out.println(p);
			}
			if(connected instanceof Medecin) 
			{
				System.out.println("Le prochain patient est : "+fileAttente.peek());}
		}
	}

	private static void consulterVisites() {
		Integer id = saisieInt("Saisir l'id du patient");
		List<Visite> visites = daoVisite.findAllByPatient(id);
		if(visites.isEmpty()) 
		{
			System.out.println("Ce patient n'a aucune visite");
		}
		for(Visite v : visites) 
		{
			System.out.println(v);
		}
	}


	private static void inscriptionPatient() {
		Integer id = saisieInt("Saisir l'id du patient");
		Patient patient = daoPatient.findById(id);
		if(patient==null) 
		{
			System.out.println("Ce patient n'existe pas encore, creation d'une fiche :");
			String nom = saisieString("Saisir votre nom");
			String prenom = saisieString("Saisir votre prenom");
			patient = new Patient(id,nom,prenom);
			daoPatient.insert(patient);
		}

		System.out.println("Ajout du patient dans la file d'attente : "+patient);
		fileAttente.add(patient);

	}

	private static void menuSecretairePause() {
		System.out.println("\n---------Menu Secretaire PAUSE--------");
		System.out.println("1 - Revenir de pause");
		System.out.println("2 - Se deconnecter");

		int choix = saisieInt("Choisir un menu");
		switch(choix) 
		{
		case 1 : revenirPause();break;
		case 2 : menuPrincipal();break;
		}
		menuSecretairePause();
	}

	private static void revenirPause() {
		File f = new File("fileAttente.txt");

		try(
				FileInputStream fis = new FileInputStream(f);
				ObjectInputStream ois = new ObjectInputStream(fis);
				)
		{
			fileAttente = (LinkedList<Patient>) ois.readObject();
			pause=false;
			menuSecretaire();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}

	}

	private static void menuMedecin() {
		System.out.println("\n---------Menu Medecin--------");
		System.out.println("1 - Recevoir un patient");
		System.out.println("2 - Afficher l'etat de la file d'attente");
		System.out.println("3 - Sauvegarder Visites");
		System.out.println("4 - Se deconnecter");

		int choix = saisieInt("Choisir un menu");
		switch(choix) 
		{
		case 1 : recevoirPatient();break;
		case 2 : afficherFileAttente();break;
		case 3 : sauvegarderVisites();break;
		case 4 : menuPrincipal();break;
		}
		menuMedecin();
	}

	private static void sauvegarderVisites() {
		Medecin medecin = (Medecin) connected;

		if(medecin.getVisites().isEmpty()) 
		{
			System.out.println("Aucune visite à sauvegarder");
		}
		for(Visite v : medecin.getVisites()) 
		{
			daoVisite.insert(v);
			System.out.println(v);
		}
		medecin.getVisites().clear();
	}

	private static void recevoirPatient() {
		if(fileAttente.isEmpty()) 
		{
			System.out.println("Aucun patient dans la file d'attente");
		}
		else 
		{
			Patient patient = fileAttente.poll();
			Medecin medecin = (Medecin) connected;
			Visite visite = new Visite(patient,medecin);
			medecin.getVisites().add(visite);
			System.out.println("Vous recevez le patient "+patient.getNom()+" "+patient.getPrenom());
			if(medecin.getVisites().size()>=3) 
			{
				System.out.println("Sauvegarde automatique");
				sauvegarderVisites();
			}
		}

	}

	public static void main(String[] args) {
		menuPrincipal();
	}
}
