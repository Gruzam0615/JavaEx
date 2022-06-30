package com.demo02.board;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
	
	@Query(value="SELECT * FROM board", nativeQuery=true)
	List<Board> findAllBoard();
	
	@Query(value="SELECT * FROM board ORDER BY idx DESC", nativeQuery=true)
	List<Board> findAllBoardDESC();
	
	@Query(value="SELECT * FROM board ORDER BY idx DESC LIMIT :limitNumber", nativeQuery=true)
	List<Board> findPartBoard(@Param(value="limitNumber") int limitNumber);
	
}
