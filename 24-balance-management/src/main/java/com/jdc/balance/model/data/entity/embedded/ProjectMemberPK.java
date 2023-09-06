package com.jdc.balance.model.data.entity.embedded;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class ProjectMemberPK implements Serializable{

	private static final long serialVersionUID = 1L;

	@Column(name = "project_id")
	private long projectId;

	@Column(name = "member_id")
	private long memberId;

}