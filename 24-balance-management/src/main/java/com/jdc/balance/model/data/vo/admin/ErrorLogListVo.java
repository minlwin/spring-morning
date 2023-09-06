package com.jdc.balance.model.data.vo.admin;

import java.time.LocalDateTime;

import ch.qos.logback.core.status.ErrorStatus;
import lombok.Data;

@Data
public class ErrorLogListVo {

	private long id;

	private String exception;

	private LocalDateTime issueAt;

	private String owner;

	private ErrorStatus status;

	private String message;

}