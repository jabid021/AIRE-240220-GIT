package quest.test;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import quest.dao.IDAOCompte;
import quest.dao.IDAOMatiere;
import quest.model.Matiere;

public class TestSpringJpa {

	
	@Autowired
	IDAOMatiere daoMatiere;
	
	@Autowired 
	IDAOCompte daoCompte;
	
	
	public void run() 
	{
		for(Matiere m : daoMatiere.findAll()) 
		{
			System.out.println(m);
		}
		
		 System.out.println(daoCompte.findByEmailAndPassword("stagiaire@mail.com","stagiaire"));
		 System.out.println(daoCompte.findByEmailAndPassword("toto","titi"));
	
		 System.out.println(daoMatiere.findAllByLibelleContaining("l"));
		 
		 
		 Integer idRecherche=15;
		 Optional<Matiere> optMatiere = daoMatiere.findById(idRecherche);
		 
		 if(optMatiere.isEmpty()) 
		 {
			 System.out.println("Pas de matiere "+idRecherche);
		 }
		 else 
		 {
			 Matiere matiere = optMatiere.get();
			 System.out.println(matiere);
		 }
	
	}
	
	
}
