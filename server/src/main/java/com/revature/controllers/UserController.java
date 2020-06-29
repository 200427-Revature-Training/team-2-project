package com.revature.controllers;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
import com.revature.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	
	@GetMapping("")
	public Collection<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public Optional<User> getUserById(@RequestParam int id) {
		return userService.getUserById(id);
	}
	
	
	@PostMapping("")
	public User save(@RequestBody User user) {
		return userService.save(user);
	}
}
