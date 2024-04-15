package quest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quest.dao.IDAOCompte;
import quest.model.Compte;
import quest.model.Formateur;

@Service
public class FormateurService {

	@Autowired
	IDAOCompte daoCompte;
	
	public Formateur getById(Integer id) 
	{
		Optional<Compte> opt = daoCompte.findById(id);
		if(opt.isEmpty()) 
		{
			return null;
		}
		else 
		{
			return (Formateur) opt.get();
		}
	}

	public List<Formateur> getAll()
	{
		return daoCompte.findAllFormateur();
	}
	
	public Formateur insert(Formateur formateur) 
	{
		return daoCompte.save(formateur);
	}
	
	public Formateur update(Formateur formateur) 
	{
		if(formateur.getId()==null) 
		{
			throw new RuntimeException("Un update sans id ?!");
		}
		return daoCompte.save(formateur);
	}
	
	public void delete(Formateur formateur) 
	{
		daoCompte.delete(formateur);
	}
	public void deleteById(Integer id) 
	{
		daoCompte.deleteById(id);
	}
	
	
	
}
