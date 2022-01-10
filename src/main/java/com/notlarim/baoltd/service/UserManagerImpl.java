package com.notlarim.notlarimltd.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notlarim.notlarimltd.model.User;
import com.notlarim.notlarimltd.model.security.Role;
import com.notlarim.notlarimltd.model.security.UserRole;
import com.notlarim.notlarimltd.repository.RoleRepository;
import com.notlarim.notlarimltd.repository.UserRepository;

import utility.SecurityUtility;

@Service
public class UserManagerImpl implements UserManager{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public User findById(Long id) {
		Optional<User> opt = userRepository.findById(id);
		return opt.get();
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public void save(User user) {
		userRepository.save(user);
		
	}

	@Override
	@Transactional
	public User createUser(String username, String password, String email, List<String> roles) {
		User user = findByUsername(username);
		if (user != null) {
			return user;
		} else {
			user = new User();
			user.setUsername(username);
			user.setSurname("admin");
			user.setFirstname("admin");
			user.setAddress(null);
			user.setPassword(SecurityUtility.passwordEncoder().encode(password));
			user.setEmail(email);			
			Set<UserRole> userRoles = new HashSet<>();
			for (String rolename : roles) {
				Role role = roleRepository.findByName(rolename);
				if (role == null) {
					role = new Role();
					role.setName(rolename);
					roleRepository.save(role);
				}
				userRoles.add(new UserRole(user, role));
			}			
			user.setUserRoles(userRoles);
			return userRepository.save(user);
		}
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = new ArrayList<>();
		userRepository.findAll().forEach(u -> {
			users.add(u);
		});
		
		return users;
	}

}
