package orchestre.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import orchestre.model.IMusicien;
import orchestre.model.Pianiste;

public class Test {

	public static void main(String[] args) {
		
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:application-context.xml");
		
		
	
		IMusicien pianiste = (IMusicien) ctx.getBean("pianiste");
		IMusicien flutiste=(IMusicien) ctx.getBean("flutiste"); 
		IMusicien guitariste=(IMusicien) ctx.getBean("guitariste");
		
		pianiste.jouer();
		flutiste.jouer();
		guitariste.jouer();
	
	}

}
