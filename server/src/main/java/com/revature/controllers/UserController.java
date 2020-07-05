package com.revature.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.entities.User;
import com.revature.models.ReactUserModel;
import com.revature.models.AuthenticationResponse;
import com.revature.services.UserService;
import com.revature.util.JwtUtil;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*",
methods = {RequestMethod.GET, RequestMethod.PUT, 
		RequestMethod.PATCH, RequestMethod.POST})
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	private JwtUtil jwtTokenUtil;

	//GET the user with the uid matching the provided path variable.
	@GetMapping("/id/{id}")
	public ReactUserModel getUserById(@PathVariable int id) {
		System.out.println("get user by id request received by controller");
		System.out.println(id);
		User dbuser = userService.getUserById(id); //path variable extracted as an int
		System.out.println("dbuser assigned at controller");
		return userService.convertUser(dbuser);
	}
	
//	//GET login credentials. Currently returns a user. ORIGINAL
//	@GetMapping("/login")
//	public User login(@RequestBody User user) {
//		return userService.login(user); //creates User object from user data sent in request body and passes it to userService as args.
//	}
	
	
	//GET login credentials. Currently returns a user.
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user) throws Exception {
		
		
		
		
		try {
			userService.login(user); //creates User object from user data sent in request body and passes it to userService as args.
		}catch (Exception e) {
			throw new Exception("Incorrect username or password", e);
		}
		
		User login = userService.login(user);
		ReactUserModel returnuser = userService.convertUser(login);
		
		//create token through JwtUtil
		final String jwt = jwtTokenUtil.generateToken(user);
		
		

		//get token response. send back status200
		AuthenticationResponse auth = new AuthenticationResponse(jwt);
		
		returnuser.setJwt(auth.getJwt());
		
		return ResponseEntity.ok(returnuser);
	}
	
	

	//POST - receive a user in the request body and save it to the database.
	@PostMapping("")
	public ReactUserModel saveUser(@RequestBody User user) {
		System.out.println(user);
		System.out.println("user registration request received by controller");
		User dbuser = userService.save(user);
		System.out.println("dbuser received by controller");
		System.out.println(dbuser);
		return userService.convertUser(dbuser);
	}
	
	//receive updated user data and PUT it into database. I've disabled the endpoint as this function isn't utilized.
//	@PutMapping("")
//	public ReactUser updateUser(@RequestBody ReactUser ruser) {
//		return userService.update(ruser);
//	}

}
