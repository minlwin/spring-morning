package com.jdc.demo.model.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jdc.demo.model.entity.Course.Level;
import com.jdc.demo.model.entity.Session;

@Service
public class SessionService {

	public List<Session> search(Optional<Level> level, Optional<String> course, Optional<LocalDate> fromDate,
			Optional<LocalDate> toDate) {
		// TODO Auto-generated method stub
		return null;
	}

	public Session findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Session save(Session dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
