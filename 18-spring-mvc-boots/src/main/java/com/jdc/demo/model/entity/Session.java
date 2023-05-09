package com.jdc.demo.model.entity;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.TableGenerator;
import lombok.Data;

@Data
@Entity
@TableGenerator(name = "session_seq")
public class Session {

	@Id
	@GeneratedValue(generator = "session_seq")
	private int id;
	
	@ManyToOne
	private Course course;
	private LocalDate startDate;
	
	@ElementCollection
	private List<DayOfWeek> days;
	
	private String startTime;
	private String endTime;
	private int seats;
}
