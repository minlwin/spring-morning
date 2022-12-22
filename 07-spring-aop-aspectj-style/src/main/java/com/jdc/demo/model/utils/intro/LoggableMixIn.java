package com.jdc.demo.model.utils.intro;

import org.springframework.stereotype.Component;

@Component
public class LoggableMixIn implements Loggable{

	@Override
	public void log() {
		System.out.println("Hello from Loggable Mixin");
	}

}
