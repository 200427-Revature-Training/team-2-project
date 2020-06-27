package com.revature.repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
	
	@Autowired
	EntityManager em;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public Card save(Card card) {
		Session session = em.unwrap(Session.class);
		session.save(card);
		return card;
	}
	
		public Collection<Card> getAllCards() {
			Session session = em.unwrap(Session.class);
			Card card = session.get(Card.class, card.getId());
			return cards.values();
	}
	
	public Card getCardByStatusId(int ticket_status) {
		return cards.get(ticket_status);
	}

	public Optional<Card> getCardById(int id) {
		Session session = em.unwrap(Session.class);
		Card card = session.get(Card.class, id);
		return Optional.ofNullable(card);
	}
	
	public Card patch(Card card) {
		Session session = em.unwrap(Session.class);
		session.update(card);
		return card;
	}
	
	
}