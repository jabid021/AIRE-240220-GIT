package eshop.test;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import eshop.dao.IDAOPersonne;
import eshop.model.Adresse;
import eshop.model.Client;
import eshop.model.Personne;
import eshop.model.Produit;
import eshop.service.ProduitService;

public class TestSpringJPA {

	@Autowired
	ProduitService produitService;

	@Autowired
	IDAOPersonne daoPersonne;


	public void run() 
	{
		Adresse  adresse = new Adresse("6","rue rougemont","75009","Paris");
		Personne client = new Client("Doe","Jane",adresse,42,LocalDate.parse("1982-05-01"));

		System.out.println("Voici la liste de nos produits :");
		for(Produit p : produitService.getAll()) 
		{
			System.out.println(p);
		}

		client = daoPersonne.save(client);

		System.out.println(client);

		
		System.out.println(produitService.getByLibelleContaining("SQL"));
		System.out.println("Liste des produit ayant un prix between 400 et 1100");
		System.out.println(produitService.getByPrixBetween(400, 1100));
	}
}
