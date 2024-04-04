package quest.dao;

import quest.model.Ordinateur;

public interface IDAOOrdinateur extends IDAO<Ordinateur,Integer>{
	public Ordinateur findByStagiaire(Integer idStagiaire);

}
