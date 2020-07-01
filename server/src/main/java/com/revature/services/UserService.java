package com.revature.services;

import java.util.List;
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
	
	public User getUserById(int id) {
		System.out.println("passthrough user service");
			return userRepository.getUserById(id)
				.orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND));
		}
	
	public List<User> getAllUsers() {
		return userRepository.getAllUsers();
	}
	
	public User login(User user) {
		User fulluser = userRepository.getUserByUsername(user.getUsername());
		if (fulluser==null) {throw new HttpClientErrorException(HttpStatus.NOT_FOUND);}
		else {
			System.out.println(user.getUserpass());
			return userRepository.login(fulluser.getUid(), user.getUserpass());
		}
	}
}
