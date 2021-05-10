package com.example.HRMS.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@PrimaryKeyJoinColumn(name="userId")
@Table(name="jobseekers")
public class Jobseeker extends User{

	@Id
	@GeneratedValue
	@Column(name="user_id")
	private int userId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="national_identity")
	private String nationalIdentity;
	
	@Column(name="year_of_birth")
	private int yearOfBirth;
	
	@Column(name="email_verified")
	private boolean emailVerified;
	
	public Jobseeker() {}

	public Jobseeker(int id, String email, String password, String firstName, String lastName,
			String nationalIdentity, int yearOfBirth) {
		super(id, email, password);
		this.userId = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalIdentity = nationalIdentity;
		this.yearOfBirth = yearOfBirth;
	}


	
}
