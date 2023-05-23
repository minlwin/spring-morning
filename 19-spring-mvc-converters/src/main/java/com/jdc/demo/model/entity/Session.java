package com.jdc.demo.model.entity;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "session")
@TableGenerator(name = "session_seq")
public class Session {

	@Id
	@GeneratedValue(generator = "session_seq")
	private int id;
	
	@ManyToOne(optional = false)
	@NotNull(message = "Please select course")
	private Course course;
	
	@NotNull(message = "Please enter start date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate startDate;
	
	@CollectionTable(name = "session_days")
	@ElementCollection(fetch = FetchType.EAGER)
	@NotEmpty(message = "Please select open days")
	private List<DayOfWeek> days;
	
	@NotBlank(message = "Please enter start time.")
	private String startTime;
	
	@NotBlank(message = "Please enter end time.")
	private String endTime;
	
	@Min(value = 1, message = "Please enter available seats.")
	private int seats;
}
