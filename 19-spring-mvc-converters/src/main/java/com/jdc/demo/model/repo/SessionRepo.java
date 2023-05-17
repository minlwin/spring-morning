package com.jdc.demo.model.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.demo.model.entity.Session;

public interface SessionRepo extends JpaRepositoryImplementation<Session, Integer>{

}
