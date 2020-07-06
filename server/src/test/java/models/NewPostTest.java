package models;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;

import org.junit.jupiter.api.Test;

class NewPostTest {

	@Test
	void test() {
		NewPost np=new NewPost();
		np.setDatePosted(new Timestamp(System.currentTimeMillis()));
		assertNotEquals(np.getDatePosted(),null);
		np.setMessage("Oy");
		assertEquals(np.getMessage(),"Oy");
		np.setStatusId(1);
		assertEquals(np.getStatusId(),1);
		np.setTitle("Mate");
		assertEquals(np.getTitle(),"Mate");
		np.setUsername("Lenny");
		assertEquals(np.getUsername(),"Lenny");
		NewPost np2= np;
		assertEquals(np.equals(np2),true);
		
	}

}
