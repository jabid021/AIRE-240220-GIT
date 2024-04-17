package eshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eshop.dao.IDAOPersonne;
import eshop.model.Fournisseur;
import eshop.model.Personne;

@Service
public class FournisseurService {

	@Autowired
	IDAOPersonne daoFournisseur;
	
	public Fournisseur getById(Integer id) 
	{
		Optional<Personne> opt = daoFournisseur.findById(id);
		if(opt.isEmpty()) 
		{
			return null;
		}
		else 
		{
			return (Fournisseur) opt.get();
		}
	}

	public List<Fournisseur> getAll()
	{
		return daoFournisseur.findAllFournisseur();
	}
	
	public Fournisseur insert(Fournisseur fournisseur) 
	{
		
		return daoFournisseur.save(fournisseur);
	}
	
	public Fournisseur update(Fournisseur fournisseur) 
	{
		if(fournisseur.getId()==null) 
		{
			throw new RuntimeException("Un update sans id ?!");
		}
		
		return daoFournisseur.save(fournisseur);
	}
	
	public void delete(Fournisseur fournisseur) 
	{
		daoFournisseur.delete(fournisseur);
	}
	public void deleteById(Integer id) 
	{
		daoFournisseur.deleteById(id);
	}
	
	
	public Fournisseur getByIdAvecStock(Integer id) 
	{
		return daoFournisseur.findByIdWithStock(id);
	}
	
	

	 
	
}
