package orchestre.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class VoitureTest {

	@BeforeClass
	public static void auDebut() 
	{
		System.out.println("Se lance avant TOUT le reste (Une seule fois)");
	}
	
	
	@Before
	public void avantChaqueTest() 
	{
		System.out.println("Se lance avant chaque test ! ");
	}
	
	@Test
	public void testCreation() 
	{
		//Etape 1 : Arrange 
		Voiture v;
		
		//Etape 2 : Act
		v = new Voiture("Toyota","AZ-974-AA");
		
		//Etape 3 : Assert
		assertNotNull(v);
		assertTrue("Toyota" ==  v.getMarque());
		assertEquals("AZ-974-AA", v.getPlaque());
		assertTrue(v.getPlaque().length()==9);
		/*if(v==null) 
		{
			fail();
		}*/
	}
	
	@Test
	public void testRouler() 
	{
		//Etape 1 : Arrange 
			Voiture v = new Voiture("Toyota","AZ-974-AA");
		//Etape 2 : Act
			v.rouler(80);
		//Etape 3 : Assert
		assertFalse(v.isArret());
		assertFalse(v.getVitesse()==0);
	}
}
