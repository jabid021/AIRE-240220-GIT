package poudlard.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import poudlard.model.Eleve;
import poudlard.model.Maison;
import poudlard.model.Mascotte;
import poudlard.model.Professeur;
import poudlard.model.Sorcier;
import poudlard.model.Stats;

public abstract class Test {

	public static void main(String[] args) {
		
		Maison m1 = new Maison("Gryffondor",Mascotte.Gryphon);
		Maison m2 = new Maison("Serpentard",Mascotte.Serpent);
		Maison m3 = new Maison("Poufsouffle",Mascotte.Blaireau);
		Maison m4 = new Maison("Serdaigle",Mascotte.Aigle);
		
		Sorcier s1 = new Eleve("Potter","Harry", new Stats(1,2),1);
		
		Sorcier s2 = new Professeur("Demort","Vol", new Stats(10,50),"Etre mechant");
		
		Sorcier s3 = new Professeur("Rogue","Sevrus",new Stats(5,15),"Alchimie");
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contextJPA");
		
		EntityManager em = emf.createEntityManager();
		
			em.getTransaction().begin();

				em.persist(m1);
				em.persist(m2);
				em.persist(m3);
				em.persist(m4);
				
				em.persist(s1);
				em.persist(s2);
				em.persist(s3);
			
			em.getTransaction().commit();

		em.close();
	
		emf.close();
		
	
	
	}

}
