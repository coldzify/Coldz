package Testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Code.Calculate;

public class BMITest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void BMItest() {
		Calculate c = new Calculate();
		float h = 180;
		float w = 62;
		float bmi = c.getBMI(h, w);
		
		if(w/(h/100*h/100) != bmi)
			fail();
		
	}

}
