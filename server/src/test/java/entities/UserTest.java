package entities;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import models.User;

class UserTest {

	@Test
	public void testUser() {
		//fail("Not yet implemented");
		User user=new User(false, "Butter", "Scotch", "Cookies");
		user.setUsername("J");
		user.setPassword("R");
		user.setEmail("Smith");
		User user2=user;
		assertEquals(user.equals(user2),true);
		assertEquals(user.getEmail(),"Smith");
		assertEquals(user.getPassword(),"R");
		assertEquals(user.getUsername(),"J");
	}

}
