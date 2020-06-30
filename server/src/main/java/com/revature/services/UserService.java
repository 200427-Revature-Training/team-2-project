package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import com.revature.models.User;
import com.revature.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public User save(User user) {
		return userRepository.save(user);
	}
	
	public User update(User user) {
		return userRepository.update(user);
	}
	
	public Optional<User> getUserById(int id) {
		System.out.println("passthrough user service");
		return userRepository.getUserById(id);
	}
	
	public List<User> getAllUsers() {
		return userRepository.getAllUsers();
	}
	
	public User login(String username, String password) {
		User user= userRepository.login(username,password);
		if (user==null) {throw new HttpClientErrorException(HttpStatus.NOT_FOUND);}
		else {return user;}
	}
}
