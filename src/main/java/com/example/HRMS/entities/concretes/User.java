package com.example.HRMS.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="users")
public class User {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int userId;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	public User() {}

	public User(int id, String email, String password) {
		this.userId = id;
		this.email = email;
		this.password = password;
	}
	
	 
}
