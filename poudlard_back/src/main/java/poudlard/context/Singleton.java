package poudlard.context;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import poudlard.dao.DAOMaison;
import poudlard.dao.DAOSorcier;
import poudlard.dao.DAOSort;
import poudlard.dao.IDAOMaison;
import poudlard.dao.IDAOSorcier;
import poudlard.dao.IDAOSort;

public class Singleton {
	
	private IDAOSorcier daoSorcier = new DAOSorcier();
	private IDAOSort daoSort = new DAOSort();
	private IDAOMaison daoMaison = new DAOMaison();
	
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


	public EntityManagerFactory getEmf() {
		return emf;
	}


	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}


	public IDAOSorcier getDaoSorcier() {
		return daoSorcier;
	}


	public void setDaoSorcier(IDAOSorcier daoSorcier) {
		this.daoSorcier = daoSorcier;
	}


	public IDAOSort getDaoSort() {
		return daoSort;
	}


	public void setDaoSort(IDAOSort daoSort) {
		this.daoSort = daoSort;
	}


	public IDAOMaison getDaoMaison() {
		return daoMaison;
	}


	public void setDaoMaison(IDAOMaison daoMaison) {
		this.daoMaison = daoMaison;
	}


	
	
	
	

}
