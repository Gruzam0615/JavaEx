package com.demo02.board02;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@Repository
public class Board02Service implements Board02Dao {
	
	@Autowired
	private Board02Dao board02Dao;
	
	@Override
	public List<Board02> board02AllList() {
		return board02Dao.board02AllList();
	}
	
}
