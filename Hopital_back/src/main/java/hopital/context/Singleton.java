package hopital.context;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import hopital.dao.DAOCompte;
import hopital.dao.DAOPatient;
import hopital.dao.DAOVisite;
import hopital.dao.IDAOCompte;
import hopital.dao.IDAOPatient;
import hopital.dao.IDAOVisite;

public class Singleton {
	
	
	private IDAOCompte daoCompte= new DAOCompte();
	private IDAOPatient daoPatient= new DAOPatient();
	private IDAOVisite daoVisite= new DAOVisite();
	
	
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


	public IDAOPatient getDaoPatient() {
		return daoPatient;
	}


	public void setDaoPatient(IDAOPatient daoPatient) {
		this.daoPatient = daoPatient;
	}


	public IDAOVisite getDaoVisite() {
		return daoVisite;
	}


	public void setDaoVisite(IDAOVisite daoVisite) {
		this.daoVisite = daoVisite;
	}


	public EntityManagerFactory getEmf() {
		return emf;
	}


	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	
	
	

}
