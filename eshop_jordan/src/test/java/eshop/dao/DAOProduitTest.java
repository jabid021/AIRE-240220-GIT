package eshop.dao;

import static org.junit.Assert.assertNotNull;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import eshop.config.AppConfig;
import eshop.model.Adresse;
import eshop.model.Fournisseur;
import eshop.model.Produit;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={ AppConfig.class })
@Transactional 
@Rollback(true) 

public class DAOProduitTest {

	@Autowired
	IDAOProduit daoProduit;	
	
	@Autowired
	IDAOPersonne daoPersonne;	
	
	@Test
	public void testInjectionIDAO() 
	{
		//Arrange
		//Act
		//Assert
		assertNotNull(daoProduit);
	}
	
	
	@Test
	public void testFindById() 
	{
		//Arrange
		Adresse  adresse1 = new Adresse("1Test","rue de chez moiTest","00001Test","ma villeTest");
		Fournisseur fournisseur = new Fournisseur("AbidTest","CharlyTest",adresse1,"AJC IngenierieTest");
		fournisseur = (Fournisseur) daoPersonne.save(fournisseur);
		Produit produit = new Produit("Formation SQLTest",1200,fournisseur);
		produit = daoProduit.save(produit);
		Integer idProduitAdd = produit.getId();
		Produit produitBdd=null;
		
		//Act
		produitBdd = daoProduit.findById(idProduitAdd);
	
		//Assert
		assertNotNull(produitBdd);	
	}
	
	@Test
	public void testInsert() 
	{
		
	}
	
	
	@Test
	public void testDelete() 
	{
		
	}
	
	
}
