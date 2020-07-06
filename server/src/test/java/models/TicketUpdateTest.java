package models;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;

import org.junit.jupiter.api.Test;

class TicketUpdateTest {

	@Test
	void test() {
		TicketUpdate tick=new TicketUpdate();
		tick.setDateResolved(new Timestamp(System.currentTimeMillis()));
		assertNotEquals(tick.getDateResolved(),null);
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
		tick.setAdminUsername("JR5");
		assertEquals(tick.getAdminUsername(),"JR5");
		TicketUpdate tick2=tick;
		assertEquals(tick.equals(tick2),true);
	}

}
