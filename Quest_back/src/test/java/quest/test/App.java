package quest.test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import quest.dao.DAOCompte;
import quest.dao.DAOFiliere;
import quest.dao.DAOFormateur;
import quest.dao.DAOMatiere;
import quest.dao.DAOModule;
import quest.dao.DAOOrdinateur;
import quest.dao.DAOStagiaire;
import quest.model.Adresse;
import quest.model.Compte;
import quest.model.Filiere;
import quest.model.Formateur;
import quest.model.Marque;
import quest.model.Matiere;
import quest.model.Module;
import quest.model.Ordinateur;
import quest.model.Stagiaire;
public class App {


	static DAOFiliere daoFiliere = new DAOFiliere();
	static DAOMatiere daoMatiere = new DAOMatiere();
	static DAOOrdinateur daoOrdinateur = new DAOOrdinateur();
	static DAOStagiaire daoStagiaire = new DAOStagiaire();
	static DAOFormateur daoFormateur = new DAOFormateur();
	static DAOModule daoModule  = new DAOModule();
	static DAOCompte daoCompte= new DAOCompte();
	
	static Compte connected=null;
	static Integer lastIdFiliere=null;

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




	public static void menuFormateur() {
		System.out.println("\n-----------Menu Formateur----------");
		System.out.println("1 - Gestion des stagiaires");
		System.out.println("2 - Gestion des formateurs");
		System.out.println("3 - Gestion des ordinateurs");
		System.out.println("4 - Gestion des filieres");
		System.out.println("5 - Gestion des matieres");
		System.out.println("6 - Se deconnecter");

		int choix = saisieInt("Choisir un menu");

		switch(choix) 
		{
		case 1 : gestionStagiaires();break;
		case 2 : gestionFormateurs();break;
		case 3 : gestionOrdinateurs();break;
		case 4 : gestionFilieres();break;
		case 5 : gestionMatieres();break;
		case 6 : menuPrincipal();;break;
		}

		menuFormateur();
	}


	public static void gestionMatieres() {
		System.out.println("\n----------Menu Gestion des Matieres -----------");
		System.out.println("1- Afficher toutes les matieres");
		System.out.println("2- Ajouter une matiere");
		System.out.println("3- Modifier une matiere");
		System.out.println("4- Supprimer une matiere");
		System.out.println("5 - Retour");

		int choix = saisieInt("Choisir un menu");

		switch(choix) 
		{
		case 1 : afficherMatieres();break;
		case 2 : ajouterMatiere();break;
		case 3 : modifierMatiere();break;
		case 4 : supprimerMatiere();break;
		case 5 : menuFormateur();break;
		}

		gestionMatieres();
	}
	
	public static void supprimerMatiere() {

		afficherMatieres();
		Integer id = saisieInt("Saisir l'id de la matière à supprimer : ");
		daoMatiere.delete(id);

	}

	public static void modifierMatiere() {
		afficherMatieres();

		Integer id = saisieInt("Quelle matiere voulez vous modifier ?");

		String libelle = saisieString("Saisir le libelle de la matière");


		Matiere matiere = new Matiere(id,libelle);

		daoMatiere.update(matiere);

	}

	public static void ajouterMatiere() {

		String libelle = saisieString("Saisir votre libellé de formation");


		Matiere mat = new Matiere(libelle);
		daoMatiere.insert(mat);
	}

	public static void afficherMatieres() {
		List<Matiere> matieres = daoMatiere.findAll();

		if(matieres.isEmpty()) 
		{
			System.out.println("La liste des matières est vide !");
		}
		for(Matiere m : matieres) 
		{
			System.out.println(m);
		}

	}

	public static void gestionFilieres() {
		System.out.println("\n----------Menu Gestion des Filieres -----------");
		System.out.println("1- Afficher toutes les filieres");
		System.out.println("2- Ajouter une filiere");
		System.out.println("3- Modifier une filiere");
		System.out.println("4 - Gestion des modules");
		System.out.println("5- Supprimer une filiere");
		System.out.println("6 - Retour");

		int choix = saisieInt("Choisir un menu");

		switch(choix) 
		{
		case 1 : afficherFilieres();break;
		case 2 : ajouterFiliere();break;
		case 3 : modifierFiliere();break;
		case 4 : menuAvantModule();
		case 5 : supprimerFiliere();break;
		case 6 : menuFormateur();break;
		}

		gestionFilieres();

	}

	
	public static void menuAvantModule() 
	{
		afficherFilieres();
		lastIdFiliere = saisieInt("Choisir une filiere");
		gestionModules();
	}
	
	public static void gestionModules() {
		System.out.println("Gestion des modules de la filiere : "+lastIdFiliere);
		System.out.println("1 - Afficher ses modules");
		System.out.println("2 - Ajouter un module");
		System.out.println("3 - Modifier un module");
		System.out.println("4 - Supprimer un module");
		System.out.println("5 - Retour gestion des filieres");
		
		int choix = saisieInt("Choisir un menu");
		switch(choix) 
		{
		case 1 : afficherModules();break;
		case 2 : ajouterModule();break;
		case 3 : modifierModule();break;
		case 4 : supprimerModule();break;
		case 5 : gestionFilieres();break;
		}
		gestionModules();
	}

	public static void supprimerModule() {
		afficherModules();
		int id = saisieInt("Saisir l'id du module");
		daoModule.delete(id);
	}

	public static void modifierModule() {
		afficherModules();
		int idModule = saisieInt("Quel module modiier ?");
		
		Filiere filiere = daoFiliere.findById(lastIdFiliere);
		
		afficherMatieres();
		int idMatiere = saisieInt("Choisir la matiere");
		Matiere matiere = daoMatiere.findById(idMatiere);
		
		String debut = saisieString("Saisir la date de début");
		String fin = saisieString("Saisir la date de début");
		int quest = saisieInt("Saisir le code quest");
		
		String choix  = saisieString("Assigner un formateur ? y/n");
		
		Formateur formateur=null;
		if(choix.equals("y"))
		{
			afficherFormateurs();
			int idFormateur = saisieInt("Saisir l'id du formateur");
			formateur = daoFormateur.findById(idFormateur);
		}
		
		Module module = new Module(idModule,LocalDate.parse(debut),LocalDate.parse(fin),quest,filiere,matiere,formateur);
		daoModule.update(module);
	}

	public static void ajouterModule() {
		Filiere filiere = daoFiliere.findById(lastIdFiliere);
		
		afficherMatieres();
		int idMatiere = saisieInt("Choisir la matiere");
		Matiere matiere = daoMatiere.findById(idMatiere);
		
		String debut = saisieString("Saisir la date de début");
		String fin = saisieString("Saisir la date de début");
		int quest = saisieInt("Saisir le code quest");
		
		String choix  = saisieString("Assigner un formateur ? y/n");
		
		Formateur formateur=null;
		if(choix.equals("y"))
		{
			afficherFormateurs();
			int idFormateur = saisieInt("Saisir l'id du formateur");
			formateur = daoFormateur.findById(idFormateur);
		}
		
		Module module = new Module(LocalDate.parse(debut),LocalDate.parse(fin),quest,filiere,matiere,formateur);
		daoModule.insert(module);
		 
	}

	public static void afficherModules() {
		
		List<Module> modules = daoModule.findAllByFiliere(lastIdFiliere);
		if(modules.isEmpty()) 
		{
			System.out.println("La filiere ne contient aucun module");
		}
		
		for(Module m : modules) 
		{
			System.out.println(m);
		}
		
	}

	public static void afficherFilieres() {
		List<Filiere> filieres = daoFiliere.findAll();
		if(filieres.isEmpty()) 
		{
			System.out.println("Aucune filiere!");
		}
		for(Filiere f : filieres) 
		{
			System.out.println(f);
		}

	}

	public static void ajouterFiliere() {
		String libelle = saisieString("Saisir le libelle de la filiere");
		String choix = saisieString("Définir les dates ? y/n");
		LocalDate debut=null;
		LocalDate fin=null;
		if(choix.equals("y")) 
		{
			debut = LocalDate.parse(saisieString("Saisir la date de début de la filiere"));
			fin = LocalDate.parse(saisieString("Saisir la date de fin de la filiere"));
		}


		Filiere filiere = new Filiere(libelle,debut,fin);
		daoFiliere.insert(filiere);
	}

	public static void modifierFiliere() {
		afficherFilieres();
		Integer id = saisieInt("Quelle filiere modifier ?");

		String libelle = saisieString("Saisir le libelle de la filiere");
		String choix = saisieString("Définir les dates ? y/n");
		LocalDate debut=null;
		LocalDate fin=null;
		if(choix.equals("y")) 
		{
			debut = LocalDate.parse(saisieString("Saisir la date de début de la filiere"));
			fin = LocalDate.parse(saisieString("Saisir la date de fin de la filiere"));
		}


		Filiere filiere = new Filiere(id,libelle,debut,fin);
		daoFiliere.update(filiere);
	}

	public static void supprimerFiliere() {
		afficherFilieres();
		int id = saisieInt("Saisir l'id de la filiere à supprimer");
		daoFiliere.delete(id);

	}

	public static void gestionOrdinateurs() {
		System.out.println("\n----------Menu Gestion des Ordinateurs -----------");
		System.out.println("1- Afficher toutes les ordinateurs");
		System.out.println("2- Ajouter une ordinateur");
		System.out.println("3- Modifier une ordinateur");
		System.out.println("4- Supprimer une ordinateur");
		System.out.println("5 - Retour");

		int choix = saisieInt("Choisir un menu");

		switch(choix) 
		{
		case 1 : afficherOrdinateurs();break;
		case 2 : ajouterOrdinateur();break;
		case 3 : modifierOrdinateur();break;
		case 4 : supprimerOrdinateur();break;
		case 5 : menuFormateur();break;
		}

		gestionOrdinateurs();

	}

	public static void afficherOrdinateurs() {
		List<Ordinateur> ordinateurs = daoOrdinateur.findAll();
		if(ordinateurs.isEmpty()) 
		{
			System.out.println("Aucun ordinateur!");
		}
		for(Ordinateur o : ordinateurs) 
		{
			System.out.println(o);
		}

	}

	public static void ajouterOrdinateur() {

		int ram = saisieInt("Saisir la ram");
		String marque = saisieString("Choisir une marque : "+Arrays.toString(Marque.values()));
		String choix = saisieString("Affecter un stagiaire ? y/n)");
		Stagiaire stagiaire =null;
		if(choix.equals("y")) 
		{
			afficherStagiaires();
			Integer idStagiaire = saisieInt("saisir l'id du Stagiaire");
			stagiaire = daoStagiaire.findById(idStagiaire);

		}
		Ordinateur ordinateur = new Ordinateur(ram,Marque.valueOf(marque),stagiaire);
		daoOrdinateur.insert(ordinateur);
	}

	public static void modifierOrdinateur() {
		afficherOrdinateurs();
		Integer id = saisieInt("Quel ordinateur modifier ?");

		int ram = saisieInt("Saisir la ram");
		String marque = saisieString("Choisir une marque : "+Arrays.toString(Marque.values()));
		String choix = saisieString("Affecter un stagiaire ? y/n)");
		Stagiaire stagiaire =null;
		if(choix.equals("y")) 
		{
			afficherStagiaires();
			Integer idStagiaire = saisieInt("saisir l'id du Stagiaire");
			stagiaire = daoStagiaire.findById(idStagiaire);

		}
		Ordinateur ordinateur = new Ordinateur(id,ram,Marque.valueOf(marque),stagiaire);
		daoOrdinateur.update(ordinateur);

	}

	public static void supprimerOrdinateur() {
		afficherOrdinateurs();
		int id = saisieInt("Saisir l'id de l' ordinateur à supprimer");


		daoOrdinateur.delete(id);


	}



	public static void gestionFormateurs() {
		System.out.println("\n----------Menu Gestion des Formateurs -----------");
		System.out.println("1- Afficher toutes les formateurs");
		System.out.println("2- Ajouter une formateur");
		System.out.println("3- Modifier une formateur");
		System.out.println("4- Supprimer une formateur");
		System.out.println("5 - Retour");

		int choix = saisieInt("Choisir un menu");

		switch(choix) 
		{
		case 1 : afficherFormateurs();break;
		case 2 : ajouterFormateur();break;
		case 3 : modifierFormateur();break;
		case 4 : supprimerFormateur();break;
		case 5 : menuFormateur();break;
		}

		gestionFormateurs();

	}

	public static void afficherFormateurs() {
		List<Formateur> formateurs = daoFormateur.findAll();
		if(formateurs.isEmpty()) 
		{
			System.out.println("Aucun formateur");
		}
		for(Formateur f : formateurs) 
		{
			System.out.println(f);
		}
	}

	public static void ajouterFormateur() {
		String email = saisieString("Saisir l'email du formateur : ");
		String password = saisieString("Saisir son mot de passe : ");
		String prenom = saisieString("Saisir son prénom : ");
		String nom = saisieString("Saisir son nom : ");
		Double tarif = saisieDouble("Saisir son tarif : ");

		Formateur formateur = new Formateur(email,password,prenom,nom,tarif);
		daoFormateur.insert(formateur);
	}

	public static void modifierFormateur() {
		Integer id = saisieInt("Saisir l'id du formateur que vous voulez modifier : ");
		String email = saisieString("Saisir l'email du formateur : ");
		String password = saisieString("Saisir son mot de passe : ");
		String prenom = saisieString("Saisir son prénom : ");
		String nom = saisieString("Saisir son nom : ");
		Double tarif = saisieDouble("Saisir son tarif : ");

		Formateur formateur = new Formateur(id,email,password,prenom,nom,tarif);
		daoFormateur.update(formateur);

	}

	public static void supprimerFormateur() {
		Integer id = saisieInt("Saisir l'id du formateur que vous voulez supprimer : ");
		daoFormateur.delete(id);
	}

	public static void gestionStagiaires() {
		System.out.println("\n----------Menu Gestion des Stagiaires -----------");
		System.out.println("1- Afficher toutes les stagiaires");
		System.out.println("2- Ajouter une stagiaire");
		System.out.println("3- Modifier une stagiaire");
		System.out.println("4- Supprimer une stagiaire");
		System.out.println("5 - Retour");

		int choix = saisieInt("Choisir un menu");

		switch(choix) 
		{
		case 1 : afficherStagiaires();break;
		case 2 : ajouterStagiaire();break;
		case 3 : modifierStagiaire();break;
		case 4 : supprimerStagiaire();break;
		case 5 : menuFormateur();break;
		}

		gestionStagiaires();

	}


	public static void supprimerStagiaire() {
		afficherStagiaires();
		int id = saisieInt("Saisir l'id du stagiaire à supprimer");
		daoStagiaire.delete(id);

	}

	public static void modifierStagiaire() {
		afficherStagiaires();
		Integer id = saisieInt("Quel stagiaire modifier ?");

		String email = saisieString("Saisir votre email");
		String password = saisieString("Saisir votre password");
		String nom = saisieString("Saisir votre nom");
		String prenom = saisieString("Saisir votre prenom");
		String numero = saisieString("Saisir votre numéro");
		String voie = saisieString("Saisir votre voie");
		String ville = saisieString("Saisir votre ville");
		String cp = saisieString("Saisir votre cp");
		Adresse adresse= new Adresse(numero,voie,ville,cp);

		afficherFilieres();
		int idFiliere = saisieInt("Choisir votre filiere");
		Filiere filiere = daoFiliere.findById(idFiliere);

		Stagiaire stagiaire=new Stagiaire(id,email,password,nom,prenom,adresse,filiere);

		daoStagiaire.update(stagiaire);
	}

	public static void ajouterStagiaire() {


		String email = saisieString("Saisir votre email");
		String password = saisieString("Saisir votre password");
		String nom = saisieString("Saisir votre nom");
		String prenom = saisieString("Saisir votre prenom");
		String numero = saisieString("Saisir votre numéro");
		String voie = saisieString("Saisir votre voie");
		String ville = saisieString("Saisir votre ville");
		String cp = saisieString("Saisir votre cp");
		Adresse adresse= new Adresse(numero,voie,ville,cp);

		afficherFilieres();
		int idFiliere = saisieInt("Choisir votre filiere");
		Filiere filiere = daoFiliere.findById(idFiliere);


		Stagiaire stagiaire=new Stagiaire(email,password,nom,prenom,adresse,filiere);	


		daoStagiaire.insert(stagiaire);


	}

	public static void afficherStagiaires() {
		List<Stagiaire> stagiaires = daoStagiaire.findAll();
		if(stagiaires.isEmpty()) 
		{
			System.out.println("Aucun stagiaire!");
		}
		for(Stagiaire s : stagiaires) 
		{
			System.out.println(s);
		}

	}
	
	public static void menuPrincipal() 
	{
		System.out.println("\n-----------Appli Quest----------");
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
	public static void menuStagiaire() {
		System.out.println("\n------Menu Stagiaire-------");
		System.out.println("1 -  Consulter mon ordinateur");
		System.out.println("2 - Se deconnecter");
		
		int choix = saisieInt("Choisir un menu");
		switch(choix) 
		{
		case 1 : consulterOrdinateur();break;
		case 2 : menuPrincipal();break;
		}
		menuStagiaire();
	}
	
	public static void consulterOrdinateur() {
	
		Ordinateur ordinateur = daoOrdinateur.findByStagiaire(connected.getId());
		System.out.println("Voici votre ordinateur : "+ordinateur);
	}

	public static void seConnecter() {

		String email = saisieString("Saisir votre email");
		String password = saisieString("Saisir votre password");
		
		connected =  daoCompte.findByEmailAndPassword(email,password);
		
		if(connected instanceof Stagiaire) 
		{
			menuStagiaire();
		}
		else if(connected instanceof Formateur) 
		{
			menuFormateur();
		}
		else {
			System.out.println("Identifiants invalides");
		}
	}

	

	public static void main(String[] args) {


		menuPrincipal();



	}

}
