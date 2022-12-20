package com.jdc.demo.service;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Service;

import com.jdc.demo.dto.Member;

@Service
public class MemberService {
	
	private SimpleJdbcInsert insert;
	
	public MemberService(DataSource dataSource) {
		insert = new SimpleJdbcInsert(dataSource);
		insert.setTableName("member");
	}

	public int create(Member member) {
		return insert.execute(new BeanPropertySqlParameterSource(member));
	}
}
