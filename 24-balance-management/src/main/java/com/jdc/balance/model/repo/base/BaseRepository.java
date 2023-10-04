package com.jdc.balance.model.repo.base;

import java.util.List;
import java.util.function.Function;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.NoRepositoryBean;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

@NoRepositoryBean
public interface BaseRepository<T, ID> extends JpaRepositoryImplementation<T, ID> {

	<R> List<R> findAll(Function<CriteriaBuilder, CriteriaQuery<R>> queryFun);
	Long count(Function<CriteriaBuilder, CriteriaQuery<Long>> queryFun);
}
