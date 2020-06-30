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
import com.revature.models.Reply;

@Repository
public class CardRepository {
	
	@Autowired
	EntityManager em;

	public List<Card> getAllCards() {
		Session session = em.unwrap(Session.class);
		List<Card> cards = session.createQuery("from Card", Card.class)
			.list();
			session.getTransaction();
		return cards;
	}
	
	
	@Transactional(propagation = Propagation.REQUIRED)
	public Card save(Card card) {
		Session session = em.unwrap(Session.class);
		session.save(card);
		return card;
	}

// Original Patch Method
	
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
	
	@Transactional(propagation = Propagation.REQUIRED)
	public Optional<Card> getCardById(int id) {
		Session session = em.unwrap(Session.class);
		Card card = session.get(Card.class, id);
		return Optional.ofNullable(card);
	}
	
	

		@Transactional(propagation = Propagation.REQUIRED)
		public List<Card> getCardsByTicketStatus(int ticket_Status) {
			Session session = em.unwrap(Session.class);
			List<Card> cards = session.createQuery("from Card where ticket_status = :ticket_Status", Card.class)
				.setParameter("ticket_Status", ticket_Status)
					.list();
					session.getTransaction();
					return cards;
	}



}	