package com.jdc.registration.model.dto;

public class Course {

	public Course() {
	}

	public Course(int id, String name, Level level, int duration, int fees, String description, boolean deleted) {
		super();
		this.id = id;
		this.name = name;
		this.level = level;
		this.duration = duration;
		this.fees = fees;
		this.description = description;
		this.deleted = deleted;
	}

	public Course(String name, Level level, int duration, int fees, String description, boolean deleted) {
		super();
		this.name = name;
		this.level = level;
		this.duration = duration;
		this.fees = fees;
		this.description = description;
		this.deleted = deleted;
	}

	private int id;

	private String name;

	private Level level;

	private int duration;

	private int fees;

	private String description;

	private boolean deleted;

	public enum Level {
		Entry, Intermediate, Advance
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

}