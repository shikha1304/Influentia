package com.Project.InfluentiaSupport.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Project.InfluentiaSupport.Entity.UserDetails;

public interface UserRepo extends JpaRepository<UserDetails, Integer>{
	public UserDetails findByEmail(String email);
	public UserDetails findByEmailAndPassword(String email, String password);
//	public void saveUser(UserDetails user);	
}
