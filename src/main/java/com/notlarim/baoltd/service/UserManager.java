package com.notlarim.notlarimltd.service;

import java.util.List;

import com.notlarim.notlarimltd.model.User;

public interface UserManager {

	User findById(Long id);
	
	User findByUsername(String username);
		
	User findByEmail(String email);
		
	void save(User user);
	
	User createUser(String username, String password, String email, List<String> roles);

	List<User> getAllUsers();
}
