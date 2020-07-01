package com.revature.controllers;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Card;
import com.revature.services.CardService;

@RestController
@RequestMapping("")
@CrossOrigin(origins = "*", 
methods = {RequestMethod.GET, RequestMethod.PUT, 
			RequestMethod.PATCH, RequestMethod.POST},
allowedHeaders = {"Content-Type"})

public class CardController {

	@Autowired
	CardService cardService;
	
	@GetMapping("/posticket/{id}")
	public Card getCardById(@PathVariable int id) {
		return cardService.getCardById(id);
	}
	
	@GetMapping("/administrators/all-tickets")
	public Collection<Card> getAllCards() {
			return cardService.getAllCards();

	}
	
	@GetMapping("/employees/posts")
	public Collection<Card> getAllPosts() {
			return cardService.getAllCards();

	}
	
	@PatchMapping("/managers/approvals")
	public Card updateTicket(@RequestBody Card card) {
		System.out.println(card);
		return cardService.updateTicket(card);
	}
	
	@GetMapping("/ticket-status")
	public List<Card> getCardsByTicketStatus(@RequestBody Card card) {
		int ts=card.getTicket_status();
		return cardService.getCardsByTicketStatus(ts);
	}
	
	@GetMapping("/employees/post/{statusId}")
	public List<Card> getCardsByTicketStatus(@PathVariable int statusId) {
		return cardService.getCardsByTicketStatus(statusId);
	}
	
	
	@PostMapping("/employees/post")
	public Card save(@RequestBody Card card) {
		return cardService.saveNew(card);
	}
}
