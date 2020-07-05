package com.revature.repositories;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.entities.ReactCard;

@Repository
public class ReactCardRepository {
	
	@Autowired
	EntityManager em;

	//This method retrieves every row from the rcard table and returns them as a list of ReactCard objects
	public List<ReactCard> getAllReactCards() {
		Session session = em.unwrap(Session.class);
		List<ReactCard> rcards = session.createQuery("from ReactCard", ReactCard.class) //HQL statement to select all rows in the reactticket view.
			.list(); //turns the rows into a list of ReactCards.
			session.getTransaction();
		return rcards;
	}
	
	
	//This method saves a ReactCard object to the database.
	@Transactional(propagation = Propagation.REQUIRED)
	public ReactCard save(ReactCard rcard) {
		Session session = em.unwrap(Session.class);
		session.save(rcard);
		return rcard; //it also returns a copy of the rcard that was just saved, in case the client wants to use it.
	}

	//This method updates the columns of an existing rcard in the database.
	@Transactional(propagation = Propagation.REQUIRED)
	public ReactCard update(ReactCard rcard) {
		Session session = em.unwrap(Session.class);
		session.update(rcard);
		return rcard; //it also returns a copy of the updated rcard, in case the client wants to use it.
	}
	
	//This method tries to find a rcard in the database with the provided rcard_id number.
	@Transactional(propagation = Propagation.REQUIRED)
	public Optional<ReactCard> getReactCardById(int id) {
		Session session = em.unwrap(Session.class);
		ReactCard rcard = session.get(ReactCard.class, id);
		return Optional.ofNullable(rcard); //If it can't find a matching database row, it returns null.
	}
	
	
	//This method gets all the rcards with a given rcards.ticket_status value and returns them as a list
	@Transactional(propagation = Propagation.REQUIRED)
	public List<ReactCard> getReactCardsByTicketStatus(int ticketStatus) {
		Session session = em.unwrap(Session.class);
		List<ReactCard> rcards = session.createQuery("from ReactCard where ticketStatus = :ticketStatus", ReactCard.class)
			.setParameter("ticketStatus", ticketStatus) //this HQL statement is selecting every row whose ticket_status column has the given ticket_status value.
				.list(); //then we turn them into a list to be returned.
				session.getTransaction();
				return rcards;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public List<ReactCard> getReactCardsByUserName(String userName) {
		Session session = em.unwrap(Session.class);
		System.out.println(userName);
		List<ReactCard> rcards = session.createQuery("from ReactCard where userName = :userName", ReactCard.class) //HQL to select the rcards matching provided username.
				.setParameter("userName", userName) //username parameter is set to the value provided in the arg.
					.getResultList(); //converts the result into a list of ReactCard objects.
				session.getTransaction();
				System.out.println(rcards);
				return rcards;
						
	}
	

	
	// Original repository level PATCH method commented out. will be deleted once I'm sure we don't need it.
//	@Transactional(propagation = Propagation.REQUIRED)
//	public ReactCard patch(ReactCard rcard) {
//		Session session = em.unwrap(Session.class);
//		System.out.println(patchId);
//		ReactCard fullrcard = session.get(ReactCard.class, patchId);
//		System.out.println(fullrcard);
//
//		session.save(fullrcard);
//		return fullrcard;
//	}
}	