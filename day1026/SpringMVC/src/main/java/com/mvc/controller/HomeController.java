package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	// 요청하고 mapping되는 것을 찾는다. HandlerMapping
	// http://localhost:8080/mvc
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		String city = "seoul";
		
		// request에서 발생한 data를 view까지 가져갈 수 있게
		// map구조의 데이터 저장 자료구조
		model.addAttribute("city", city);
		model.addAttribute("code", "a12345");
		return "home"; // return하는 값은 논리적인 view의 이름
	}
	
	// http://localhost:8080/mvc/test
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(Model model) {
		String msg = "hello world!";
		
		model.addAttribute("msg", msg);
		return "test"; // return하는 값은 논리적인 view의 이름
	}
	
}
