package com.mycom.mybatis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycom.mybatis.dto.EmpDto;
import com.mycom.mybatis.service.MybatisService;

// response를 json으로 리턴하고싶다?
@Controller
public class MybatisController {

	@Autowired
	MybatisService service;
	
	// 상세 1건
	@GetMapping(value="/empDetail/{employeeId}")
	@ResponseBody //  메소드가 리턴하는 객체를 spring이 json으로 변환해서 front-end에 전달(response) 한다.
	public EmpDto empDetail(@PathVariable int employeeId) {
		System.out.println(employeeId);
		EmpDto empDto = service.empDetail(employeeId);
		
		return empDto;
	}
	
	// 목록 전체
	@GetMapping(value="/empList")
	@ResponseBody //  메소드가 리턴하는 객체를 spring이 json으로 변환해서 front-end에 전달(response) 한다.
	public List<EmpDto> empList() {
		List<EmpDto> list = service.empList();
		
		return list;
	}
	
	@PostMapping(value="/empInsert")
	@ResponseBody
	public int empInsert(EmpDto dto) { // 자동으로 EmpDto 객체의 
		System.out.println(dto);
		int ret = service.empInsert(dto);
		
		return ret;
	}
	
	@PostMapping(value="/empUpdate")
	@ResponseBody
	public int empUpdate(EmpDto dto) {
		System.out.println(dto);
		int ret = service.empUpdate(dto);
		
		return ret;
	}
	
	@PostMapping(value="/empDelete")
	@ResponseBody
	public int empDelete(int employeeId) {
		System.out.println(employeeId);
		int ret = service.empDelete(employeeId);
		
		return ret;
	}
	
}
