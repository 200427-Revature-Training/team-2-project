package entities;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import models.Reply;

class ReplyTest {

	@Test
	void test() {
		Reply reply=new Reply(1,1,1,"1");
		reply.setReplies("4th");
		Reply r=reply;
		assertEquals(reply.equals(r),true);
		assertEquals(reply.getReplies(),"4th");
		assertEquals(reply.getCard_id(),1);
		assertEquals(reply.getId(),1);
		assertEquals(reply.getUser_id(),1);
	}

}
