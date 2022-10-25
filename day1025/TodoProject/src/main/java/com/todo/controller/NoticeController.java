package com.todo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.todo.service.NoticeService;
import com.todo.vo.Notice;

@Controller
public class NoticeController {

	@Autowired
	NoticeService service;

	@GetMapping("notice-list")
	public String allList(Model model) {
		List<Notice> noticeList = service.allList();
		model.addAttribute("noticeList", noticeList);
		
		return "notice-list";
	}
	
	@GetMapping("notice-read")
	public String findByNum(String num, Model model) throws Exception {
		Notice notice = service.findByNum(num);
		model.addAttribute("notice", notice);
		
		return "notice-read";
	}
	
	@GetMapping("notice-searchAll")
	public String searchAll(String search, String word, Model model) throws Exception{
		List<Notice> noticeList = service.findByContent(word);
		model.addAttribute("noticeList", noticeList);
		
		return "notice-list";
	}
	
	@GetMapping("notice-insert")
	public String insertForm() {
		return "notice-insert";
	}
	
	@PostMapping("notice-insert")
	public String insertProcess(Notice notice) throws Exception {
		service.add(notice);
		return "redirect:/notice-list";
	}
	
	@GetMapping("notice-modify")
	public String modifyForm(String num, Model model) throws Exception{
		Notice notice = service.findByNum(num);
		model.addAttribute("notice", notice);
		
		return "notice-modify";
	}
	
	@PostMapping("notice-modify")
	public String modifyProcess(Notice notice) throws Exception {
		service.modify(notice);
		return "redirect:/notice-list";
	}
	
	@GetMapping("notice-delete")
	public String delete(String num) throws Exception {
		service.delete(num);
		return "redirect:/notice-list";
	}
	
}
