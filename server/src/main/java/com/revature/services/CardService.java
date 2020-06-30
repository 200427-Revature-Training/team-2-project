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
	
	public Collection<Card> getAllCards() {
		return cardRepository.getAllCards();
	}
	
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
	
	public Card updateTicket(Card card) {
		System.out.println(card);
		int patchId = card.getCard_id();
		System.out.println("card ID");
		System.out.println(patchId);
		Card fullcard = getCardById(patchId);
		System.out.println("before");
		System.out.println(fullcard);
		if (card.getAdmin_id() != 0) {
			fullcard.setAdmin_id(card.getAdmin_id());
		}
		if(card.getDate_resolved() != null) {
			fullcard.setDate_resolved(card.getDate_resolved());			
		}
		if (card.getTicket_status() != 0) {
			fullcard.setTicket_status(card.getTicket_status());			
		}
		System.out.println("after");
		System.out.println(fullcard);
		return cardRepository.save(fullcard);
	}
	public Card getCardById(int id) {
		return cardRepository.getCardById(id)
				.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}

}
