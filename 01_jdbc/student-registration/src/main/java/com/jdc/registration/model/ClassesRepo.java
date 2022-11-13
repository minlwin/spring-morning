package com.jdc.registration.model;

import java.util.Date;
import java.util.List;

import com.jdc.registration.model.dto.Classes;
import com.jdc.registration.model.form.ClassesForm;

/**
 * Classes Table Access Object
 * Basic Database Operation for Classes Table
 * 
 * @author minlwin
 * @since 2022-11-10
 *
 */
public interface ClassesRepo {

	/**
	 * Save Operation 
	 * Insert or Update Classes Table
	 * 
	 * @param dto Classes Data
	 * @return Primary Key
	 */
	int save(ClassesForm dto);
	
	/**
	 * Find Classes Data by Primary Key
	 * 
	 * @param id Primary Key
	 * @return Classes Data
	 */
	Classes findById(int id);
	
	/**
	 * Logical Delete Operation for Classes Table
	 *  
	 * @param id Primary Key
	 */
	void delete(int id);
	
	/**
	 * Search Operation for Classes Data
	 * 
	 * @param teacherName Optional Teacher Name (Ignore Case Like Search)
	 * @param courseName Optional Course Name (Ignore Case Like Search)
	 * @param from Optional Date From
	 * @param to Optional Date To
	 * @param deleted Optional Delete Flag
	 * 
	 * @return Zero or More Classes Data 
	 */
	List<Classes> search(String teacherName, String courseName, Date from, Date to, Boolean deleted);
}
