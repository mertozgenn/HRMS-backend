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
@Table(name="system_employees")
public class SystemEmployee extends User {

	@Id
	@GeneratedValue
	@Column(name="user_id")
	private int userId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="position_id")
	private int positionId;
	
	public SystemEmployee() {}

	public SystemEmployee(int id, String email, String password, String firstName, String lastName,
			int positionId) {
		super(id, email, password);
		this.userId = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.positionId = positionId;
	}
	

}
