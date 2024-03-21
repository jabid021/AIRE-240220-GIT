package eshop.test;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import eshop.model.Adresse;
import eshop.model.Client;
import eshop.model.Fournisseur;
import eshop.model.Personne;
import eshop.model.Produit;

public class Test {

	public static void main(String[] args) {
		
		Adresse  adresse1 = new Adresse("6","rue rougemont","75009","Paris");
		Adresse  adresse2 = new Adresse("1","rue de chez moi","00001","ma ville");
		
		Client client1 = new Client("Abid","Jordan",adresse2,30,LocalDate.parse("1993-05-01"));
		Fournisseur fournisseur1 = new Fournisseur("Abid","Charly",adresse1,"AJC Ingenierie");
		
		Produit produit1 = new Produit("Formation SQL",1200,fournisseur1);
		Produit produit2 = new Produit("Formation Algo",1049.99,fournisseur1);
		
		client1.getAchats().add(produit1);
		client1.getAchats().add(produit2);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contextJPA");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
			em.persist(client1);
			em.persist(fournisseur1);
			em.persist(produit1);
			em.persist(produit2);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
	}

}
