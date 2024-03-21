package eshop.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import eshop.model.Personne;
import eshop.model.Produit;

public class Test {

	public static void main(String[] args) {
		Personne personne1 = new Personne("Abid","Jordan");
		Personne personne2 = new Personne("Abid","Charly");
		
		Produit produit1 = new Produit("Formation SQL",1200);
		Produit produit2 = new Produit("Formation Algo",1049.99);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contextJPA");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
			em.persist(personne1);
			em.persist(personne2);
			em.persist(produit1);
			em.persist(produit2);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
		
	}

}
