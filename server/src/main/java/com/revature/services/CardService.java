package com.revature.services;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.models.Card;
import com.revature.repositories.CardRepository;

@Service
public class CardService {

	@Autowired
	CardRepository cardRepository;

	//No business logic for method, passed directly to repository
	public Collection<Card> getAllCards() {
		return cardRepository.getAllCards();
	}
	
	//No business logic for method, passed directly to repository
	public List<Card> getCardsByTicketStatus(int ticket_Status) {
		return cardRepository.getCardsByTicketStatus(ticket_Status);
	}
	
	public Card saveNew(Card card) {
		
		Timestamp ts=new Timestamp(System.currentTimeMillis());
		if (card.getEntry_time() == null) {
			card.setEntry_time(ts);
			System.out.println("timestamp generator invoked");
		}
		if (card.getAdmin_id() == 0) {
			card.setAdmin_id(1);
			System.out.println("nonzero admin ID invoked");
		}
		return cardRepository.save(card);
	}


	//Internal mechanism for PATCH Card logic. Applies new values to existing posticket, then saves the altered version.
	public Card updateTicket(Card card) {
		
		//grab received posticket's id as an int, then uses that to pull the existing posticket from the database as a new card
		int patchId = card.getCard_id();
		Card fullcard = getCardById(patchId);
		
		//These blocks check if the field values are something we want to put in the database.
		//If so, it feeds the getter for the received data's card field into the setter for the database card's field.
		if (card.getAdmin_id() != 0) {
			fullcard.setAdmin_id(card.getAdmin_id());
		}
		if(card.getDate_resolved() != null) {
			fullcard.setDate_resolved(card.getDate_resolved());			
		}
		if (card.getTicket_status() != 0) {
			fullcard.setTicket_status(card.getTicket_status());			
		}

		//Once the changes have been made, the altered card is sent to overwrite the existing database row.
		return cardRepository.save(fullcard);
	}
	
	//
	public Card getCardById(int id) {
		return cardRepository.getCardById(id)
				.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}

}
