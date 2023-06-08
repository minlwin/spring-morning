package com.jdc.demo.service.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.demo.service.entity.Members;

public interface MembersRepo extends JpaRepositoryImplementation<Members, Integer>{

	Optional<Members> findOneByEmail(String email);
}
