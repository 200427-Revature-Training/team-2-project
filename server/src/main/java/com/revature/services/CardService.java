package com.revature.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.entities.Card;
import com.revature.entities.ReactCard;
import com.revature.entities.Card;
import com.revature.entities.User;
import com.revature.models.NewPost;
import com.revature.models.ReactTicketModel;
import com.revature.models.TicketUpdate;
import com.revature.repositories.CardRepository;
import com.revature.repositories.ReactCardRepository;
import com.revature.repositories.CardRepository;
import com.revature.repositories.UserRepository;

@Service
public class CardService {

	@Autowired
	CardRepository cardRepository;
	
	@Autowired
	ReactCardRepository reactCardRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService userService;
	
	
	public List<ReactCard> getAllReactCards() {
		return reactCardRepository.getAllReactCards();
	}
	

	//No business logic for method, passed directly to repository
	public List<ReactCard> getAllCards() {
		System.out.println("card service received request for all cards");
		return reactCardRepository.getAllReactCards();
	}
	
	//No business logic for method, passed directly to repository
	public List<ReactCard> getCardsByTicketStatus(int ticketStatus) {
		System.out.println("card service received request to get cards by ticket status");
		System.out.println(ticketStatus);
		return reactCardRepository.getReactCardsByTicketStatus(ticketStatus);
	}
	
	//Logic for creating new cards
//	public ReactCard saveNew(ReactTicketModel post) {
	public ReactCard saveNew(Card card) {
		System.out.println("card service received request to save new post");
//		System.out.println(post);
		System.out.println(card);
		
//		Card card = new Card();
//		System.out.println("new card instantiated");
//		card.setticketStatus(post.getTicketStatus());
//		card.setUser_id((userRepository.getUserByUsername(post.getUserName())).getUid());
//		card.setdatePosted(post.getDatePosted());
//		card.setTitle(post.getTitle());
//		card.setMessage(post.getMessage());
//		System.out.println("post's values transfered to new card");
//		System.out.println(card);
		
		//If a Date wasn't sent from the server, it will add the current Date here, otherwise it will use the existing Date
		Date ts=new Date(System.currentTimeMillis());
		System.out.println("Date generated");
		if (card.getdatePosted() == null) {
			card.setdatePosted(ts);
			System.out.println("Date generator invoked");
		}
		System.out.println("Date checked");
		//The database won't accept an admin ID for a user that doesn't exist, so if we catch an admin_id of 0 here we change it to a 1
		if (card.getAdmin_id() == 0) {
			card.setAdmin_id(1);
			System.out.println("nonzero admin ID invoked");
		}
		
		if (card.getUser_id() == 0) {
			card.setUser_id(1);
		}
		System.out.println("admin id checked");
		//Once those two fields have been checked, the card is ready to send to the repository
		cardRepository.save(card);
		System.out.println("card repository told to save card");
		return reactCardRepository.getReactCardById(card.getticketId())
				.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}


	//Internal mechanism for PATCH Card logic. Applies new values to existing posticket, then saves the altered version.
	public Card updateTicket(TicketUpdate ticket) {
		System.out.println("card service has received update ticket request");
		System.out.println(ticket);
		
		//grab received posticket's id as an int, then uses that to pull the existing posticket from the database as a new card
		Card fullcard = cardRepository.getCardById(ticket.getTicketId())
			.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
		System.out.println("current version of card received from db");
		
		if (ticket.getAdminUsername() != null) {
			System.out.println(ticket.getAdminUsername());
			System.out.println(userRepository.getUserByUsername(ticket.getAdminUsername()));
				User admin = userRepository.getUserByUsername(ticket.getAdminUsername());
			System.out.println("ticket admin details retrieved from db");
			
			if (admin.getUid() != 0) {
				System.out.println("provided admin id not 0, updating admin id");
				fullcard.setAdmin_id(admin.getUid());
				System.out.println("admin id updated");
			}
		} else {
			System.out.println("no admin username provided");
		}
		
		//These blocks check if the field values are something we want to put in the database.
		//If so, it feeds the getter for the received data's card field into the setter for the database card's field.

		if(ticket.getDateResolved() != null) {
			fullcard.setdateResolved(ticket.getDateResolved());			
		}
		if (ticket.getTicketStatus() != 0) {
			fullcard.setticketStatus(ticket.getTicketStatus());			
		}
		System.out.println("ticket values checked and fullcard edited if necessary");

		//Once the changes have been made, the altered card is sent to overwrite the existing database row.
		cardRepository.save(fullcard);
		System.out.println("db told to save card");
		
		return getCardById(ticket.getTicketId());
	}
	
	//If this method fails to find a card with the specified ID, it will return a 404 status instead of a card
	public Card getCardById(int id) {
		System.out.println("get card by id request received by service");
		return cardRepository.getCardById(id)
				.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}

	public List<ReactCard> getCardsByUserId(int id) {
		System.out.println("get cards by user id request received by service");
		User user = userRepository.getUserById(id)
				.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));

		
		return reactCardRepository.getReactCardsByUserName(user.getuserName());
	}

	
	public ReactTicketModel createReactTicket(Card card) {
		System.out.println("making react ticket");
		
		System.out.println(card.getUser_id());
		User user = userService.getUserById(card.getUser_id());

		System.out.println("user retrieved");

		User admin = userService.getUserById(card.getAdmin_id());

		System.out.println("admin retrieved");
		
		ReactTicketModel rcard = new ReactTicketModel();
		System.out.println("react ticket instantiated");
		rcard.setTicketId(card.getticketId());
		rcard.setTicketStatus(card.getticketStatus());
		rcard.setUserFirstName(user.getfirstName());
		rcard.setUserLastName(user.getlastName());
		rcard.setUserImage(user.getImg());
		rcard.setAdminFirstName(admin.getfirstName());
		rcard.setAdminLastName(admin.getlastName());
		rcard.setDatePosted(card.getdatePosted());
		rcard.setDateResolved(card.getdateResolved());
		rcard.setTitle(card.getTitle());
		rcard.setMessage(card.getMessage());
		System.out.println("reassignments complete");

		return rcard;
		
	}


	
}
