package com.example.HRMS.entities.concretes;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "jobseeker_cv_info")
public class JobseekerCVInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "github_address")
	@NotBlank
	@NotNull
	private String githubAddress;
	
	@Column(name = "linkedin_address")
	@NotBlank
	@NotNull
	private String linkedinAddress;
	
	@Column(name = "cover_letter")
	@NotBlank
	@NotNull
	private String coverLetter;

}
