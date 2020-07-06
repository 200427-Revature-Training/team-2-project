package models;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserTest {

	@Test
	public void testUser() {
		User user=new User(false, "Butter", "Scotch", "Cookies");
		user.setUsername("J");
		user.setPassword("R");
		user.setEmail("Smith");
		assertEquals(user.getEmail(),"Smith");
		assertEquals(user.getPassword(),"R");
		assertEquals(user.getUsername(),"J");
		User user2=user;
		assertEquals(user.equals(user2),true);
	}
	

}
