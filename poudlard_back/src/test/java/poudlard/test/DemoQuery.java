package poudlard.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import poudlard.context.Singleton;
import poudlard.model.Eleve;
import poudlard.model.Maison;
import poudlard.model.Professeur;
import poudlard.model.Sorcier;

public class DemoQuery {

	public static void main(String[] args) {
		
		//SQL => Faire des requetes dans une bdd
		//JPA QL (JPQL)  => Faire des requetes sur les objets JAVA (JPA s'occupe de la traduction SQL)
		
		EntityManager em = Singleton.getInstance().getEmf().createEntityManager();
		
		//GetResultList retournera une liste 
			//Si elle trouve des elements, aucun probleme
			//Si aucun element, retourne une liste empty
		
		//GetSingleResult
			//Si la query trouve un resultat, le retourne
			//Si la query trouve PLUSIEURS resultats, => Exception
			//Si la query ne trouve rien => Exception
		
		List<Sorcier> sorciers = em.createQuery("from Sorcier").getResultList();
		
		List<Professeur> professeurs = em.createQuery("from Professeur").getResultList();
		//List<Professeur> professeurs = em.createQuery("SELECT p from Professeur p").getResultList();
		for(Sorcier s : sorciers) 
		{
			System.out.println(s.getPrenom()+" "+s.getNom()+" est un "+s.getClass().getSimpleName());
		}
		
		
		Query requete = em.createQuery("SELECT m from Maison m where m.score >:score");
		requete.setParameter("score", 50);
		List<Maison> maisons = requete.getResultList();
	
	//	List<Maison> maisons = em.createQuery("SELECT m from Maison m where m.score >?").setParameter(1, 50).getResultList();
		
		Maison rechercheMaison = null;
		
		try {
		Query requete2 = em.createQuery("SELECT m from Maison m where m.nom = :nom ");
		requete2.setParameter("nom", "Serpentard");
		rechercheMaison = (Maison) requete2.getSingleResult();
		}
		catch(Exception e) {e.printStackTrace();}
		
		
		
		if(rechercheMaison==null) 
		{
			System.out.println("Pas de maison avec ce nom  !");
		}
		else 
		{
			System.out.println("Maison trouvée ! "+rechercheMaison.getId());
		}
		System.out.println("Liste des maisons ayant + de 50 points : ");
		for(Maison m : maisons) 
		{
			System.out.println(m.getNom());
		}
		
		
		
		
		System.out.println("On cherche les maisons dont le professeur principal possède un A dans son nom");
		
		Query requete3 = em.createQuery("SELECT m from Maison m where m.professeurPrincipal.nom like :recherche");
		requete3.setParameter("recherche", "%A%");
		List<Maison> maisonsProfA = requete3.getResultList();
		for(Maison m : maisonsProfA) 
		{
			System.out.println(m.getNom());
		}
		
		
		
		
		System.out.println("------------Select en bdd une maison via son id avec TOUS ses eleves------------------");
		
		Query requete4 = em.createQuery("SELECT m from Maison m LEFT JOIN FETCH  m.residents  where m.id=:id");
		requete4.setParameter("id", 4);
		Maison maisonBdd = (Maison) requete4.getSingleResult();
		
		em.close();
		
		
		
		
		System.out.println("Dans la maison : "+maisonBdd.getNom()+" il y a "+maisonBdd.getResidents().size()+" eleves");
		System.out.println("Voici les residents : ");
		for(Eleve e : maisonBdd.getResidents()) 
		{
			System.out.println(e);
		}
		
		
	
		Singleton.getInstance().getEmf().close();

	}

}
