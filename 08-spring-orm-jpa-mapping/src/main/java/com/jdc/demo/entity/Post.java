package com.jdc.demo.entity;

import java.util.Date;

import jakarta.persistence.Column;
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
	@Column(name = "creation")
	private Date createDate;
	@Column(name = "modification")
	private Date updateDate;


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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
