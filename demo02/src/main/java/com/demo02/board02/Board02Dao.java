package com.demo02.board02;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface Board02Dao {
	
//	Can't use Dynamic Query in this case
//	@Select("SELECT memberEmail, memberName, memberMobile, memberRole FROM Member WHERE memberEmail=#{memberEmail} AND memberPassword=#{memberPassword}")
//	@Select("SELECT * FROM Member WHERE memberEmail=#{memberEmail} AND memberPassword=#{memberPassword}")
	@Select("SELECT * FROM board02")
	public List<Board02> board02AllList();
	
}
