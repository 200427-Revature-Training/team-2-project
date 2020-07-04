package com.revature.repositories;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.entities.Card;

@Repository
public class CardRepository {
	
	@Autowired
	EntityManager em;

	//This method retrieves every row from the card table and returns them as a list of Card objects
	public List<Card> getAllCards() {
		System.out.println("repository has received request for all cards");
		Session session = em.unwrap(Session.class);
		List<Card> cards = session.createQuery("from Card", Card.class) //HQL statement to select all rows on the cards table.
			.list(); //turns the rows into a list of Cards.
			session.getTransaction();
			System.out.println("repository has retrieved all cards from db");
		return cards;
	}
	
	
	//This method saves a Card object to the database.
	@Transactional(propagation = Propagation.REQUIRED)
	public Card save(Card card) {
		System.out.println("repository has received request to save new card");
		Session session = em.unwrap(Session.class);
		session.save(card);
		System.out.println("repository has saved card");
		return card; //it also returns a copy of the card that was just saved, in case the client wants to use it.
	}

	//This method updates the columns of an existing card in the database.
	@Transactional(propagation = Propagation.REQUIRED)
	public Card update(Card card) {
		System.out.println("repository has received request to update card");
		Session session = em.unwrap(Session.class);
		session.update(card);
		System.out.println("repository has updated the card");
		return card; //it also returns a copy of the updated card, in case the client wants to use it.
	}
	
	//This method tries to find a card in the database with the provided card_id number.
	@Transactional(propagation = Propagation.REQUIRED)
	public Optional<Card> getCardById(int id) {
		System.out.println("repository has received reqeuest to get card by id");
		Session session = em.unwrap(Session.class);
		Card card = session.get(Card.class, id);
		System.out.println("repository has retrieved specified card");
		System.out.println(card);
		return Optional.ofNullable(card); //If it can't find a matching database row, it returns null.
	}
	
	
	//This method gets all the cards with a given cards.ticket_status value and returns them as a list
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Card> getCardsByTicketStatus(int ticket_Status) {
		System.out.println("repository has received request to get cards by ticket status");
		System.out.println(ticket_Status);
		Session session = em.unwrap(Session.class);
		List<Card> cards = session.createQuery("from Card where ticket_status = :ticket_Status", Card.class)
			.setParameter("ticket_Status", ticket_Status) //this HQL statement is selecting every row whose ticket_status column has the given ticket_status value.
				.list(); //then we turn them into a list to be returned.
				session.getTransaction();
				System.out.println("repository has retrieved cards");
				return cards;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public List<Card> getCardsByUser_Id(int id) {
		System.out.println("repository has received request to get cards by user id");
		Session session = em.unwrap(Session.class);
		System.out.println(id);
		List<Card> cards = session.createQuery("from Card where user_id = :user_id", Card.class) //HQL to select the card matching provided user_id.
				.setParameter("user_id", id) //user_id parameter is set to the value provided in the arg.
					.getResultList(); //converts the result into a list of Card objects.
				session.getTransaction();
				System.out.println("repository has received cards");
				System.out.println(cards);
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