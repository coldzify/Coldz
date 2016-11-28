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
		
			if(66+(13.7*wei)+(5*hei)-(6.8*age)!=bmr){
				System.out.println(66+(13.7*wei)+(5*hei)-(6.8*age));
				System.out.println(bmr);
				fail();
			}
		
			if(665+(9.6*wei)+(1.8*hei)-(4.7*age)!=bmr2){
				System.out.println(665+(9.6*wei)+(1.8*hei)-(4.7*age));
				System.out.println(bmr2);
				fail();
				
			}
		
		
		//fail("Not yet implemented");
		
	}

}
