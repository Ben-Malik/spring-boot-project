package com.bao.baoltd.service;

import java.util.List;

import com.bao.baoltd.model.User;

public interface UserManager {

	User findById(Long id);
	
	User findByUsername(String username);
		
	User findByEmail(String email);
		
	void save(User user);
	
	User createUser(String username, String password, String email, List<String> roles);

}
