package com.demo01.test01;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test01Controller {
	
	@Autowired
	private Test01Repository greetingRepository;
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@GetMapping("/test01")
	public Test01 greeting(@RequestParam(value = "name", defaultValue = "Guest") String name) {		
//		Test01 result = new Greeting(counter.incrementAndGet(), name, String.format(template, name));
		
		Test01 dbData = greetingRepository.findByName(name);
		String dbData2 = null;
		
		if(dbData == null) {
			System.out.printf("demo01: 새로운 사용자 %s 를 등록합니다.\n", name);
			Test01 result = new Test01(counter.incrementAndGet(), name);
			greetingRepository.save(result);
			return result;
		}else {
			dbData2 = dbData.getName();
			System.out.printf("demo01: %s 는 이미 존재하는 사용자입니다.\n", dbData2);
			return dbData;
		}
	}
	
}
