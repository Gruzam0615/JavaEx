package com.demo01.search;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Search {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idxNum;
	private String keyword;
	private int count;
	private Date firstDate;
	private Date lastDate;
	
		
	public long getIdxNum() {
		return idxNum;
	}

	public String getKeyword() {
		return keyword;
	}
	
	public int getCount() {
		return count;
	}

	public Date getFirstDate() {
		return firstDate;
	}
	
	public Date getLastDate() {
		return lastDate;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	public void setCount(int count) {
		this.count = count;
	}

	public void setFirstDate(Date firstDate) {
		this.firstDate = firstDate;
	}
	
	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	public Search() {}
	
	public Search(String keyword, Date firstDate) {
		this.keyword = keyword;
		this.count = 1;
		this.firstDate = firstDate;
		this.lastDate = firstDate;
	}	

}
