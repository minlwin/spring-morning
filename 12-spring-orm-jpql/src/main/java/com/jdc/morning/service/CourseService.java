package com.jdc.morning.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jdc.morning.entity.Course;
import com.jdc.morning.entity.Course.Level;
import com.jdc.morning.entity.Course_;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.Predicate;

@Service
public class CourseService {

	@PersistenceContext
	private EntityManager em;
	 
	public List<Course> searchWithCriteria(Level level, String name, Integer monthFrom, Integer monthTo) {
		
		var cb = em.getCriteriaBuilder();
		var cq = cb.createQuery(Course.class);
		var root = cq.from(Course.class);
		
		var predicates = new ArrayList<Predicate>();
		
		if(null != level) {
			predicates.add(cb.equal(root.get(Course_.level), level));
		}
		
		if(StringUtils.hasLength(name)) {
			predicates.add(cb.like(cb.lower(root.get(Course_.name)), name.toLowerCase().concat("%")));
		}
		
		if(null != monthFrom) {
			predicates.add(cb.ge(root.get(Course_.months), monthFrom));
		}
		
		if(null != monthTo) {
			predicates.add(cb.le(root.get(Course_.months), monthTo));
		}
		
		if(!predicates.isEmpty()) {
			cq.where(predicates.toArray(length -> new Predicate[length]));
		}
		
		return em.createQuery(cq).getResultList();
	}
	
	public List<Course> search(Level level, String name, Integer monthFrom, Integer monthTo) {
		
		StringBuffer sb = new StringBuffer("select c from Course c where 1 = 1");
		Map<String, Object> params = new HashMap<String, Object>();
		
		if(null != level) {
			sb.append(" and c.level = :level");
			params.put("level", level);
		}
		
		if(StringUtils.hasLength(name)) {
			sb.append(" and lower(c.name) like lower(:name)");
			params.put("name", "%s%%".formatted(name));
		}
		
		if(null != monthFrom) {
			sb.append(" and c.months >= :from");
			params.put("from", monthFrom);
		}
		
		if(null != monthTo) {
			sb.append(" and c.months <= :to");
			params.put("to", monthTo);
		}
		
		var query = em.createQuery(sb.toString(), Course.class);
		for(var entry : params.entrySet()) {
			query.setParameter(entry.getKey(), entry.getValue());
		}
		
		return query.getResultList();
	}
	
	
}
