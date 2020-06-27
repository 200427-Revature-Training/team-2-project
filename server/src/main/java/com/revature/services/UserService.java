package com.revature.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.User;
import com.revature.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
//	public Collection<User> getAllUsers() {
//		return userRepository.getAllUsers();
//	}
	
	public Optional<User> getUserById(int id) {
		return userRepository.getUserById(id);
	}
	
	public User save(User user) {
		return userRepository.save(user);
	}

	public Optional<User> getUserByUsername(String username) {
		return userRepository.getUserByUsername(username);
	}

}
