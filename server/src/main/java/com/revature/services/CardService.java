package com.revature.services;

import java.util.Collection;

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
	
	public Collection<Card> getCardsByTicketStatus(int ticketStatus) {
		return cardRepository.getCardsByTicketStatus(ticketStatus);
	}
	
	public Card save(Card card) {
		return cardRepository.save(card);
	}

	public Card updateTicket(Card card) {
		System.out.println(card);
		return cardRepository.patch(card);
	}
	public Card getCardById(int id) {
		return cardRepository.getCardById(id)
				.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
	}

}
