package com.revature.controllers;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Reply;
import com.revature.services.ReplyService;

@RestController
@RequestMapping("")
@CrossOrigin(origins = "*", 
methods = {RequestMethod.GET, RequestMethod.PUT, 
			RequestMethod.PATCH, RequestMethod.POST},
allowedHeaders = {"Content-Type"})

public class ReplyController {

	@Autowired
	ReplyService replyService;
	
	@GetMapping("/employees/replies")
	public Collection<Reply> getAllReplies() {
			return replyService.getAllReplies();

	}

	
	@GetMapping("/administrators/replies")
	public Optional<Reply> getReplyById(@RequestBody Reply reply) {
		return replyService.getReplyById(reply.getId());
	}
}
