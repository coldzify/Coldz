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
	public void Swimingtest() {
		Calculate c = new Calculate();
		int overCal = 300;
		assertEquals((int)Math.ceil(((60*overCal)/400)),c.getSwimMinutes(overCal));
		
	}
	@Test
	public void Walkingtest() {
		Calculate c = new Calculate();
		int overCal = 300;
		assertEquals((int)Math.ceil(((60*overCal)/300)),c.getWalkMinutes(overCal));
		
	}
	@Test
	public void Runningtest() {
		Calculate c = new Calculate();
		int overCal = 300;
		assertEquals((int) Math.ceil(((60*overCal)/600)),c.getRunMinutes(overCal));
		
	}
	

}
