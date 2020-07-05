package com.revature.repositories;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.entities.User;

import org.springframework.security.crypto.bcrypt.BCrypt;

import org.hibernate.Session;

@Repository
public class UserRepository {
	
	@Autowired
	EntityManager em;
	
	
	//Saves a User object to the database as a new user.
	@Transactional(propagation = Propagation.REQUIRED)
	public User save(User user) {
		System.out.println("repository saving user");
		Session session = em.unwrap(Session.class);
		session.save(user);
		System.out.println("repository save user completed");
		return user; //returns the User object that was just saved for use by client.
	}
	
	
	//Unused functionality to update an existing user. This method is never called, but it could be useful for extending functionality.
	@Transactional(propagation = Propagation.REQUIRED)
	public User update(User user) {
		System.out.println("repository updating user");
		Session session = em.unwrap(Session.class);
		session.update(user);
		System.out.println("repository has updated user");
		return user; //returns the updated User object for use by client.
	}
	
	
	//Retrieves a user from the database with a uid matching the provided int value.
	@Transactional(propagation = Propagation.REQUIRED)
	public Optional<User> getUserById(int uid) {
		System.out.println("repository getting user by id");
		System.out.println(uid);
		Session session = em.unwrap(Session.class);
		User user = session.get(User.class, uid);
		System.out.println("db call complete");
		System.out.println(user);
		return Optional.ofNullable(user); //returns a user if one with matching uid was found. Otherwise returns null.
	}
	
	
	//Retrieves all users from the database as a list of User objects.
	@Transactional(propagation = Propagation.REQUIRED)
	public List<User> getAllUsers() {
		System.out.println("repository getting all users from db");
		Session session = em.unwrap(Session.class);
		List<User> users = session.createQuery("from User", User.class) //HQL for grabbing everything from the users table of the database.
			.list(); //converts them into a list of User objects.
			session.getTransaction().commit();
			System.out.println("repository retrieved user list from db");
		return users;
	}
	
	
	//This method is used for login authorization. it compares a given uid and userpass to the database, and returns a User object if login is successful.
	public User login(int uid, String userpass) {
		System.out.println("repository received login request");
		Session session = em.unwrap(Session.class);
		Optional<User> user = Optional.ofNullable(session.get(User.class, uid)); //attempts to find a user matching the given uid.
		boolean access=user.isPresent();//validates whether a user can be pulled matching the username given.
		if (access==true) {//authentication begins
			User auth=user.get();//retrieves the user from the optional
			String salt=auth.getSalt();
			String hash=BCrypt.hashpw(userpass, salt);
			String passCheck= hash+salt;
			String passVer= BCrypt.hashpw(auth.getuserPassword(),salt)+salt;
			System.out.println("login request complete. resolving");
			if(passVer.equals(passCheck)) { //compares the hashpw on the db with the one provided.
				return auth; //returns User object from db if they're the same.
				
			} else {
				//returns empty if hashed passwords are not identical.
				return null;
			}
		} else {
			//returns empty if no username matches the given uid
			return null;
		}
	}
	
	
	//pulls a user from db with a username matching the one provided. This method is used by the server internally.
	@Transactional(propagation = Propagation.REQUIRED)
	public User getUserByUsername(String username) {
		System.out.println("repository received get user by username request");
		System.out.println(username);
		Session session = em.unwrap(Session.class);
		User user = session.createQuery("from User where username = :username", User.class) //HQL to select the user matching provided username.
				.setParameter("username", username) //username parameter is set to the value provided in the arg.
				.getSingleResult(); //converts the result into a single User object.
		session.getTransaction();
		return user;
		
	}
}
