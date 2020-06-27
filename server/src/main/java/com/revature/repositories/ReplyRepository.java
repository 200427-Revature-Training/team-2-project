package com.revature.repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.revature.models.Reply;

@Repository
public class ReplyRepository {

	Map<Integer, Reply> replies = new HashMap<>();
	
	//Initialize some flavors
	{
		replies.put(1, new Reply(1, 1, 1, "Test Reply Message"));
		replies.put(2, new Reply(2, 2, 2, "Test Reply 2 message"));
		replies.put(3, new Reply(3, 1, 2, "Test Reply 3 message"));
	}
	
	public Collection<Reply> getAllReplies() {
		return replies.values();
	}
		
	public Reply save(Reply reply) {
		replies.put(replies.size()+1, reply);
		return reply;
	}

	public Optional<Reply> getReplyById(int id) {
		return Optional.ofNullable(replies.get(id));
	}
}