package com.jdc.demo.entity;

import java.util.List;
import java.util.Map;

import jakarta.persistence.Basic;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.MapKeyColumn;
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

	@Basic(optional = false)
	@ElementCollection
	@CollectionTable(name = "tags")
	private List<String> tag;

	@ElementCollection
	@MapKeyColumn(name = "member")
	@CollectionTable(name = "ratings")
	private Map<String, Integer> rating;

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

	public List<String> getTag() {
		return tag;
	}

	public void setTag(List<String> tag) {
		this.tag = tag;
	}

	public Map<String, Integer> getRating() {
		return rating;
	}

	public void setRating(Map<String, Integer> rating) {
		this.rating = rating;
	}

}
