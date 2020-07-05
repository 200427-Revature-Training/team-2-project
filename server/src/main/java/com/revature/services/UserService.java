package com.revature.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.entities.User;
import com.revature.models.ReactUserModel;
import com.revature.repositories.ReactUserRepository;
import com.revature.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ReactUserRepository reactUserRepository;
	

	//This service method creates and applies a new user's hash and salt. it can also get rid of the original password. When it's done it sends it to repository.
	public User save(User user) {
		System.out.println("user service attempting to register new user");
		user.setSalt(BCrypt.gensalt());
		user.setHash(BCrypt.hashpw(user.getHash(), user.getSalt()));
		System.out.println("hash and salt set");
//		user.setUserpass(null); //enable this line to make server throw out the password before saving the user to the database.
		user.setUser_type(0);
		User dbuser = userRepository.save(user);
		System.out.println("user saved in repository");
		System.out.println(dbuser);
		return userRepository.getUserById(dbuser.getUid())
				.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));

		}
	
	
	//No business logic for update user, just a passthrough to repository.
	public User update(User user) {
		System.out.println("user service attempting to update user");
		User dbuser = userRepository.update(user);
		System.out.println("user service has updated user");
		System.out.println(dbuser);
		return userRepository.getUserById(dbuser.getUid())
				.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));

		}
	
	
	//This service method attempts to retrieve a user by ID, and returns a 404 if the attempt fails.
	public User getUserById(int id) {
		System.out.println("user service attempting to get id");
		System.out.println(id);
			return userRepository.getUserById(id)
					.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));

			}
	
	
	//This service method retrieves the User for the given username to compare the provided login details to the ones in the database
	public User login(User user) {
		System.out.println("user service attempting to log user in");
		User fulluser = userRepository.getUserByUsername(user.getuserName()); //calls a repository method to retrieve User object for given username, because we need the id for login.
		System.out.println("fulluser received by service");
		if (fulluser==null) {
			System.out.println("received fulluser is null");
			throw new HttpClientErrorException(HttpStatus.NOT_FOUND); //throws 404 status if no user with given username is in database.
		} else {
			System.out.println(fulluser);
			User loginuser = userRepository.login(fulluser.getUid(), user.getuserPassword()); //if User object is found, sends retrieved id and provided pass to login method.
			System.out.println("user repository login complete");
			User dbuser = userRepository.getUserById(loginuser.getUid())
					.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
			System.out.println("dbuser received by user service");
			System.out.println(dbuser);
			
			
			return dbuser;
			

		}
	}
	
	public ReactUserModel convertUser(User dbuser) {
		System.out.println("creating a react user from dbuser");
		System.out.println(dbuser);
		ReactUserModel ruser = new ReactUserModel();
		ruser.setUserImage(dbuser.getImg());
		ruser.setUserName(dbuser.getuserName());
		ruser.setFirstName(dbuser.getfirstName());
		ruser.setLastName(dbuser.getlastName());
		
		if (dbuser.getUser_type() == 1) {
			ruser.setUserRole("Admin");
		}
		if (dbuser.getUser_type() == 0) {
			ruser.setUserRole("Employee");
		}
		
		System.out.println("react user values set");
		return ruser;
	}
	
	//passthrough service for unused "get all users" function.
//	public List<User> getAllUsers() {
//		return userRepository.getAllUsers();
//	}
	
}
