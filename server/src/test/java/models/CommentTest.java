package models;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class CommentTest {

	@Test
	void test() {
		Comment comment=new Comment(1);
		ArrayList<Comment> comments = new ArrayList<Comment>();
		comment.setComments(comments);
		assertEquals(comment.getComments(),comments);
		Comment comm = new Comment(2);
		comment.addComment(comm);
		assertNotEquals(comment.getComments(),null);
		assertEquals(comment.getPost_id(),1);
		Comment comment2=comment;
		assertEquals(comment.equals(comment2),true);
	}

}
