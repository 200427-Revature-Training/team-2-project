package com.revature.repositories;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.entities.ReactUser;

//import org.springframework.security.crypto.bcrypt.BCrypt;

import org.hibernate.Session;

@Repository
public class ReactUserRepository {
	
	@Autowired
	EntityManager em;
	
	
//	//Saves a ReactUser object to the database as a new ruser.
//	@Transactional(propagation = Propagation.REQUIRED)
//	public ReactUser save(ReactUser ruser) {
//		Session session = em.unwrap(Session.class);
//		session.save(ruser);
//		return ruser; //returns the ReactUser object that was just saved for use by client.
//	}
	
	
	//Unused functionality to update an existing ruser. This method is never called, but it could be useful for extending functionality.
	@Transactional(propagation = Propagation.REQUIRED)
	public ReactUser update(ReactUser ruser) {
		Session session = em.unwrap(Session.class);
		session.update(ruser);
		return ruser; //returns the updated ReactUser object for use by client.
	}
	
	
	//Retrieves a ruser from the database with a uid matching the provided int value.
	@Transactional(propagation = Propagation.REQUIRED)
	public Optional<ReactUser> getReactUserById(int uid) {
		Session session = em.unwrap(Session.class);
		ReactUser ruser = session.get(ReactUser.class, uid);
		return Optional.ofNullable(ruser); //returns a ruser if one with matching uid was found. Otherwise returns null.
	}
	
	
	//Retrieves all rusers from the database as a list of ReactUser objects.
	@Transactional(propagation = Propagation.REQUIRED)
	public List<ReactUser> getAllReactUsers() {
		Session session = em.unwrap(Session.class);
		List<ReactUser> rusers = session.createQuery("from ReactUser", ReactUser.class) //HQL for grabbing everything from the rusers table of the database.
			.list(); //converts them into a list of ReactUser objects.
			session.getTransaction().commit();
		return rusers;
	}
	
	
//	//This method is used for login authorization. it compares a given uid and ruserpass to the database, and returns a ReactUser object if login is successful.
//	public ReactUser login(int uid, String ruserpass) {
//		Session session = em.unwrap(Session.class);
//		Optional<ReactUser> ruser = Optional.ofNullable(session.get(ReactUser.class, uid)); //attempts to find a ruser matching the given uid.
//		boolean access=ruser.isPresent();//validates whether a ruser can be pulled matching the rusername given.
//		if (access==true) {//authentication begins
//			ReactUser auth=ruser.get();//retrieves the ruser from the optional
//			String salt=auth.getSalt();
//			String hash=BCrypt.hashpw(ruserpass, salt);
//			String passCheck= hash+salt;
//			String passVer= BCrypt.hashpw(auth.getReactUserpass(),salt)+salt;
//			if(passVer.equals(passCheck)) { //compares the hashpw on the db with the one provided.
//				return auth; //returns ReactUser object from db if they're the same.
//				
//			} else {
//				//returns empty if hashed passwords are not identical.
//				return null;
//			}
//		} else {
//			//returns empty if no rusername matches the given uid
//			return null;
//		}
//	}
	
	
	//pulls a ruser from db with a rusername matching the one provided. This method is used by the server internally.
	@Transactional(propagation = Propagation.REQUIRED)
	public ReactUser getReactUserByReactUsername(String username) {
		Session session = em.unwrap(Session.class);
		System.out.println("Is this the crash?");
		ReactUser ruser = session.createQuery("from ReactUser where username = :username", ReactUser.class) //HQL to select the ruser matching provided rusername.
				.setParameter("username", username) //rusername parameter is set to the value provided in the arg.
					.getSingleResult(); //converts the result into a single ReactUser object.
				session.getTransaction();
				return ruser;
		
	}
}

