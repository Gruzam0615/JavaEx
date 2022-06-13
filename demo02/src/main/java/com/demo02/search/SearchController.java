package com.demo02.search;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {

	@Autowired
	private SearchRepository searchRepository;
	
	@GetMapping("/search")
	public List<String> search(@RequestParam(value="keyword") String keyword) {
		List<Search> list = searchRepository.findByKeyword(keyword);
		List<String> result = new LinkedList<>();
		
		System.out.printf("%s Searching..\n", keyword);
		
		for(int i=0; i<list.size(); i++) {
			result.add(list.get(i).getKeyword());
		}
		
		if(result.isEmpty()) {
			Date currentDate = new Date();
			result.add("There is No result about " + keyword);
			searchRepository.save(new Search(keyword, currentDate));
			return result;
		} else {
			Date currentDate = new Date();
			for(int i=0; i<list.size(); i++) {
				list.get(i).setLastDate(currentDate);
				int count = list.get(i).getCount();
				list.get(i).setCount(count+1);
				searchRepository.save(list.get(i));
			}
			return result;
		}
	}
	
}
