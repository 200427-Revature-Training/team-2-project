package models;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.sql.Timestamp;

import org.junit.jupiter.api.Test;

import models.Card;

class CardTest {

	@Test
	void test() {
		Card card= new Card(1,1,"Taco","Time",1,null);
		card.setAdmin_id(2);
		assertEquals(card.getAdmin_id(),2);
		File img = null;
		card.setImg(img);
		assertEquals(card.getImg(),img);
		card.setTimestamp_resolved();
		assertNotEquals(card.getTimestamp_resolved(),null);
		card.setMessage("hello");
		assertEquals(card.getMessage(),"hello");
		card.setTicket_status(2);
		assertEquals(card.getTicket_status(),2);
		card.setTitle("bop");
		assertEquals(card.getTitle(),"bop");
	}

}
