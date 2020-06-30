package com.revature.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
import com.revature.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("")
	public User saveUser(@RequestBody User user) {
		user.setSalt(BCrypt.gensalt());
		user.setHash(BCrypt.hashpw(user.getHash(), user.getSalt()));
		return userService.save(user);
	}
	
	@PutMapping("")
	public User updateUser(@RequestBody User user) {
		return userService.update(user);
	}
	
	@GetMapping("/id/{id}")
	public User getUserById(@PathVariable int id) {
		return userService.getUserById(id);
	}
	
	@GetMapping("/login")
	public User login(@RequestBody User user) {
		return userService.login(user);
	}
}
