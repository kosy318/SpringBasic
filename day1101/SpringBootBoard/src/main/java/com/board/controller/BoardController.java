package com.board.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.board.service.BoardService;
import com.board.vo.Board;

import io.swagger.annotations.Api;

// SOP : Same Origin(Server -> http://localhost:8080 까지) Policy, 비동기로 요청할 때 동일 서버에만 요청 가능
// CORS : Cross Origin Resource Sharing(html에는 기본적으로 적용이 됨), 요청을 할 때 origin을 같이 보냄.
// 		받은 서버가 답을 주는데, access control allow origin : 허용할 origin들의 목록을 같이 보냄
@CrossOrigin("*") // 다른 곳에서 오는 요청들을 전부 허용하겠다!!
@RestController
@Api(value = "BoardController-Version 1") // 이 클래스가 swagger리소스임을 표시
public class BoardController {
	
	@Autowired
	BoardService boardService;// interface type
	
	@GetMapping(value = "/posts")
	public ResponseEntity<?> list() {
		List<Board> list = boardService.selectAll();

		if(list != null && !list.isEmpty()) {
			return new ResponseEntity<List<Board>>(list, HttpStatus.OK);
		}
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}

	@GetMapping(value = "/posts/{num}")
	public ResponseEntity<?> read(@PathVariable String num) {
		Board b = boardService.selectOne(num);
		
		if(b != null) {
			return new ResponseEntity<Board>(b, HttpStatus.OK);
		}
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}

	@PostMapping(value="/posts")
	public ResponseEntity<?> insertForm(@RequestBody Board b) {
		int res = boardService.insert(b);
		
		if(res != 0) {
			return new ResponseEntity<String>(HttpStatus.OK);
		}
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping(value="/posts/{num}")
	public ResponseEntity<?> delete(@PathVariable String num) {
		int res = boardService.delete(num);
		
		if(res != 0) {
			return new ResponseEntity<String>(HttpStatus.OK);
		}
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}
	
	// name, title search
	@GetMapping(value="posts/{search}/{word}")
	public ResponseEntity<?> search(@PathVariable String search, @PathVariable String word) {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("search", search);
		map.put("word", word);
		List<Board> list = boardService.search(map);
		
		if(list!=null && !list.isEmpty()) {
			return new ResponseEntity<List<Board>>(list, HttpStatus.OK);
		}
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping(value="/posts")
	public ResponseEntity<?> modify(@RequestBody Board b) {
		int res = boardService.modify(b);

		if(res != 0) {
			return new ResponseEntity<String>(HttpStatus.OK);
		}
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}
	
}
