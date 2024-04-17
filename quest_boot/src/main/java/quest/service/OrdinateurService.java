package quest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import quest.dao.IDAOOrdinateur;
import quest.model.Ordinateur;

@Service
public class OrdinateurService {

	@Autowired
	IDAOOrdinateur daoOrdinateur;
	
	public Ordinateur getById(Integer id) 
	{
		Optional<Ordinateur> opt = daoOrdinateur.findById(id);
		if(opt.isEmpty()) 
		{
			return null;
		}
		else 
		{
			return opt.get();
		}
	}

	public List<Ordinateur> getAll()
	{
		return daoOrdinateur.findAll();
	}
	
	public Ordinateur insert(Ordinateur ordinateur) 
	{
		if(ordinateur.getStagiaire().getId()==null) 
		{
			ordinateur.setStagiaire(null);
		}
		return daoOrdinateur.save(ordinateur);
	}
	
	public Ordinateur update(Ordinateur ordinateur) 
	{
		
		if(ordinateur.getId()==null) 
		{
			throw new RuntimeException("Un update sans id ?!");
		}
		if(ordinateur.getStagiaire()!=null &&  ordinateur.getStagiaire().getId()==null) 
		{
			ordinateur.setStagiaire(null);
		}
		return daoOrdinateur.save(ordinateur);
	}
	
	public void delete(Ordinateur ordinateur) 
	{
		daoOrdinateur.delete(ordinateur);
	}
	public void deleteById(Integer id) 
	{
		daoOrdinateur.deleteById(id);
	}
	
	
	
}
