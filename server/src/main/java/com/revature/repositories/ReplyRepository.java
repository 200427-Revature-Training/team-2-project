package com.revature.repositories;


import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Reply;

@Repository
public class ReplyRepository {
	
	@Autowired
	EntityManager em;


	@Transactional(propagation = Propagation.REQUIRED)
	public List<Reply> getAllReplies() {
		Session session = em.unwrap(Session.class);
		List<Reply> replies = session.createQuery("from Reply", Reply.class)
			.list();
			session.getTransaction();
		return replies;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public Reply save(Reply reply) {
		Session session = em.unwrap(Session.class);
		session.save(reply);
		return reply;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public Optional<Reply> getReplyById(int id) {
		Session session = em.unwrap(Session.class);
		Reply reply = session.get(Reply.class, id);
		return Optional.ofNullable(reply);
	}
}