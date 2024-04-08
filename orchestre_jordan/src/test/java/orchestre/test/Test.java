package orchestre.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import orchestre.demo.Demo;
import orchestre.model.IMusicien;

public class Test {
	
	public static void main(String[] args) {
		
		//Pour une config principale de Spring en XML 
		//ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:application-context.xml");
		
		//Pour une config principale de Spring en Java
		AnnotationConfigApplicationContext ctx  = new AnnotationConfigApplicationContext(AppConfig.class);
		
		Demo obj = (Demo) ctx.getBean("monObjetDemo");
		System.out.println(obj);
		
		IMusicien pianiste = (IMusicien) ctx.getBean("pianiste");
		IMusicien flutiste=(IMusicien) ctx.getBean("flutiste"); 
		IMusicien guitariste=(IMusicien) ctx.getBean("guitariste");
		
		pianiste.jouer();
		flutiste.jouer();
		guitariste.jouer();
	
	
	}

}
