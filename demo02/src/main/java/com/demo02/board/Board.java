package com.demo02.board;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Board {
	
	@Id
	private long idx;
	private String title;
	private String author;
	@Column(nullable=false)
	private String content;
	private long count;
	private long likecount;
	private Date createddate;
	private Date lastdate;
	
	public long getIdx() {
		return idx;
	}
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public String getContent() {
		return content;
	}
	public long getCount() {
		return count;
	}
	public long getLikeCount() {
		return likecount;
	}
	public Date getCreatedDate() {
		return createddate;
	}
	public Date getLastDate() {
		return lastdate;
	}
	public void setIdx(long idx) {
		this.idx = idx;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public void setLikeCount(long likecount) {
		this.likecount = likecount;
	}
	public void setCreatedDate(Date createddate) {
		this.createddate = createddate;
	}
	public void setLastDate(Date lastdate) {
		this.lastdate = lastdate;
	}
	
	public Board() {}
	
	public Board(long idx, String title, String author, String content, long count, long likecount, Date createddate, Date lastdate) {
		this.idx = idx;
		this.title = title;
		this.author = author;
		this.content = content;
		this.count = 0;
		this.likecount = 0;
		this.createddate = createddate;
		this.lastdate = lastdate;
	}
	
	

}
