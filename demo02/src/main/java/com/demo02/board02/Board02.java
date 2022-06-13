package com.demo02.board02;

import java.util.Date;


import lombok.Data;

@Data
public class Board02 {
	private long idx;
	private String title;
	private String author;
	private String content;
	private long count;
	private long likecount;
	private Date createddate;
	private Date lastdate;
}
