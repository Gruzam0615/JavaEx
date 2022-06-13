package com.demo02.test01;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface Test01Repository extends CrudRepository<Test01, Long> {
	
	Test01 findById(long id);	
	Test01 findByContent(String content);
	
	@Query(value = "SELECT * FROM Test01 WHERE name=:name",nativeQuery = true)
	Test01 findByName(@Param(value="name") String name);
	
}
