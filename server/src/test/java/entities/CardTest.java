package entities;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;

import org.junit.jupiter.api.Test;

class CardTest {

	@Test
	void test() {
		Card card= new Card(1,"Taco","Time",1);
		card.setAdmin_id(2);
		assertEquals(card.getAdmin_id(),2);
		card.setCard_id(2);
		assertEquals(card.getCard_id(),2);
		card.setDate_resolved(new Timestamp(System.currentTimeMillis()));
		assertNotEquals(card.getDate_resolved(),null);
		card.setEntry_time(new Timestamp(System.currentTimeMillis()));
		assertNotEquals(card.getEntry_time(),null);
		card.setMessage("hello");
		assertEquals(card.getMessage(),"hello");
		card.setTicket_status(2);
		assertEquals(card.getTicket_status(),2);
		card.setTitle("bop");
		assertEquals(card.getTitle(),"bop");
		System.out.println(card.toString());
		card.setUser_id(5);
		assertEquals(card.getUser_id(),5);
	}

}
