package models;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;

import org.junit.jupiter.api.Test;

class ReactTicketModelTest {

	@Test
	void test() {
		ReactTicketModel tick=new ReactTicketModel();
		tick.setAdminFirstName("JR");
		assertEquals(tick.getAdminFirstName(),"JR");
		tick.setAdminLastName("Smith");
		assertEquals(tick.getAdminLastName(),"Smith");
		tick.setDatePosted(new Timestamp(System.currentTimeMillis()));
		assertNotEquals(tick.getDatePosted(),null);
		tick.setDateResolved(new Timestamp(System.currentTimeMillis()));
		assertNotEquals(tick.getDateResolved(),null);
		tick.setMessage("Swish");
		assertEquals(tick.getMessage(),"Swish");
		tick.setTicketId(1);
		assertEquals(tick.getTicketId(),1);
		tick.setTicketStatus(1);
		assertEquals(tick.getTicketStatus(),1);
		tick.setTitle("cross");
		assertEquals(tick.getTitle(),"cross");
		tick.setUserFirstName("Amare");
		assertEquals(tick.getUserFirstName(),"Amare");
		tick.setUserLastName("Stoudamire");
		assertEquals(tick.getUserLastName(),"Stoudamire");
		tick.setUserImage("Fire Extinguisher");
		assertEquals(tick.getUserImage(),"Fire Extinguisher");
		tick.setUserName("JR5");
		assertEquals(tick.getUserName(),"JR5");
		ReactTicketModel tick2=tick;
		assertEquals(tick.equals(tick2),true);
	}

}
