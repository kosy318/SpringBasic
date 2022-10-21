package com.mvc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.service.BoardService;
import com.mvc.service.UserService;
import com.mvc.vo.Board;
import com.mvc.vo.User;

@Controller
public class BoardController {
	
	@Autowired
	BoardService service;// interface type
	
	@Autowired
	UserService uservice;

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
	
	@PostMapping(value="login")
	public String loginProcess(HttpSession session, String id, String pass) { // id, pass 받아와서 db 가서 체크한 후에 세션에 저장
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pass", pass);
		User user = uservice.login(map);
		if(user != null && user.getId().equals(id)) {
			session.setAttribute("id", id);
			return "redirect:/list";
		}
		return "redirect:/login";
	}
	
	@GetMapping(value="logout")
	public String logout(HttpSession session) {
		session.setAttribute("id", null);
		return "redirect:/list";
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
		HashMap<String, String> map = new HashMap<>();
		map.put("search", search);
		map.put("word", word);
		ArrayList<Board> list = service.search(map);
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
	
	@GetMapping(value="test")
	public String test(Model model) {
		service.test();
		return "redirect:/list";
	}
	
	//@ExceptionHandler(Exception.class)
	public ModelAndView exceptionHandle(Exception e){
		ModelAndView mv = new ModelAndView();
		mv.addObject("errormsg", "errorrrrrrr"); // data 저장	
		mv.setViewName("errorPage"); // view 이름
		return mv;
	}
	
}
