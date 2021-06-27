package com.example.HRMS.entities.concretes;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name="employers_to_update")
@AllArgsConstructor
@NoArgsConstructor
public class EmployerToUpdate{

	@Id
	@Column(name="user_id")
	private int userId;
	
	@Column(name="new_website")
	private String newWebsite;
	
	@Column(name="new_phone_number")
	private String newPhoneNumber;
	
	
	@Column(name="new_company_name")
	private String newCompanyName;
	
	@Column(name="new_email")
	private String newEmail;
	
	@OneToOne
	@JoinColumn(name="user_id")
	private Employer employer;
}
