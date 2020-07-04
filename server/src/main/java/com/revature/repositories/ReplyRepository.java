package com.revature.repositories;


import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.entities.Reply;

@Repository
public class ReplyRepository {
	
	@Autowired
	EntityManager em;

	//This method fetches all replies from the database and returns them as an array of Reply objects.
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Reply> getAllReplies() {
		System.out.println("repository received request for all replies");
		Session session = em.unwrap(Session.class);
		List<Reply> replies = session.createQuery("from Reply", Reply.class) //HQL selects all rows in the reply table of the databse
			.list(); //turns them into a list
			session.getTransaction();
			System.out.println("repository has retrieved replies from db");
		return replies;
	}
	
	//This method saves a reply object to the database.
	@Transactional(propagation = Propagation.REQUIRED)
	public Reply save(Reply reply) {
		System.out.println("repository has received request to save reply");
		Session session = em.unwrap(Session.class);
		session.save(reply);
		System.out.println("reply saved");
		return reply;
	}

	//This method grabs a reply from the database with the id matching the int it's given as an argument.
	@Transactional(propagation = Propagation.REQUIRED)
	public Optional<Reply> getReplyById(int id) {
		System.out.println("repository has received request to get reply by id");
		Session session = em.unwrap(Session.class);
		Reply reply = session.get(Reply.class, id); //the id is used as a search index on the table
		System.out.println("request received");
		return Optional.ofNullable(reply); //returns a Reply object if successful and a null if not.
	}
}