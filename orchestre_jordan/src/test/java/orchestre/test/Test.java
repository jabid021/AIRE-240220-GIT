package orchestre.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import orchestre.demo.Demo;
import orchestre.model.IMusicien;

public class Test {
	
	@Autowired
	IMusicien guitarise;
	
	@Autowired
	IMusicien flutiste;
	
	@Autowired
	@Qualifier("pianiste")
	IMusicien musicien;
	
	
	@Autowired
	Demo obj;
	
	
	
	public static void main(String[] args) {
		
		//Pour une config principale de Spring en XML 
		//ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:application-context.xml");
		
		//Pour une config principale de Spring en Java
		//AnnotationConfigApplicationContext ctx  = new AnnotationConfigApplicationContext(AppConfig.class);
		
		//Demo obj = (Demo) ctx.getBean("monObjetDemo");
		System.out.println(obj);
		
		/*IMusicien pianiste = (IMusicien) ctx.getBean("pianiste");
		IMusicien flutiste=(IMusicien) ctx.getBean("flutiste"); 
		IMusicien guitariste=(IMusicien) ctx.getBean("guitariste");*/
		
		musicien.jouer();
		flutiste.jouer();
		guitariste.jouer();
	
	
	}

}
