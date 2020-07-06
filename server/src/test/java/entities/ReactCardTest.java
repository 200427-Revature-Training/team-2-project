package entities;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;

import org.junit.jupiter.api.Test;

class ReactCardTest {

	@Test
	void test() {
		ReactCard card= new ReactCard();
		card.setAdminFirstName("JR");
		assertEquals(card.getAdminFirstName(),"JR");
		card.setAdminLastName("Smith");
		assertEquals(card.getAdminLastName(),"Smith");
		card.setDatePosted(new Timestamp(System.currentTimeMillis()));
		assertNotEquals(card.getDatePosted(),null);
		card.setDateResolved(new Timestamp(System.currentTimeMillis()));
		assertNotEquals(card.getDateResolved(),null);
		card.setMessage("hello");
		assertEquals(card.getMessage(),"hello");
		card.setTicketId(5);
		assertEquals(card.getTicketId(),5);
		card.setTicketStatus(1);
		assertEquals(card.getTicketStatus(),1);
		card.setTitle("I thought we were winning");
		assertEquals(card.getTitle(),"I thought we were winning");
		card.setUserFirstName("Amare");
		assertEquals(card.getUserFirstName(),"Amare");
		card.setUserLastName("Stoudemire");
		assertEquals(card.getUserLastName(),"Stoudemire");
		card.setUserImage("Fire Extinguisher");
		assertEquals(card.getUserImage(),"Fire Extinguisher");
		ReactCard card2=card;
		assertEquals(card.equals(card2),true);
		System.out.println(card.toString());
		System.out.println(card.hashCode());
	}

}
