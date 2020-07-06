package models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Ticket_StatusTest {

	@Test
	void test() {
		Ticket_Status ts= new Ticket_Status("rej");
		assertEquals(ts.getStatus(),"rej");
		Ticket_Status ts2=ts;
		assertEquals(ts.equals(ts2), true);
	}

}
