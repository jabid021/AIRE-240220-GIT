package eshop.context;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import eshop.dao.DAOAchat;
import eshop.dao.DAOPersonne;
import eshop.dao.DAOProduit;
import eshop.dao.IDAOAchat;
import eshop.dao.IDAOPersonne;
import eshop.dao.IDAOProduit;

public class Singleton {
	
	private IDAOAchat daoAchat = new DAOAchat();
	private IDAOProduit daoProduit = new DAOProduit();
	private IDAOPersonne daoPersonne = new DAOPersonne();
	
	
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


	public IDAOAchat getDaoAchat() {
		return daoAchat;
	}


	public void setDaoAchat(IDAOAchat daoAchat) {
		this.daoAchat = daoAchat;
	}


	public IDAOProduit getDaoProduit() {
		return daoProduit;
	}


	public void setDaoProduit(IDAOProduit daoProduit) {
		this.daoProduit = daoProduit;
	}


	public IDAOPersonne getDaoPersonne() {
		return daoPersonne;
	}


	public void setDaoPersonne(IDAOPersonne daoPersonne) {
		this.daoPersonne = daoPersonne;
	}


	public EntityManagerFactory getEmf() {
		return emf;
	}


	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}


	
	
	
	

}
