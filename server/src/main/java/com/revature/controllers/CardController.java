package com.revature.controllers;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@PatchMapping("managers/approvals/")
	public Card patch(@RequestBody Map<String, String> values) {
		return cardService.patch(values);
	}
	
	@GetMapping("/{ticket_status}")
	public Card getCardByStatusId(@PathVariable int ticket_status) {
		return cardService.getCardByStatusId(ticket_status);
	}
}
