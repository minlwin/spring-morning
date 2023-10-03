package com.jdc.balance.model.data.entity;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.jdc.balance.model.data.entity.embedded.AuditInfo;
import com.jdc.balance.model.data.entity.embedded.ProjectMemberPK;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;

@Entity
@Getter
@Table(name = "PROJECT_MEMBER")
@EntityListeners(value = AuditingEntityListener.class)
public class ProjectMember {

	@EmbeddedId
	private ProjectMemberPK id;

	@ManyToOne(optional = false)
	@JoinColumn(insertable = false, updatable = false)
	private Project project;

	@ManyToOne(optional = false)
	@JoinColumn(insertable = false, updatable = false)
	private Member member;

	private AuditInfo audit = new AuditInfo();
	
	public ProjectMember() {
		id = new ProjectMemberPK();
	}
	
	public void setId(ProjectMemberPK id) {
		this.id = id;
	}
	
	public void setProject(Project project) {
		this.project = project;
		id.setProjectId(project.getId());
	}
	
	public void setMember(Member member) {
		this.member = member;
		id.setMemberId(member.getId());
	}
	
	public void setAudit(AuditInfo audit) {
		this.audit = audit;
	}

}