package com.Project.InfluentiaSupport.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="userdetails")
public class UserDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="userid")
	private int userId;
	
	@Column(name="username")
	private String userName;
	
	@Column(name="usertype")
	private String userType;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
}
