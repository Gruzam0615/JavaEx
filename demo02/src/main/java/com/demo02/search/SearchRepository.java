package com.demo02.search;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface SearchRepository extends CrudRepository<Search, Long> {
	
	List<Search> findByKeyword(String keyword);
//	Search findByKeyword(String keyword);

}
