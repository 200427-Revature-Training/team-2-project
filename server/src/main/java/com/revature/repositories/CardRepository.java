package com.revature.repositories;

import java.util.List;
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
	
	@Autowired
	EntityManager em;

	//This method retrieves every row from the card table and returns them as a list of Card objects
	public List<Card> getAllCards() {
		Session session = em.unwrap(Session.class);
		List<Card> cards = session.createQuery("from Card", Card.class) //HQL statement to select all rows on the cards table.
			.list(); //turns the rows into a list of Cards.
			session.getTransaction();
		return cards;
	}
	
	
	//This method saves a Card object to the database.
	@Transactional(propagation = Propagation.REQUIRED)
	public Card save(Card card) {
		Session session = em.unwrap(Session.class);
		session.save(card);
		return card; //it also returns a copy of the card that was just saved, in case the client wants to use it.
	}

	//This method updates the columns of an existing card in the database.
	@Transactional(propagation = Propagation.REQUIRED)
	public Card update(Card card) {
		Session session = em.unwrap(Session.class);
		session.update(card);
		return card; //it also returns a copy of the updated card, in case the client wants to use it.
	}
	
	//This method tries to find a card in the database with the provided card_id number.
	@Transactional(propagation = Propagation.REQUIRED)
	public Optional<Card> getCardById(int id) {
		Session session = em.unwrap(Session.class);
		Card card = session.get(Card.class, id);
		return Optional.ofNullable(card); //If it can't find a matching database row, it returns null.
	}
	
	
	//This method gets all the cards with a given cards.ticket_status value and returns them as a list
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Card> getCardsByTicketStatus(int ticket_Status) {
		Session session = em.unwrap(Session.class);
		List<Card> cards = session.createQuery("from Card where ticket_status = :ticket_Status", Card.class)
			.setParameter("ticket_Status", ticket_Status) //this HQL statement is selecting every row whose ticket_status column has the given ticket_status value.
				.list(); //then we turn them into a list to be returned.
				session.getTransaction();
				return cards;
	}

	
	// Original repository level PATCH method commented out. will be deleted once I'm sure we don't need it.
//	@Transactional(propagation = Propagation.REQUIRED)
//	public Card patch(Card card) {
//		Session session = em.unwrap(Session.class);
//		System.out.println(patchId);
//		Card fullcard = session.get(Card.class, patchId);
//		System.out.println(fullcard);
//
//		session.save(fullcard);
//		return fullcard;
//	}
}	