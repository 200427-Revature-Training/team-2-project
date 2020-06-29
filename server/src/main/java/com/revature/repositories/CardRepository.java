package com.revature.repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.revature.models.Card;

@Repository
public class CardRepository {

	Map<Integer, Card> cards = new HashMap<>();
	
	//Initialize some cards
	{
		cards.put(1, new Card(1, 1, "Test Ticket", "Test Ticket's Message", 1));
		cards.put(2, new Card(2, 0, "Test Post", "Test Post's message", 2));
		cards.put(3, new Card(3, 1, "Test Ticket 2", "Test Ticket 2's message", 2));
	}
	public Collection<Card> getAllCards() {
		return cards.values();
	}
	
	public Optional<Card> getCardById(int id) {
		return Optional.ofNullable(cards.get(id));
	}
	
	public Card save(Card card) {
		cards.put(cards.size()+1, card);
		return card;
	}

	public Card patch(Card card) {
		cards.put(card.getId(), card);
		System.out.println(card);
		return card;
	}

	public Collection<Card> getCardsByTicketStatus(int ticketStatus) {	
			return cards
					.values()
					.stream()
					.distinct()
					.filter(status -> status.getTicketStatus()==ticketStatus)
					.collect(Collectors.toList());	
	}

}	