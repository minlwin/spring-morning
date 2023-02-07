package com.jdc.morning.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.morning.entity.Course;

public interface CourseRepo extends JpaRepository<Course, Integer>{

}
