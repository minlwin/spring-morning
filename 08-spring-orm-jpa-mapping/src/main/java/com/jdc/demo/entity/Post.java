package com.jdc.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "POST")
public class Post {

	@EmbeddedId
	private PostPK id;
	@Column(nullable = false)
	private String title;
	@Column(nullable = false)
	private String body;

	@Embedded
	private SecurityInfo security;

	public SecurityInfo getSecurity() {
		return security;
	}

	public void setSecurity(SecurityInfo security) {
		this.security = security;
	}

	public PostPK getId() {
		return id;
	}

	public void setId(PostPK id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

}
