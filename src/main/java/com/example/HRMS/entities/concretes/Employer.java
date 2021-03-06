package com.example.HRMS.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.HRMS.core.entities.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobAdverts"})
public class Employer extends User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private int id;
	
	@Column(name="website")
	@NotBlank
	@NotNull
	private String website;
	
	@Column(name="phone_number")
	@NotBlank
	@NotNull
	private String phoneNumber;
	
	
	@Column(name="system_verified")
	private boolean systemVerified;
	
	@Column(name="company_name")
	@NotBlank
	@NotNull
	private String companyName;

	@OneToMany(mappedBy = "employer")
	private List<JobAdvert> jobAdverts;
	
	
	public Employer(String email, String password, String website, String phoneNumber,
			String companyName) {
		super(email, password);
		this.website = website;
		this.phoneNumber = phoneNumber;
		this.companyName = companyName;
	}

	
}
