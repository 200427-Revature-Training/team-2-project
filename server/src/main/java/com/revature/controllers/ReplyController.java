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
	
	//GET all replies from database and returns them as an array of JSON objects.
	@GetMapping("/employee/replies")
	public Collection<Reply> getAllReplies() {
			return replyService.getAllReplies(); //no logic here, just a call to service when the request is received.

	}

	//GET a specific reply by its id. Expects the id to be sent in request body ( "rid": {id} )
	@GetMapping("/administrators/replies")
	public Optional<Reply> getReplyById(@RequestBody Reply reply) { //maps the id received in the request body to a Reply object.
		return replyService.getReplyById(reply.getRid()); //passes value to a service call for getting the Relpy from the database.
	}
}
