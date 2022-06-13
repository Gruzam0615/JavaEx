package com.demo02.test01;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class Test01Controller {
	
	@Autowired
	private Test01Repository greetingRepository;
	Logger logger = LoggerFactory.getLogger(Test01Controller.class);
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@GetMapping("/test01")
	public Test01 greeting(@RequestParam(value = "name", defaultValue = "Guest") String name) {		
//		Test01 result = new Greeting(counter.incrementAndGet(), name, String.format(template, name));
		
		Test01 dbData = greetingRepository.findByName(name);
		String dbData2 = null;
		
		if(dbData == null) {
			logger.info("Test01Controller: 새로운 사용자 {} 를 등록합니다.", name);
			Test01 result = new Test01(counter.incrementAndGet(), name);
			greetingRepository.save(result);
			return result;
		}else {
			dbData2 = dbData.getName();
			logger.info("Test01Controller: {}는 이미 존재하는 사용자입니다.", dbData2);
			return dbData;
		}
	}
	
}
