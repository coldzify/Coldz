package Testing;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Code.AuthenticationController;

public class LoginTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testLogin() {
		String user = "coldzify";
		String pass = "02788910";
		
		try {
			AuthenticationController a = new AuthenticationController();
			if(!a.login(user, pass))
				fail();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
