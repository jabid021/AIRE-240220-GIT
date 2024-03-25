package poudlard.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import poudlard.model.Apprentissage;
import poudlard.model.Eleve;
import poudlard.model.Maison;
import poudlard.model.Mascotte;
import poudlard.model.Professeur;
import poudlard.model.Sorcier;
import poudlard.model.Sort;
import poudlard.model.Stats;
import poudlard.model.heritage.Avion;
import poudlard.model.heritage.Elephant;
import poudlard.model.heritage.Lion;
import poudlard.model.heritage.Voiture;

public class Test {

	public static void main(String[] args) {

		Professeur p1 = new Professeur("Demort","Vol", new Stats(10,50),"Etre mechant");
		Professeur p2 = new Professeur("Rogue","Sevrus",new Stats(5,15),"Alchimie");
		Professeur p3 = new Professeur("Dumbledore","Albus", new Stats(50,50),"Etre mechant");
		Professeur p4 = new Professeur("McGonagall","Minerva",new Stats(5,15),"Polymorphisme");


		Maison m1 = new Maison("Gryffondor",Mascotte.Gryphon,p4);
		Maison m2 = new Maison("Serpentard",Mascotte.Serpent,p1);
		Maison m3 = new Maison("Poufsouffle",Mascotte.Blaireau,p3);
		Maison m4 = new Maison("Serdaigle",Mascotte.Aigle,p2);


		//	p1.setMaisonDontJeSuisPrincipal(m2);
		//	p2.setMaisonDontJeSuisPrincipal(m4);
		//	p3.setMaisonDontJeSuisPrincipal(m3);
		//	p4.setMaisonDontJeSuisPrincipal(m1);




		Sorcier e1 = new Eleve("Potter","Harry", new Stats(1,2),1,m1);
		Sorcier e2 = new Eleve("Granger","Hermione", new Stats(2,2),1,null);
		Sorcier e3 = new Eleve("Malefoy","Drago", new Stats(0,0),1,m2);

		Sort sort1 = new Sort("Lumos");

		Sort sort2 = new Sort("Revelio");

		Sort sort3 = new Sort("Accio");

		Sort sort4 = new Sort("Avada Kedavra");


		Apprentissage apprentissage1 = new Apprentissage(e1, sort1);
		Apprentissage apprentissage2 = new Apprentissage(e1, sort2);
		Apprentissage apprentissage3 = new Apprentissage(e1, sort3);

		Apprentissage apprentissage4 = new Apprentissage(p1, sort1);
		Apprentissage apprentissage5 = new Apprentissage(p1, sort2);
		Apprentissage apprentissage6 = new Apprentissage(p1, sort4);

		/*e1.getGrimoire().add(apprentissage1);
		e1.getGrimoire().add(apprentissage2);
		e1.getGrimoire().add(apprentissage3);

		p1.getGrimoire().add(apprentissage4);
		p1.getGrimoire().add(apprentissage5);
		p1.getGrimoire().add(apprentissage6);
		 */


		Lion simba = new Lion("simba","orange");
		Elephant dumbo = new Elephant("dumbo",true);
		Elephant babar = new Elephant("babar",false);
		
		
		Voiture v1 = new Voiture(4,"Tesla","Blanc");
		Avion avion = new Avion(0,450);
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contextJPA");

		EntityManager em = emf.createEntityManager();

		/*em.getTransaction().begin();

		em.persist(v1);
		em.persist(avion);

		em.persist(simba);
		em.persist(dumbo);
		em.persist(babar);

		em.persist(sort1);
		em.persist(sort2);
		em.persist(sort3);
		em.persist(sort4);

		em.persist(apprentissage1);
		em.persist(apprentissage2);
		em.persist(apprentissage3);
		em.persist(apprentissage4);
		em.persist(apprentissage5);
		em.persist(apprentissage6);



		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.persist(p4);

		em.persist(m1);
		em.persist(m2);
		em.persist(m3);
		em.persist(m4);

		em.persist(e1);
		em.persist(e2);
		em.persist(e3);

		em.persist(p1);
		em.persist(p2);

		em.getTransaction().commit();*/

		//System.out.println(em.createQuery("from Sorcier").getResultList());
		
		
		//System.out.println(em.createQuery("from Lion").getResultList());
		System.out.println(em.createQuery("from Vehicule").getResultList());
		
		em.close();

		emf.close();



	}

}
