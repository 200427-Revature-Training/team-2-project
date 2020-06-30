package com.revature.repositories;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.security.crypto.bcrypt.BCrypt;

import org.hibernate.Session;

import com.revature.models.Card;
import com.revature.models.User;

/**
 * Transaction Propagation Levels
 * 
 * REQUIRED - Will use existing transaction or create a one if one does not exist.
 * MANDATORY - Will use existing transaction or throw an error if one does not exist.
 * SUPPORTS - Will use existing transaction or execute non-transactionally if one does not exist.
 * NEVER - Will throw an exception if there is a transaction, executes non-transactionally if one
 * 			does not exist.
 * REQUIRE_NEW - Will always create a new transaction, even if one exists.
 * NESTED - Creates transaction within current transaction and operates on that transaction.
 * NOT_SUPPORTED - Will ignore transactions ongoing and execute non-transactionally.
 * 
 */

@Repository
public class UserRepository {
	
	
	@Autowired
	EntityManager em;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public User save(User user) {
		Session session = em.unwrap(Session.class);
		session.save(user);
		return user;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public User update(User user) {
		Session session = em.unwrap(Session.class);
		session.update(user);
		return user;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public Optional<User> getUserById(int uid) {
		Session session = em.unwrap(Session.class);
		User user = session.get(User.class, uid);
		System.out.println(session.get(User.class, uid));
		return Optional.ofNullable(user);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		Session session = em.unwrap(Session.class);
		List<User> users = session.createQuery("from User", User.class)
			.list();
			session.getTransaction().commit();
		return users;
	}
	
	public User login(String username, String userpass){
		Session session = em.unwrap(Session.class);
		Optional<User> user = Optional.ofNullable(session.get(User.class, username));
		boolean access=user.isPresent();//validates whether a user can be pulled matching the username given
		if (access==true) {//authentication begins
			User auth=user.get();//retrieves the user from the optional
			String salt=auth.getSalt();
			String hash=BCrypt.hashpw(userpass, salt);
			String passCheck= hash+salt;
			String passVer= BCrypt.hashpw(auth.getUserpass(),salt)+salt;
			if(passVer.equals(passCheck)) {return auth;}
			else {return null;}
		}
		else{return null;}//if the object is empty no usernames match the description
	}
}

