package com.revature.repositories;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.revature.models.User;

@Repository
public class UserRepository {
	
	Map<Integer, User> users = new HashMap<>();
	
	//User Initialization Block
	{
		users.put(1, new User(1, 1, "SampleUser", "Adam", "Admin", "AdminPassword", "admin@admin.com"));
		users.put(1, new User(2, 0, "SampleUser", "Bill", "Basic", "badpassword", "BillBasic@gmail.com"));
		users.put(1, new User(3, 0, "SampleUser2", "User", "Name", "bEtT3r P4Ss!", "example@example.com"));
	}
	
	public Collection<User> getAllUsers() {
		return users.values();
	}
	
	public Optional<User> getUserById(int id) {
		return Optional.ofNullable(users.get(id));
	}
	
	public User save(User user) {
		users.put(users.size()+1, user);
		return user;
	}
}