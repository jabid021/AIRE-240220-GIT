package orchestre.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import orchestre.demo.Demo;
import orchestre.model.IMusicien;

public class Test {

	public static void main(String[] args) {
		
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:application-context.xml");
		
		
		//Demo obj = (Demo) ctx.getBean("demo");
		//System.out.println(obj);
		
		IMusicien pianiste = (IMusicien) ctx.getBean("pianiste");
		IMusicien flutiste=(IMusicien) ctx.getBean("flutiste"); 
		IMusicien guitariste=(IMusicien) ctx.getBean("guitariste");
		
		pianiste.jouer();
		flutiste.jouer();
		guitariste.jouer();
	
	
	}

}
