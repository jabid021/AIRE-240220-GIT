package orchestre.model;

import org.springframework.stereotype.Component;

@Component
public class Voiture {

	private int vitesse=0;
	private boolean arret=true;
	private String marque;
	private String plaque;
	
	public Voiture() {}
	
	
	
	public Voiture(String marque, String plaque) {
		this.marque = marque;
		this.plaque = plaque;
	}


	public String getMarque() {
		return marque;
	}



	public void setMarque(String marque) {
		this.marque = marque;
	}



	public String getPlaque() {
		return plaque;
	}



	public void setPlaque(String plaque) {
		this.plaque = plaque;
	}



	public int getVitesse() {
		return vitesse;
	}

	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}

	public boolean isArret() {
		return arret;
	}

	public void setArret(boolean arret) {
		this.arret = arret;
	}

	public void faireLePlein() 
	{
		System.out.println("On fait le plein d'essence");
	}
	
	public void avancer() 
	{
		System.out.println("---La voiture avance----");
	}
	
	public String reparer(int nb) throws Exception 
	{
		
		if(nb > 50) 
		{
			return "La voiture est reparee";
		}
		else 
		{
			throw new Exception();
		}
		
		
	}
	
	public void rouler(int vitesse) {
		this.vitesse=vitesse;
		arret=false;
	}
	

}
