package com.demo02.board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BoardController {
	
	Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private BoardRepository boardRepository;
	
	final int POST_COUNT = 10; // 한 페이지에 존재하는 게시글 수 (게시글의 집합)
	final int BLOCK_COUNT = 10; // 한 번에 표시할 페이지의 수 (페이지의 집합) ex)만약 5라면 이전 12345 다음 같은 형태로 출력
	
	public List<Board> postList(int currentPage) {
		/**
		 * Page, PageRequest, Pageable Object
		 */
//		오름차순: PageRequest.of(0, 한 페이지에 표시할 게시글 수)
//		내림차순: PageRequest.of(0, 한 페이지에 표시할 게시글 수, Sort.by(Sort.Direction.DESC, "정렬대상 컬럼명"))
		PageRequest pageRequest = PageRequest.of(currentPage-1, POST_COUNT, Sort.by(Sort.Direction.DESC, "idx"));
		Page<Board> list = boardRepository.findAll(pageRequest);
		List<Board> answer = list.getContent();
		System.out.println(">> " + list.getNumber());
		
		return answer;
	}
	public Map<String, Integer> pageList(int currentPage) {
		Map<String, Integer> result = new HashMap<>();
		PageRequest pageRequest = PageRequest.of(currentPage - 1, POST_COUNT, Sort.by(Sort.Direction.DESC, "idx"));
		Page<Board> list = boardRepository.findAll(pageRequest);
		int blockCount = list.getTotalPages();
		
		int blockFirst = ((currentPage - 1) / BLOCK_COUNT) * BLOCK_COUNT + 1;
		int blockLast = blockFirst + BLOCK_COUNT - 1;
		
		if(blockCount < blockLast) {
			blockLast = blockCount;
		}
		
		int previousBlock = blockFirst - BLOCK_COUNT ;
		int nextBlock = blockFirst + BLOCK_COUNT ;
		
		result.put("blockCount", BLOCK_COUNT);
		result.put("fistBlock", 1); // 모든 페이지 중 가장 첫번째 페이지
		result.put("lastBlock", blockCount); // 모든 페이지 중 가장 마지막 페이지
		result.put("blockFirst", blockFirst); // 페이지네이션 목록에서 가장 첫번째 페이지
		result.put("blockLast", blockLast); // 페이지네이션 목록에서 가장 마지막 페이지
		result.put("previousBlock", previousBlock); // 이전 10개의 페이지네이션 블록에서 가장 첫번째 페이지
		result.put("nextBlock", nextBlock); // 이후 10개의 페이지네이션 블록에서 가장 첫번째 페이지
		
		return result;
	}

	@GetMapping("/boardlist")
	public String boardList(@RequestParam(value="currentpage", defaultValue="1") int currentPage, Model model) {
		List<Board> list = postList(currentPage);
		Map<String, Integer> pagination = pageList(currentPage);
		
		model.addAttribute("currentPage", currentPage);
		model.addAttribute("list", list);		
		model.addAttribute("pagination", pagination);
		
		return "Board/BoardList";
	}
	
	
//	RESTApi
//	@GetMapping("/testA")
//	public Page<Board> getTest01(Pageable pageable) {
//		return boardRepository.findAll(pageable);
//	}
	
	
}
