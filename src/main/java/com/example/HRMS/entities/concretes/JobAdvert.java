package com.example.HRMS.entities.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "job_adverts")
public class JobAdvert {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "job_description")
	private String jobDescription;
	
	@Column(name = "minimum_salary")
	private int minimumSalary;
	
	@Column(name = "maximum_salary")
	private int maximumSalary;
	
	@Column(name = "open_position")
	private int openPosition;
	
	@Column(name = "application_deadline")
	private Date applicationDeadline;
	
	@Column(name = "publishing_date")
	private Date publishingDate;
	
	@Column(name = "active")
	private boolean active;
	
	@Column(name = "remote_work")
	private boolean remoteWork;
	
	@Column(name = "workplace_work")
	private boolean workplaceWork;
	
	@Column(name = "full_time")
	private boolean fullTime;
	
	@Column(name = "part_time")
	private boolean partTime;
	
	@Column(name = "approved")
	private boolean approved;
	
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;
	
	@ManyToOne
	@JoinColumn(name = "position_id")
	private Position position;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Employer employer;
	
	@OneToMany(mappedBy = "jobAdvert")
	@JsonIgnore
	private List<Favorite> favorites;
}
