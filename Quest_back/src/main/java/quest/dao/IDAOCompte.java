package quest.dao;

import java.util.List;

import quest.model.Compte;
import quest.model.Formateur;
import quest.model.Stagiaire;

public interface IDAOCompte extends IDAO<Compte,Integer> {

	public Compte findByEmailAndPassword(String email,String password);
	public List<Formateur> findAllFormateur();
	public List<Stagiaire> findAllStagaire();
}
