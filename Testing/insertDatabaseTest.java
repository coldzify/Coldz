package Testing;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Code.AuthenticationController;

public class insertDatabaseTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void InsertDatabasetest() {
		String user = "test1";
		String pass = "test";
		String gender = "MALE";
		int age = 22;
		int weight = 55;
		int height = 175;
		
		try {
			AuthenticationController a = new AuthenticationController();
			a.insert(user, pass, gender, age, weight, height);
			String[] s = a.getInfo("test");
			assertTrue(s[0].equals(gender));
			assertTrue(Integer.valueOf(s[1]) == age);
			assertTrue(Integer.valueOf(s[2]) == weight);
			assertTrue(Integer.valueOf(s[3]) == height);
				
	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
