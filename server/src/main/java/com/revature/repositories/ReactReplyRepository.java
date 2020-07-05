package com.revature.repositories;


import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.entities.ReactReply;

@Repository
public class ReactReplyRepository {
	
	@Autowired
	EntityManager em;

	//This method fetches all rreplies from the database and returns them as an array of ReactReply objects.
	@Transactional(propagation = Propagation.REQUIRED)
	public List<ReactReply> getAllReactReplies() {
		Session session = em.unwrap(Session.class);
		List<ReactReply> rreplies = session.createQuery("from ReactReply", ReactReply.class) //HQL selects all rows in the rreply table of the databse
			.list(); //turns them into a list
			session.getTransaction();
			System.out.println("transaction successful");
		return rreplies;
	}
	
	//This method saves a rreply object to the database.
	@Transactional(propagation = Propagation.REQUIRED)
	public ReactReply save(ReactReply rreply) {
		Session session = em.unwrap(Session.class);
		session.save(rreply);
		return rreply;
	}

	//This method grabs a rreply from the database with the id matching the int it's given as an argument.
	@Transactional(propagation = Propagation.REQUIRED)
	public Optional<ReactReply> getReactReplyById(int id) {
		System.out.println(id);
		Session session = em.unwrap(Session.class);
		ReactReply rreply = session.get(ReactReply.class, id); //the id is used as a search index on the table
		System.out.println(rreply);
		return Optional.ofNullable(rreply); //returns a ReactReply object if successful and a null if not.
	}
}