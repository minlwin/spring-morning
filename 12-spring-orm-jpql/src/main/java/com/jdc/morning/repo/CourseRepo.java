package com.jdc.morning.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jdc.morning.entity.Course;
import com.jdc.morning.entity.Course.Level;

public interface CourseRepo extends JpaRepository<Course, Integer>{

	@Query(name = "Course.nativeFindByLevel", nativeQuery = true)
	List<Course> searchByLevelNative(Level level);
}
