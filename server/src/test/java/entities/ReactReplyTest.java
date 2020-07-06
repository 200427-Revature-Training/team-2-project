package entities;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Timestamp;

import org.junit.jupiter.api.Test;

import models.ReactReplyModel;

class ReactReplyTest {

	@Test
	void test() {
		ReactReply reply=new ReactReply();
		reply.setReplies("4th");
		assertEquals(reply.getReplies(),"4th");
		reply.setRid(1);
		assertEquals(reply.getRid(),1);
		reply.setTicketPostId(1);
		assertEquals(reply.getTicketPostId(),1);
		reply.setTimestamp(new Timestamp(System.currentTimeMillis()));
		assertNotEquals(reply.getTimestamp(),null);
		reply.setUserFirstName("JR");
		assertEquals(reply.getUserFirstName(),"JR");
		reply.setUserLastName("Smith");
		assertEquals(reply.getUserLastName(),"Smith");
		reply.setUserImage("Supreme Logo");
		assertEquals(reply.getUserImage(),"Supreme Logo");
		ReactReply rp=reply;
		assertEquals(reply.equals(rp),true);
	}

}
