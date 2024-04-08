package orchestre.model;

import org.springframework.stereotype.Component;

@Component
public class Voiture {

	
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
	

}
