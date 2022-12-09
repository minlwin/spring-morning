package com.jdc.demo.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.jdc.demo.BaseDao;
import com.jdc.demo.dao.dto.Account;
import com.jdc.demo.dao.dto.Classes;
import com.jdc.demo.dao.dto.Course;

@Repository
@Qualifier("classes")
public class ClassesDao implements BaseDao<Classes>{

	@Override
	public int create(Classes data) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(int id, Classes data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Classes findById(int id) {
		var course = new Course(1, "Java Basic", 3, 300000);
		var teacher = new Account(1, "Min Lwin", "09782003098", "liwn.zawmin@gmail.com");
		return new Classes(1, course, teacher, LocalDate.of(2022, 12, 1));
	}

	@Override
	public List<Classes> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
