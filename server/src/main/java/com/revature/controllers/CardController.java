package com.revature.controllers;

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

import com.revature.entities.Card;
import com.revature.entities.ReactCard;
import com.revature.models.NewPost;
import com.revature.models.ReactTicketModel;
import com.revature.models.TicketUpdate;
import com.revature.services.CardService;

@RestController
@RequestMapping("")
@CrossOrigin(origins = "*", 
methods = {RequestMethod.GET, RequestMethod.PUT,
		RequestMethod.PATCH, RequestMethod.POST})

public class CardController {

	@Autowired
	CardService cardService;
	
/* START GET METHODS */
	
	
	@GetMapping("/cards")
	public List<ReactCard> getAllRCards() {
		return cardService.getAllReactCards();
	}
	
	//GET a posticket by its card_id and returns it as a JSON object.
	@GetMapping("/employee/tickets/{id}")
	public ReactTicketModel getCardById(@PathVariable int id) {
		System.out.println("request received");
//		id = 1; //enable this line to replace any received information with hardcoded value
		Card dbcard = cardService.getCardById(id); //path variable is used as an arg for method in cardService
		System.out.println("dbcard retrieved");
		return cardService.createReactTicket(dbcard);
	}
	
	//GET a list of postickets by its user_id and returns it as an array of JSON objects.
	@GetMapping("/employee/history/{id}")
	public List<ReactCard> getCardByUid(@PathVariable int id) {
		System.out.println("get card by userid request received");
		System.out.println("id set to 1");
		return cardService.getCardsByUserId(id); //path variable is used as an arg for method in cardService
	}
	
	//GET a list of postickets by its user_id and returns it as an array of JSON objects.
	@GetMapping("/employee/history")
	public List<ReactCard> getCardByUid() {
		System.out.println("get card by userid request received");
		return cardService.getCardsByUserId(1); //path variable is used as an arg for method in cardService
	}
	
	//GET all postickets and return them as an array of JSON objects.
	@GetMapping("/administrator/all")
	public List<ReactCard> getAllCardsa() {
		System.out.println("get all cards (admin) request received");
			return cardService.getAllReactCards();
	}
	
	//GET all cards with a "pending" ticket status (ticket_status=1) and returns them as an array of JSON objects.
	@GetMapping("/administrator/recent")
	public List<ReactCard> getPendingCards() {
		System.out.println("get pending cards request received");
		return cardService.getCardsByTicketStatus(1);
	}	
	
	//GET all cards with an "accepted" ticket status (ticket_status=2) and returns them as an array of JSON objects.
	@GetMapping("/administrator/accepted")
	public List<ReactCard> getAcceptedCards() {
		System.out.println("get accepted cards request received");
		return cardService.getCardsByTicketStatus(2);
	}
	
	//GET all cards with a "resolved" ticket status (ticket_status=2) and returns them as an array of JSON objects.
	@GetMapping("/employee/resolved")
	public List<ReactCard> getResolvedCards() {
		System.out.println("get resolved cards request received");
		return cardService.getCardsByTicketStatus(3);
	}
	
	
	//GET all posts and return them as an array of JSON objects.
	@GetMapping("/employee/tickets")
	public List<ReactCard> getAllCards() {
		System.out.println("get all cards (employee) request received");
			return cardService.getAllCards();
	}
	
	/* !!I'm not sure this endpoint is going to be used anymore!! */
	//GET all cards with a ticket_status whose id# is equal to the one sent in in the body of the request ( "ticket_status": {id} ) and return them as an array of JSON objects.
	@GetMapping("/ticket-status")
	public List<ReactCard> getCardsByTicketStatus(@RequestBody ReactTicketModel card) { //maps the ticket_status received in body to new Card instance
		System.out.println("request to get cards by ticket status received");
		System.out.println(card);
		int ts=card.getTicketStatus(); //extracts that value as an int
		System.out.println("status value extracted");
		System.out.println(ts);
		return cardService.getCardsByTicketStatus(ts); //uses extracted value as arg for method in cardService
	}
	
	//GET all cards with a ticket_status whose id# is equal to the one received in the path variable
	@GetMapping("/employee/post/{statusId}")
	public List<ReactCard> getCardsByTicketStatus(@PathVariable int statusId) {
		System.out.println("received request for post by status id");
		System.out.println(statusId);
		return cardService.getCardsByTicketStatus(statusId); //path variable is used as an arg for method in cardService
	}
/* END GET METHODS */	


/* START PATCH METHOD */
	
	//take in a posticket object, then PATCH the database entry for the posticket with that card_id.
	@PatchMapping("/administrator/approvals")
	public ReactTicketModel updateTicket(@RequestBody TicketUpdate ticket) {
		System.out.println("approved ticket request (admin) received");
		System.out.println(ticket);
		Card dbcard = cardService.updateTicket(ticket); //take received data as new card, then pass it as args to CardService
		System.out.println("dbcard received by controller");
		System.out.println(dbcard);
		return cardService.createReactTicket(dbcard);
	}
/* END PATCH METHOD */
	
	
/* START POST METHOD*/
	
	//POST new posticket into the database. expects to receive ticket_status, title, message, user_id. entry_time is automatically generated by the server.
	@PostMapping("/employee/post")
	public ReactCard save(@RequestBody Card post) {
		System.out.println("new post request received");
		System.out.println(post);
		ReactCard dbpost = cardService.saveNew(post); //grab received data as new card, then use it as an arg for method in cardService
//		return cardService.createReactTicket(dbpost);
		return dbpost;
	}
/* END POST METHOD*/
	
}