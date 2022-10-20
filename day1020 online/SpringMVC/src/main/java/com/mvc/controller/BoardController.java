package com.mvc.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvc.model.service.BoardService;
import com.mvc.model.vo.Board;

@Controller
public class BoardController {
	
	@Autowired
	BoardService service;// interface type

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model) {
		ArrayList<Board> list = service.selectAll();
		model.addAttribute("list", list);
		return "list";
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	// public String read(@RequestParam String num, Model model) {
	// public String read(@RequestParam("num") String no, Model model) {
	public String read(String num, Model model) {
		Board b = service.selectOne(num);
		model.addAttribute("b", b);

		return "read";
	}

	@GetMapping(value="insert")
	public String insertForm() {
		return "insert";
	}
	
	@GetMapping(value="login")
	public String login() {
		return "loginForm";
	}

	@PostMapping(value="insert")
	public String insertProcess(String how, Board b) throws IOException {
		if(how.equals("insert")) service.insert(b);
		else if(how.equals("modify")) service.modify(b);
		
		return "redirect:/list";
	}

	@GetMapping(value="delete")
	public String delete(String num) {
		service.delete(num);
		
		return "redirect:/list";
	}
	
	@GetMapping(value="search")
	public String search(String search, String word, Model model) {
		ArrayList<Board> list = service.searchWord(search, word);
		model.addAttribute("list", list);
		model.addAttribute("word", word);
		return "search";
	}
	
	@GetMapping(value="modify")
	public String modify(String num, Model model) {
		Board b = service.selectOne(num);
		model.addAttribute("b", b);
		
		return "modify";
	}
}
