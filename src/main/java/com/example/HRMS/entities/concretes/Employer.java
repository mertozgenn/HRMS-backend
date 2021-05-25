package com.example.HRMS.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@PrimaryKeyJoinColumn(name="userId")
@Table(name="employers")
@AllArgsConstructor
@NoArgsConstructor
public class Employer extends User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private int id;
	
	@Column(name="website")
	private String website;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	
	@Column(name="system_verified")
	private boolean systemVerified;
	
	@Column(name="company_name")
	private String companyName;

	public Employer(String email, String password, String website, String phoneNumber,
			String companyName) {
		super(email, password);
		this.website = website;
		this.phoneNumber = phoneNumber;
		this.companyName = companyName;
	}

	
}
