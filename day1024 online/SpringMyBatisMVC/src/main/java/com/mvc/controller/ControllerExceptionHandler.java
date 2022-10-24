package com.mvc.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

// 모든 컨트롤러에서 발생하는 예외를 처리하는 클래스
@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ModelAndView exceptionHandle(Exception e){
		ModelAndView mv = new ModelAndView();
		mv.addObject("errormsg", "@@@@@@@@@@@@ERROR@@@@@@@@@@@"); // data 저장	
		mv.setViewName("errorPage"); // view 이름
		return mv;
	}
	
}
