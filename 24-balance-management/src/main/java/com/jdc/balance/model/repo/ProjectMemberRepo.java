package com.jdc.balance.model.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.jdc.balance.model.data.entity.ProjectMember;
import com.jdc.balance.model.data.entity.embedded.ProjectMemberPK;

public interface ProjectMemberRepo extends JpaRepositoryImplementation<ProjectMember, ProjectMemberPK>{

}
