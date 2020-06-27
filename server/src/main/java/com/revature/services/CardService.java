package com.revature.services;

import java.util.Collection;
import java.util.Map;

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
	
	public Collection<Card> getAllCards() {
		return cardRepository.getAllCards();
	}
	
	public Card getCardByStatusId(int ticket_status) {
		return cardRepository.getCardByStatusId(ticket_status);
	}
	
	public Card save(Card card) {
		return cardRepository.save(card);
	}

	public Card patch(Map<String, String> values) {
		int id = Integer.valueOf(values.get("id"));
		Card card = this.getCardById(id);
		
		// Replace the date resolved if provided
		if (values.containsKey("dateResolved")) {
			card.setTimestamp_resolved(values.get("dateResolved"));
		}
		
		// Replace the Ticket Status if provided
		if (values.containsKey("ticketStatus")) {
			card.setTicket_status(Integer.parseInt(values.get("ticketStatus")));
		}
		
		// Replace the admin id if provided
		if (values.containsKey("adminId")) {
			card.setAdmin_id(Integer.parseInt(values.get("adminId")));
		}
		
		
		return cardRepository.put(card);
	}
	public Card getCardById(int id) {
		return cardRepository.getCardById(id)
				.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}

}
