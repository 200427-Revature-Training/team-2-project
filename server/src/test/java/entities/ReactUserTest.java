package entities;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import models.ReactUserModel;
import models.User;

class ReactUserTest {

	@Test
	void test() {
		ReactUser user=new ReactUser();
		user.setUserFirstName("J");
		user.setUserLastName("Smith");
		user.setUserImage("Supreme Logo");
		user.setUserName("JR5");
		user.setUserRole("Buckets");
		ReactUser user2=user;
		assertEquals(user.equals(user2),true);
		assertEquals(user.getUserFirstName(),"J");
		assertEquals(user.getUserLastName(),"Smith");
		assertEquals(user.getUserImage(),"Supreme Logo");
		assertEquals(user.getUserName(),"JR5");
		assertEquals(user.getUserRole(),"Buckets");
	}

}
