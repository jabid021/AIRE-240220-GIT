package orchestre.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectDemo {

	@Pointcut("execution(public void orchestre.model.Voiture.avancer())")
	public void ciblage() {}
	
	@Before("ciblage()")
	public void startMoteur() 
	{
		System.out.println("On start le moteur");
	}
	
	@After("ciblage()")
	public void stopMoteur() 
	{
		System.out.println("On stop le moteur");
	}
	
	
	@Around("execution(public void orchestre.model.Voiture.faireLePlein())")
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
	
	@AfterReturning(pointcut = "execution(public String orchestre.model.Voiture.reparer(int))", returning = "messageDeLautreFonction")
	public void seLancerSiReparation(String messageDeLautreFonction) 
	{
		System.out.println("L'aspect lance cette methode si reparation OK");
		System.out.println(messageDeLautreFonction);
	}
	
	@AfterThrowing("execution(public String orchestre.model.Voiture.reparer(int))")
	public void seLanceSiProbleme() 
	{
		System.out.println("L'aspect lance cette methode si reparation NOT OK");
	}
}
