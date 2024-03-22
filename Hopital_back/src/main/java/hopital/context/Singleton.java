package hopital.context;

import hopital.dao.DAOCompte;
import hopital.dao.DAOPatient;
import hopital.dao.DAOVisite;

public class Singleton {
	
	
	private DAOCompte daoCompte= new DAOCompte();
	private DAOPatient daoPatient= new DAOPatient();
	private DAOVisite daoVisite= new DAOVisite();
	
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


	public DAOCompte getDaoCompte() {
		return daoCompte;
	}
	public DAOPatient getDaoPatient() {
		return daoPatient;
	}
	public DAOVisite getDaoVisite() {
		return daoVisite;
	}
	public void setDaoCompte(DAOCompte daoCompte) {
		this.daoCompte = daoCompte;
	}
	public void setDaoPatient(DAOPatient daoPatient) {
		this.daoPatient = daoPatient;
	}
	public void setDaoVisite(DAOVisite daoVisite) {
		this.daoVisite = daoVisite;
	}
	
	
	
	

}
