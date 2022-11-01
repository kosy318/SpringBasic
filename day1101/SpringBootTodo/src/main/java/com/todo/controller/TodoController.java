package com.todo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.todo.service.TodoService;
import com.todo.vo.Todo;

import io.swagger.annotations.Api;

@RestController
@Api(value = "TodoContoller")
public class TodoController {

	@Autowired
	TodoService service;

	@GetMapping(value = "/todo")
	public ResponseEntity<?> allList(HttpSession session) throws Exception {
//		List<Todo> todoList = service.allList();
//		User user = (User) session.getAttribute("user");
//		List<Todo> todoList = service.findById(user.getId());
		List<Todo> todoList = service.allList();
		if(todoList != null) {
			return new ResponseEntity<List<Todo>>(todoList, HttpStatus.OK);
		}else {
			todoList = new ArrayList<>(); 
			return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		}
	}
	
	@GetMapping(value = "/todo/{num}")
	public ResponseEntity<?> findByNum(@PathVariable String num, HttpSession session) throws Exception {
//		User user = (User) session.getAttribute("user");
		HashMap<String, String> map = new HashMap<>();
		map.put("num", num);
//		map.put("id", user.getId());
		Todo todo = service.findByNum(map);
		if(todo != null) {
			return new ResponseEntity<Todo>(todo, HttpStatus.OK);
		}
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(value = "/todo/{search}/{word}")
	public ResponseEntity<?> search(@PathVariable String search, @PathVariable String word) throws Exception {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("search", search);
		map.put("word", word);
		List<Todo> list = service.search(map);
		
 		if(list!=null && !list.isEmpty()) {
			return new ResponseEntity<List<Todo>>(list, HttpStatus.OK);
		}
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}

	@PostMapping(value = "/todo")
	public ResponseEntity<?> insertForm(@RequestBody Todo todo) throws Exception {
		int res = service.add(todo);
		
		if(res != 0) {
			return new ResponseEntity<String>(HttpStatus.OK);
		}
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}

	@PutMapping(value = "/todo")
	public ResponseEntity<?> modify(@RequestBody Todo todo) throws Exception {
		int res = service.modify(todo);

		if(res != 0) {
			return new ResponseEntity<String>(HttpStatus.OK);
		}
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping(value = "/todo/{num}")
	public ResponseEntity<?> delete(@PathVariable String num) throws Exception {
		int res = service.delete(num);
		
		if(res != 0) {
			return new ResponseEntity<String>(HttpStatus.OK);
		}
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping(value = "/todo")
	public ResponseEntity<?> deleteAll() throws Exception {
		int res = service.deleteAll();

		if(res != 0) {
			return new ResponseEntity<String>(HttpStatus.OK);
		}
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping(value = "/todo/{num}")
	public ResponseEntity<?> complete(@PathVariable String num) throws Exception {
		int res = service.complete(num);

		if(res != 0) {
			return new ResponseEntity<String>(HttpStatus.OK);
		}
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping(value = "/todo/{num}/{done}")
	public ResponseEntity<?> change(@PathVariable String done, @PathVariable String num) throws Exception {
		int res = 0;
		if(done.equals("N")) res = service.complete(num);
		else res = service.incomplete(num);

		if(res != 0) {
			return new ResponseEntity<String>(HttpStatus.OK);
		}
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}
}
