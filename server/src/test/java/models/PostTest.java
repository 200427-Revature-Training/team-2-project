package models;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;

import org.junit.jupiter.api.Test;

class PostTest {

	@Test
	void test() {
		Post p=new Post();
		p.setBody("Hola");
		assertEquals(p.getBody(),"Hola");
		p.setTicket_status(1);
		assertEquals(p.getTicket_status(),1);
		p.setTitle("Mate");
		assertEquals(p.getTitle(),"Mate");
		Post p2= p;
		assertEquals(p.equals(p2),true);
	}

}
