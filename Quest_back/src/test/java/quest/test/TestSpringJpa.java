package quest.test;

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
		
		//daoCompte.findByEmailAndPassword("toto","titi");

	}
}
