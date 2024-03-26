package eshop.test;

import java.time.LocalDate;

import eshop.context.Singleton;
import eshop.dao.IDAOAchat;
import eshop.dao.IDAOPersonne;
import eshop.dao.IDAOProduit;
import eshop.model.Achat;
import eshop.model.Adresse;
import eshop.model.Client;
import eshop.model.Fournisseur;
import eshop.model.Produit;

public class TestJoinFetch {

	public static void main(String[] args) {
		
		IDAOProduit daoProduit = Singleton.getInstance().getDaoProduit();
		IDAOAchat daoAchat = Singleton.getInstance().getDaoAchat();
		IDAOPersonne daoPersonne = Singleton.getInstance().getDaoPersonne();
		
		
		Adresse  adresse1 = new Adresse("6","rue rougemont","75009","Paris");
		Adresse  adresse2 = new Adresse("1","rue de chez moi","00001","ma ville");
		
		Client client1 = new Client("Abid","Jordan",adresse2,30,LocalDate.parse("1993-05-01"));
		Client client2 = new Client("Doe","John",adresse2,30,LocalDate.parse("1993-05-01"));
		Fournisseur fournisseur1 = new Fournisseur("Abid","Charly",adresse1,"AJC Ingenierie");
		Fournisseur fournisseur2 = new Fournisseur("Titi","Toto",adresse1,"AJC Ingenierie");
		
		
		client1 = (Client) daoPersonne.save(client1);
		client2 = (Client) daoPersonne.save(client2);
		fournisseur1 = (Fournisseur) daoPersonne.save(fournisseur1);
		fournisseur2 = (Fournisseur) daoPersonne.save(fournisseur2);
		
		
		Produit produit1 = new Produit("Formation SQL",1200,fournisseur1);
		Produit produit2 = new Produit("Formation Algo",1049.99,fournisseur1);
		
		produit1 = daoProduit.save(produit1);
		produit2 = daoProduit.save(produit2);
		
		
		
		
		Achat achat1 = new Achat(client1,produit2,1);
		Achat achat2 = new Achat(client1,produit1,2);
		
		achat1 = daoAchat.save(achat1);
		daoAchat.save(achat2);
		
		//----------------BLOC 1
		
		Fournisseur fournisseurAvecProduit = daoPersonne.findByIdWithStock(fournisseur1.getId());
		
		System.out.println("Voici les produits du fournisseur "+fournisseurAvecProduit.getNom());
		for(Produit p : fournisseurAvecProduit.getStock()) 
		{
			System.out.println(p);
		}
		
		Fournisseur fournisseurSansProduit = daoPersonne.findByIdWithStock(fournisseur2.getId());
		
		if(fournisseurSansProduit.getStock().isEmpty()) 
		{
			System.out.println("Le 2e fournisseur n'a pas encore de produit dans son stock");
		}
		else 
		{
			System.out.println("ERROR, CE FOURNISSEUR N'A POURTANT PAS DE PRODUIT");
		}
		
		
		
		//----------------BLOC 2
		
		Produit produitAvecVentes = daoProduit.findByIdWithVentes(produit1.getId());
		
		System.out.println("Le produit "+produitAvecVentes.getLibelle()+" a ete vendu "+produitAvecVentes.getVentes().size()+" fois");
		
		
		
		//----------------BLOC 3
		
		System.out.println("----------Voici le recap de vos achats : -------------");
		
		Client clientAvecAchats = daoPersonne.findByIdWithAchats(client1.getId());
		
		System.out.println(clientAvecAchats.getPrenom()+", vous avez achete : ");
		for(Achat a : clientAvecAchats.getAchats()) 
		{
			System.out.println(a.getProduit().getLibelle());
		}
		
		
		Client clientSansAchats = daoPersonne.findByIdWithAchats(client2.getId());
		
		if(clientSansAchats.getAchats().isEmpty()) 
		{
			System.out.println(clientSansAchats.getNom()+" n'a rien achete !");
		}
		else 
		{
			System.out.println("ERROR, le client 2 n'a RIEN ACHETE POURTANT !");
		}
		
	}

}
