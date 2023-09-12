package com.jdc.balance.model.data.entity;

import java.time.LocalDateTime;

import com.jdc.balance.model.data.entity.consts.ErrorStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ERROR_LOG")
@SequenceGenerator(name = "seq_error_log", allocationSize = 1)
public class ErrorLog {

	@Id
	@GeneratedValue(generator = "seq_error_log")
	private long id;

	private String exception;

	@Column(name = "issue_at")
	private LocalDateTime issueAt;

	private String owner;

	private ErrorStatus status;

	private String message;

	@Column(name = "stack_trace")
	private String stackTrace;

}