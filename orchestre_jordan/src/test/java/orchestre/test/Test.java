package orchestre.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import orchestre.demo.Demo;
import orchestre.model.IMusicien;

public class Test {

	public static void main(String[] args) {
	
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:application-context.xml");
	
		IMusicien pianiste;
		IMusicien flutiste; 
		IMusicien guitariste;
		
		pianiste.jouer();
		flutiste.jouer();
		guitariste.jouer();
		
	}

}
