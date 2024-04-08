package orchestre.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

public class AspectDemo {

	public void startMoteur() 
	{
		System.out.println("On start le moteur");
	}
	
	public void stopMoteur() 
	{
		System.out.println("On stop le moteur");
	}
	
	
	
	public void autourPlein(ProceedingJoinPoint pj) 
	{
		stopMoteur();
		
		/// ICI LA PHRASE "On fait le plein d'essence"
		try {
			pj.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		System.out.println("On part payer");
		startMoteur() ;	
	}
	
	
	public void seLancerSiReparation(String messageDeLautreFonction) 
	{
		System.out.println("L'aspect lance cette methode si reparation OK");
		System.out.println(messageDeLautreFonction);
	}
	
	public void seLanceSiProbleme() 
	{
		System.out.println("L'aspect lance cette methode si reparation NOT OK");
	}
}
