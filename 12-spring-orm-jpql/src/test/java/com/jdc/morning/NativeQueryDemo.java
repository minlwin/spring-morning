package com.jdc.morning;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jdc.morning.repo.CourseRepo;
import com.jdc.morning.utils.TestUtils;

@SpringBootTest
public class NativeQueryDemo {

	@Autowired
	private CourseRepo repo;
	
	@Test
	void entityResultDemo() {
		var result = repo.searchByLevelNative(1);
		TestUtils.show(result);
	}
	
}
