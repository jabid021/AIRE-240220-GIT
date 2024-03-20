package poudlard.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import poudlard.model.Maison;

public abstract class Test {

	public static void main(String[] args) {
		
		Maison m1 = new Maison("Gryffondor");
		Maison m2 = new Maison("Serpentard");
		Maison m3 = new Maison("Poufsouffle");
		Maison m4 = new Maison("Serdaigle");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contextJPA");
		
		EntityManager em = emf.createEntityManager();
		
			em.getTransaction().begin();

				em.persist(m1);
				em.persist(m2);
				em.persist(m3);
				em.persist(m4);
			
			em.getTransaction().commit();

		em.close();
		emf.close();
		
	
	
	}

}
