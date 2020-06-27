package com.revature.repositories;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.User;

import org.springframework.security.crypto.bcrypt.BCrypt;

import org.hibernate.Session;

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
	
	public Optional<User> getUserById(int id) {
		Session session = em.unwrap(Session.class);
		User user = session.get(User.class, id);
		return Optional.ofNullable(user);
	}
	boolean access;//better way?
	public Optional<User> login(String username, String password){
		Session session = em.unwrap(Session.class);
		//User user = session.get(User.class, id);
		//User user = session.get(User.class, username);
		access=false;
		Optional<User> user = Optional.ofNullable(session.get(User.class, username));
		user.ifPresent(auth -> {
			String salt=auth.getSalt();
			String hash=BCrypt.hashpw(password, salt);
			String passCheck= hash+salt;
			String passVer= BCrypt.hashpw(auth.getPassword(), salt)+salt;
			if(passVer.equals(passCheck)) {access=true;}
			else {access=false;}
		});
		if (access==true) {
			return user;
		}
		else {return null;}
	}
	
	//get user by username (for login)
	public Optional<User> getUserByUsername(String username) {
		Session session = em.unwrap(Session.class);
		User user = session.get(User.class, username);
		return Optional.ofNullable(user);
	}
}

