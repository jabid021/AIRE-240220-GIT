package eshop.test;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import eshop.dao.IDAOPersonne;
import eshop.dao.IDAOProduit;
import eshop.model.Adresse;
import eshop.model.Client;
import eshop.model.Personne;
import eshop.model.Produit;

public class TestSpringJPA {

	@Autowired
	IDAOProduit daoProduit;
	
	@Autowired

	IDAOPersonne daoPersonne;
	
 
	public void run() 
	{
		Adresse  adresse = new Adresse("6","rue rougemont","75009","Paris");
		Personne client = new Client("Doe","Jane",adresse,42,LocalDate.parse("1982-05-01"));

		System.out.println("Voici la liste de nos produits :");
		for(Produit p : daoProduit.findAll()) 
		{
			System.out.println(p);
		}

		client = daoPersonne.save(client);
		
		System.out.println(client);

	}
}
