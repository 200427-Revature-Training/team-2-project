package com.revature.services;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Reply;
import com.revature.repositories.ReplyRepository;

@Service
public class ReplyService {

	@Autowired
	ReplyRepository replyRepository;
	
	public Collection<Reply> getAllReplies() {
		return replyRepository.getAllReplies();
	}
	
	public Optional<Reply> getReplyById(int id) {
		return replyRepository.getReplyById(id);
	}
	
	public Reply save(Reply reply) {
		return replyRepository.save(reply);
	}
}