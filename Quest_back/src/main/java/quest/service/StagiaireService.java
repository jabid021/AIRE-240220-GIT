package quest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quest.dao.IDAOCompte;
import quest.model.Compte;
import quest.model.Stagiaire;

@Service
public class StagiaireService {
	@Autowired
	IDAOCompte daoCompte;
	
	public Stagiaire getById(Integer id) 
	{
		Optional<Compte> opt = daoCompte.findById(id);
		if(opt.isEmpty()) 
		{
			return null;
		}
		else 
		{
			return (Stagiaire) opt.get();
		}
	}

	public List<Stagiaire> getAll()
	{
		return daoCompte.findAllStagaire();
	}
	
	
	
	
	public Stagiaire insert(Stagiaire Stagiaire) 
	{
		return daoCompte.save(Stagiaire);
	}
	
	public Stagiaire update(Stagiaire Stagiaire) 
	{
		if(Stagiaire.getId()==null) 
		{
			throw new RuntimeException("Un update sans id ?!");
		}
		
		
		return daoCompte.save(Stagiaire);
	}
	
	public void delete(Stagiaire Stagiaire) 
	{
		daoCompte.delete(Stagiaire);
	}
	public void deleteById(Integer id) 
	{
		daoCompte.deleteById(id);
	}
	
	
	
}


