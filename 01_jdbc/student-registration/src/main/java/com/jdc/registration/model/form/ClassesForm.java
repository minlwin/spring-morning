package com.jdc.registration.model.form;

import java.util.Date;

public class ClassesForm {

	private int id;
	private int courseId;
	private int teacherId;
	private Date startDate;
	private boolean deleted;

	public ClassesForm() {
	}

	public ClassesForm(int courseId, int teacherId, Date startDate, boolean deleted) {
		super();
		this.courseId = courseId;
		this.teacherId = teacherId;
		this.startDate = startDate;
		this.deleted = deleted;
	}

	public ClassesForm(int id, int courseId, int teacherId, Date startDate, boolean deleted) {
		super();
		this.id = id;
		this.courseId = courseId;
		this.teacherId = teacherId;
		this.startDate = startDate;
		this.deleted = deleted;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

}
