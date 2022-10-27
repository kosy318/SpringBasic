package com.mvc.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mvc.vo.Board;

// @RestController : @Controller + @ResponseBody(java -> json)
@RestController
@RequestMapping("/api")
public class RestControllerTest {

	@GetMapping(value="/get")
	public Board get() {
		Board b = new Board("123", "23123", "fsdfsdf", "sdsd", "dfs", "sdfsdfse", 22222);
		return b;
	}

	@PostMapping(value="/post")
	public String post() {
		return "this is rest-post";
	}

	@PutMapping(value="/put")
	public String put() {
		return "this is rest-put";
	}

	@DeleteMapping(value="/delete")
	public String delete() {
		return "this is rest-delete";
	}
	
}
