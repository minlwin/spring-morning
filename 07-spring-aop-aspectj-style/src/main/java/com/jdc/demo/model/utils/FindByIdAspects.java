package com.jdc.demo.model.utils;

import org.springframework.stereotype.Component;

@Component
public class FindByIdAspects {

	public void beforeFindById() {
		System.out.println("Before Find By Id Methods.");
	}
	
	public void onExceptionThrow(int id, Throwable exception) {
		System.out.println("After Throwing");
		System.out.println("%s has been thrown by id %d."
				.formatted(exception.getClass().getSimpleName(), id));
	}
}
