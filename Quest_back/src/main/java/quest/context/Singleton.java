package quest.context;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import quest.dao.DAOCompte;
import quest.dao.DAOFiliere;
import quest.dao.DAOMatiere;
import quest.dao.DAOModule;
import quest.dao.DAOOrdinateur;
import quest.dao.IDAOCompte;
import quest.dao.IDAOFiliere;
import quest.dao.IDAOMatiere;
import quest.dao.IDAOModule;
import quest.dao.IDAOOrdinateur;

public class Singleton {
	
	private IDAOCompte daoCompte = new DAOCompte();
	private IDAOMatiere daoMatiere = new DAOMatiere();
	private IDAOModule daoModule = new DAOModule();
	private IDAOFiliere daoFiliere = new DAOFiliere();
	private IDAOOrdinateur daoOrdinateur = new DAOOrdinateur();

	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("contextJPA");
	
	private static Singleton instance;
	
	private Singleton() {}
	
	
	public static Singleton getInstance() {
		if(instance==null) 
		{
			instance = new Singleton();
		}
		return instance;
	}
	public static void setInstance(Singleton instance) {
		Singleton.instance = instance;
	}


	


	public IDAOCompte getDaoCompte() {
		return daoCompte;
	}


	public void setDaoCompte(IDAOCompte daoCompte) {
		this.daoCompte = daoCompte;
	}


	public IDAOMatiere getDaoMatiere() {
		return daoMatiere;
	}


	public void setDaoMatiere(IDAOMatiere daoMatiere) {
		this.daoMatiere = daoMatiere;
	}


	public IDAOModule getDaoModule() {
		return daoModule;
	}


	public void setDaoModule(IDAOModule daoModule) {
		this.daoModule = daoModule;
	}


	public IDAOFiliere getDaoFiliere() {
		return daoFiliere;
	}


	public void setDaoFiliere(IDAOFiliere daoFiliere) {
		this.daoFiliere = daoFiliere;
	}


	public IDAOOrdinateur getDaoOrdinateur() {
		return daoOrdinateur;
	}


	public void setDaoOrdinateur(IDAOOrdinateur daoOrdinateur) {
		this.daoOrdinateur = daoOrdinateur;
	}


	public EntityManagerFactory getEmf() {
		return emf;
	}


	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	
	
	

}
