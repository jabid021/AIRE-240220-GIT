package orchestre.model;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

public class SuperMathsTest {


	@BeforeClass
	public static void lancementTest() 
	{
		System.out.println("Début des tests");
	}

	@Test
	public void creationTest() 
	{
		SuperMaths s;

		s=new SuperMaths();

		assertNotNull(s);
	}

	@Test
	public void additionnerTest() 
	{
		//Arrange
		int a=5;
		int b=1;
		SuperMaths s = new SuperMaths();
		int resultat;
		//Act
		resultat = s.additionner(a, b);
		//Assert
		assertTrue(6 == resultat);
	}

	@Test
	public void soustraireTest() 
	{
		//Arrange
		int a=6;
		int b=5;
		SuperMaths s = new SuperMaths();
		int resultat;
		//Act
		resultat = s.soustraire(a, b);
		//Assert
		assertFalse(0 == resultat);
	}

}
