package com.jdc.morning.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Section {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	private Course course;
	
	@OneToMany(mappedBy = "section")
	private List<Registration> registration;
	
	@Column(name = "start_at")
	private LocalDate startDate;
	private String room;
	@Column(name = "max_seats")
	private Integer maxStudents;
}
