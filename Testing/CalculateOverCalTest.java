package Testing;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Code.Calculate;

public class CalculateOverCalTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void Bicycletest() {
		Calculate c = new Calculate();
		double overCal = 300;
		int minutes = c.getBikeMinutes(overCal);
		assertEquals(45,minutes);
		
	}
	@Test
	public void Walkingtest() {
		Calculate c = new Calculate();
		double overCal = 300;
		int minutes = c.getWalkMinutes(overCal);
		assertEquals(60,minutes);
		
	}
	@Test
	public void Runningtest() {
		Calculate c = new Calculate();
		double overCal = 300;
		int minutes = c.getRunMinutes(overCal);
		assertEquals(30,minutes);
		
	}
	

}
