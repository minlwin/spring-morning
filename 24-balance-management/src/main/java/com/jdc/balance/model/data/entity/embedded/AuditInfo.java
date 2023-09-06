package com.jdc.balance.model.data.entity.embedded;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class AuditInfo implements Serializable{

	private static final long serialVersionUID = 1L;

	private boolean deleted;

	@Column(name = "create_at")
	private LocalDateTime createAt;

	@Column(name = "create_by")
	private String createdBy;

	@Column(name = "update_at")
	private LocalDateTime updateAt;

	@Column(name = "update_by")
	private String updateBy;

}