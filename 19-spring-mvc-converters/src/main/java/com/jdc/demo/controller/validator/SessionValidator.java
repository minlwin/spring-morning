package com.jdc.demo.controller.validator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.jdc.demo.model.entity.Session;

public class SessionValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Session.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		if(null != target && target instanceof Session dto) {
			
			var start = dto.getStartTime();
			var end = dto.getEndTime();
			
			if(StringUtils.hasLength(start) && StringUtils.hasLength(end)) {
				
				LocalDateTime startTime = LocalDateTime.of(LocalDate.now(), LocalTime.parse(start));
				LocalDateTime endTime = LocalDateTime.of(LocalDate.now(), LocalTime.parse(end));
				
				if(startTime.isAfter(endTime)) {
					errors.rejectValue("startTime", "", "Start Time must be earlier than End Time.");
				}
			}
		}
		
	}

}
