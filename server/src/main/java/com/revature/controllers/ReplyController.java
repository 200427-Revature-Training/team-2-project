package com.revature.controllers;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entities.ReactReply;
import com.revature.entities.Reply;
import com.revature.models.ReactReplyModel;
import com.revature.services.ReplyService;

@RestController
@RequestMapping("")
@CrossOrigin(origins = "*", 
methods = {RequestMethod.GET, RequestMethod.PUT, 
		RequestMethod.PATCH, RequestMethod.POST})

public class ReplyController {

	@Autowired
	ReplyService replyService;
	
	//GET all replies from database and returns them as an array of JSON objects.
	@GetMapping("/employee/replies")
	public List<ReactReply> getAllReplies() {
		System.out.println("get all replies (employee) request received");
			List<ReactReply> rreplies = replyService.getAllReplies(); //no logic here, just a call to service when the request is received.
			System.out.println(rreplies);
			return rreplies;
			
	}
	
	//GET all replies from database and returns them as an array of JSON objects.
	@GetMapping("/administrator/replies")
	public List<ReactReply> getAllRepliesa() {
		System.out.println("get all replies (employee) request received");
			return replyService.getAllReplies(); //no logic here, just a call to service when the request is received.

	}

//	//GET a specific reply by its id. Expects the id to be sent in request body ( "rid": {id} )
//	@GetMapping("/administrator/replies")
//	public ReactReplyModel getReplyById(@RequestBody ReactReplyModel reply) {//maps the id received in the request body to a Reply object.
//		System.out.println("get all replies (admin) request received");
//		System.out.println(reply.getRid());
//		Reply dbreply = replyService.getReplyById(reply.getRid()); //passes value to a service call for getting the Relpy from the database.
//		return replyService.convertReply(dbreply);
//	}
}
