package com.jdc.demo.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Embeddable
public class SecurityInfo {

	@Temporal(TemporalType.TIMESTAMP)
	private Date creation;
	@Temporal(TemporalType.TIMESTAMP)
	private Date modification;

	@Column(name = "create_user")
	private int createUser;
	@Column(name = "modified_user")
	private int modifiedUser;

	public Date getCreation() {
		return creation;
	}

	public void setCreation(Date creation) {
		this.creation = creation;
	}

	public Date getModification() {
		return modification;
	}

	public void setModification(Date modification) {
		this.modification = modification;
	}

	public int getCreateUser() {
		return createUser;
	}

	public void setCreateUser(int createUser) {
		this.createUser = createUser;
	}

	public int getModifiedUser() {
		return modifiedUser;
	}

	public void setModifiedUser(int modifiedUser) {
		this.modifiedUser = modifiedUser;
	}

}
