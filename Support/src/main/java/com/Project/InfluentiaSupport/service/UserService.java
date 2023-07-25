package com.Project.InfluentiaSupport.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.InfluentiaSupport.Entity.UserDetails;
import com.Project.InfluentiaSupport.Repo.UserRepo;

@Service
public class UserService {
	@Autowired
	private UserRepo userRepo;
	
	public UserDetails fetchByEmail(String email) {
		return userRepo.findByEmail(email);
	}
	
	public UserDetails fetchByEmailandPassword(String email, String password) {
		return userRepo.findByEmailAndPassword(email,password);
	}
	
	public UserDetails saveUser(UserDetails user) {
		return userRepo.save(user);
	}
}
