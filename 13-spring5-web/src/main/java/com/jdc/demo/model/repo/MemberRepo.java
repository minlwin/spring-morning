package com.jdc.demo.model.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.demo.model.entity.Member;

public interface MemberRepo extends JpaRepositoryImplementation<Member, Integer>{

}
