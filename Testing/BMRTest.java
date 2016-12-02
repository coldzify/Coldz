package Testing;


import static org.junit.Assert.*;

import org.junit.Test;

import Code.Calculate;

public class BMRTest {

	@Test
	public void testBMR() {
		
		Calculate cal = new Calculate();
		
		int age = 14;
		String gen = "male";
		String gen2 = "Female";
		float hei = 150;
		float wei = 50;
		double bmr = cal.getBMR(age, gen, hei, wei);
		double bmr2 = cal.getBMR(age, gen2, hei, wei);
		assertTrue(1405.8 == bmr);
		
		assertTrue(1349.2 == bmr2);
			
		
		
		//fail("Not yet implemented");
		
	}

}
