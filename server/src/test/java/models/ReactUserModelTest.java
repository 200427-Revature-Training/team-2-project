package models;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ReactUserModelTest {

	@Test
	void test() {
		ReactUserModel user=new ReactUserModel();
		user.setFirstName("J");
		user.setLastName("Smith");
		user.setUserImage("Supreme Logo");
		user.setUserName("JR5");
		user.setUserRole("Buckets");
		ReactUserModel user2=user;
		assertEquals(user.equals(user2),true);
		assertEquals(user.getFirstName(),"J");
		assertEquals(user.getLastName(),"Smith");
		assertEquals(user.getUserImage(),"Supreme Logo");
		assertEquals(user.getUserName(),"JR5");
		assertEquals(user.getUserRole(),"Buckets");
	}

}
