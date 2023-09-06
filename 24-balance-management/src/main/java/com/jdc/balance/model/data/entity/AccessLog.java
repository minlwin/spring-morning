package com.jdc.balance.model.data.entity;

import java.time.LocalDate;

import com.jdc.balance.model.data.entity.consts.AccessType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ACCESS_LOG")
@SequenceGenerator(name = "seq_access_log", allocationSize = 1)
public class AccessLog {

	@Id
	@GeneratedValue(generator = "seq_access_log")
	private long id;

	@Column(name = "access_type")
	private AccessType accessType;

	private String status;

	@Column(name = "login_id")
	private String loginId;

	@Column(name = "access_at")
	private LocalDate accessAt;

	@Column(name = "count_per_day")
	private int countPerDay;

}