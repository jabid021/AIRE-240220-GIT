package eshop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eshop.dao.IDAOProduit;
import eshop.model.Produit;

@Service
public class ProduitService {

	@Autowired
	IDAOProduit daoProduit;
	
	public Produit getById(Integer id) 
	{
		Optional<Produit> opt = daoProduit.findById(id);
		if(opt.isEmpty()) 
		{
			return null;
		}
		else 
		{
			return opt.get();
		}
	}

	public List<Produit> getAll()
	{
		return daoProduit.findAll();
	}
	
	public Produit insert(Produit produit) 
	{
		if(produit.getLibelle().length()>30) {throw new RuntimeException("ATTENTION, le libelle doit faire - de 30 char");}

		return daoProduit.save(produit);
	}
	
	public Produit update(Produit produit) 
	{
		if(produit.getId()==null) 
		{
			throw new RuntimeException("Un update sans id ?!");
		}
		if(produit.getLibelle().length()>30) {throw new RuntimeException("ATTENTION, le libelle doit faire - de 30 char");}

		return daoProduit.save(produit);
	}
	
	public void delete(Produit produit) 
	{
		daoProduit.delete(produit);
	}
	public void deleteById(Integer id) 
	{
		daoProduit.deleteById(id);
	}
	
	public List<Produit> getByLib(String libelle)
	{
		return daoProduit.findByLib(libelle);
	}
	
	public Produit getByIdAvecVentes(Integer id) 
	{
		return daoProduit.findByIdWithVentes(id);
	}
	
	
	public List<Produit> getByLibelleContaining(String recherche)
	{
		return daoProduit.findByLibelleContaining(recherche);
	}
	
	public List<Produit> getByPrixBetween(double prixMin,double prixMax)
	{
		return daoProduit.findByPrixBetween(prixMin,prixMax);
	}
	 
	
}
