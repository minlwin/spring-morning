package com.jdc.balance.model.repo.base;

import java.util.List;
import java.util.function.Function;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

public class BaseRepositoryImpl<T, ID> extends SimpleJpaRepository<T, ID> implements BaseRepository<T, ID>{

	private EntityManager entityManager;
	
	public BaseRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
		super(entityInformation, entityManager);
		this.entityManager = entityManager;
	}

	@Override
	public <R> List<R> findAll(Function<CriteriaBuilder, CriteriaQuery<R>> queryFun) {
		var criteriaQuery = queryFun.apply(entityManager.getCriteriaBuilder());
		return entityManager.createQuery(criteriaQuery).getResultList();
	}

	@Override
	public Long count(Function<CriteriaBuilder, CriteriaQuery<Long>> queryFun) {
		var criteriaQuery = queryFun.apply(entityManager.getCriteriaBuilder());
		return entityManager.createQuery(criteriaQuery).getSingleResult();
	}

}
