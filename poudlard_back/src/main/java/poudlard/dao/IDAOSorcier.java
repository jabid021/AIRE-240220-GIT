package poudlard.dao;

import java.util.List;

import poudlard.model.Professeur;
import poudlard.model.Sorcier;

public interface IDAOSorcier extends IDAO<Sorcier,Integer> {

	
	public List<Professeur> findAllProfesseur();
}
