package com.demo02.test01;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Test01 {
	
	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	@Column(nullable = false)
	private String name;
	private String content;

	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	public String getContent() {
		return content;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setContent(String content) {
		this.content = content;
	}	

	public Test01() {}
	
	public Test01(long id, String name, String content) {
		this.id = id;
		this.name = name;
		this.content = content;
	}
	
	public Test01(long id, String name) {
		this.id = id;
		this.name = name;
	}

	
}
