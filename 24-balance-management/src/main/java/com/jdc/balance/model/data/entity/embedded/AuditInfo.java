package com.jdc.balance.model.data.entity.embedded;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class AuditInfo implements Serializable{

	private static final long serialVersionUID = 1L;

	private boolean deleted;

	@CreatedDate
	@Column(name = "create_at")
	private LocalDateTime createAt;

	@CreatedBy
	@Column(name = "create_by")
	private String createdBy;

	@LastModifiedDate
	@Column(name = "update_at")
	private LocalDateTime updateAt;

	@LastModifiedBy
	@Column(name = "update_by")
	private String updateBy;

}