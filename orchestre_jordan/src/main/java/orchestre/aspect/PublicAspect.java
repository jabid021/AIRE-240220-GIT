package orchestre.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PublicAspect {

	@AfterReturning(pointcut = "execution(public String orchestre.model.Guitariste.toString())" ,returning = "messageToString")
	public void afterToStringGuitariste(String messageToString) 
	{
		System.out.println(messageToString);
		System.out.println("Le guitariste vient de se presenter");
	}
	
	
	//Doit se lancer avant que le guitariste joue
	public void installer(){System.out.println("Le public s'installe");}
	
	//Doit se lancer apres que le guitariste joue , si tout s’est bien passé
	public void applaudir(){System.out.println("Le public applaudit");}
	
	
	//Doit se lancer apres que le guitariste joue , s'il fait une fausse note
	public void huer(){System.out.println("Le public jette des tomates");}
}
