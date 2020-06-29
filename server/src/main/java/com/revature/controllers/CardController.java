package com.revature.controllers;

import java.util.Collection;

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
	public Collection<Card> getCardsByTicketStatus(@RequestBody Card card) {
		return cardService.getCardsByTicketStatus(card.getTicketStatus());
	}
	
	@GetMapping("/employees/post/{statusId}")
	public Collection<Card> getCardsByTicketStatus(@PathVariable int statusId) {
		return cardService.getCardsByTicketStatus(statusId);
	}
	
	
	@PostMapping("/employees/post")
	public Card save(@RequestBody Card card) {
		return cardService.save(card);
	}
}
