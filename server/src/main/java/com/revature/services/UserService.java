package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.models.User;
import com.revature.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	

	//This service method creates and applies a new user's hash and salt. it can also get rid of the original password. When it's done it sends it to repository.
	public User save(User user) {
		user.setSalt(BCrypt.gensalt());
		user.setHash(BCrypt.hashpw(user.getHash(), user.getSalt()));
//		user.setUserpass(null); //enable this line to make server throw out the password before saving the user to the database.
		return userRepository.save(user);
	}
	
	
	//No business logic for update user, just a passthrough to repository.
	public User update(User user) {
		return userRepository.update(user);
	}
	
	
	//This service method attempts to retrieve a user by ID, and returns a 404 if the attempt fails.
	public User getUserById(int id) {
			return userRepository.getUserById(id)
				.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
		}
	
	
	//This service method retrieves the User for the given username to compare the provided login details to the ones in the database
	public User login(User user) {
		User fulluser = userRepository.getUserByUsername(user.getUsername()); //calls a repository method to retrieve User object for given username, because we need the id for login.
		if (fulluser==null) {throw new HttpClientErrorException(HttpStatus.NOT_FOUND); //throws 404 status if no user with given username is in database.
		} else {
			return userRepository.login(fulluser.getUid(), user.getUserpass()); //if User object is found, sends retrieved id and provided pass to login method.
		}
	}
	
	
	//passthrough service for unused "get all users" function.
//	public List<User> getAllUsers() {
//		return userRepository.getAllUsers();
//	}
	
}
