package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.entities.ReactReply;
import com.revature.entities.Reply;
import com.revature.entities.User;
import com.revature.models.ReactReplyModel;
import com.revature.repositories.ReactReplyRepository;
import com.revature.repositories.ReplyRepository;

@Service
public class ReplyService {

	@Autowired
	ReplyRepository replyRepository;
	
	@Autowired
	UserService userService;
	
	@Autowired
	ReactReplyRepository reactReplyRepository;
	
/* Nothing to see here, just a handful of passthroughs */	

	public List<ReactReply> getAllReplies() {
		System.out.println("reply service received request to get all replies");
		return reactReplyRepository.getAllReactReplies();
	}
	
	public Reply getReplyById(int id) {
		System.out.println("reply service received request to get reply by id");
		System.out.println(id);
		return replyRepository.getReplyById(id)
				.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}
	
	public Reply save(Reply reply) {
		System.out.println("service received request to save reply");
		System.out.println(reply);
		Reply dbreply = replyRepository.save(reply);
		System.out.println("service received dbreply");
		System.out.println(dbreply);
		return replyRepository.getReplyById(dbreply.getRid())
				.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}
	
	public ReactReplyModel convertReply(Reply reply) {
		
		User user = userService.getUserById(reply.getUser_id());
		
		ReactReplyModel rreply = new ReactReplyModel();
		
		rreply.setRid(reply.getRid());
		rreply.setTicketPostId(reply.getCard_id());
		rreply.setTimestamp(reply.gettimestamp());
		rreply.setUserFirstName(user.getfirstName());
		rreply.setUserLastName(user.getlastName());
		rreply.setUserImage(user.getImg());
		rreply.setReplies(reply.getReplies());
		
		
		
		
		return rreply;
	}
}