package com.demo02.board02;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/board02")
public class Board02Controller {
	
//	@Autowired
//	private Board02Mapper board02Mapper;
	
	@Autowired
	private Board02Service board02Service;	
	
	
	@GetMapping("/allList")
	public String board02AllList() {
		List<Board02> data = board02Service.board02AllList();
		List<String> temp = new ArrayList<>();
		System.out.println(">> " + temp);
		return "testing";
	}
	
}
