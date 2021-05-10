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
@Table(name="employers")
public class Employer extends User {

	@Id
	@GeneratedValue
	@Column(name="user_id")
	private int userId;
	
	@Column(name="website")
	private String website;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="email_verified")
	private boolean emailVerified;
	
	@Column(name="system_verified")
	private boolean systemVerified;
	
	@Column(name="company_name")
	private String companyName;
	
	public Employer() {}

	public Employer(int id, String email, String password, String website, String phoneNumber,
			String companyName) {
		super(id, email, password);
		this.userId = id;
		this.website = website;
		this.phoneNumber = phoneNumber;
		this.companyName = companyName;
	}
	
}
