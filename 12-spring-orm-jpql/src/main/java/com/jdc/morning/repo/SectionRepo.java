package com.jdc.morning.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jdc.morning.entity.Section;

public interface SectionRepo extends JpaRepository<Section, Integer>{

	@Query("select s from Section s join fetch s.course c where c.name = ?1")
	List<Section> search(String name);
	
	@Query("select s from Section s join s.registration r where r.student.id = ?1")
	List<Section> searchForStudent(Integer studentId);
}
