package com.ssafy.admin.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.service.MemberService;

@RestController // responsebody 안해도 모든 것이 responsebody로 인식이 된다.
@RequestMapping("/admin")
public class AdminUserController {
	
	private MemberService memberService;
	
	public AdminUserController(MemberService memberService) {
		super();
		this.memberService = memberService;
	}

	@GetMapping("/user")
	public ResponseEntity<?> userList(){
		try {
			List<MemberDto> list = memberService.listMember(null); // >> JSON Array
			if(list != null && !list.isEmpty()) {
				return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return exceptionHandling(e);
		}
	}

	@DeleteMapping("/user/{user_id}")
	public ResponseEntity<?> userDelete(@PathVariable("user_id") String userId){
		try {
			System.out.println(userId);
			memberService.deleteMember(userId);
			List<MemberDto> list = memberService.listMember(null); // >> JSON Array
			if(list != null && !list.isEmpty()) {
				return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return exceptionHandling(e);
		}
	}

	@GetMapping("/user/{user_id}")
	public ResponseEntity<?> userView(@PathVariable("user_id") String userId){
		try {
			MemberDto memberDto = memberService.getMember(userId);
			if(memberDto != null) {
				return new ResponseEntity<MemberDto>(memberDto, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return exceptionHandling(e);
		}
	}
	
	@PostMapping("/user")
	public ResponseEntity<?> userJoin(@RequestBody MemberDto memberDto){
		try {
			memberService.joinMember(memberDto);
			List<MemberDto> list = memberService.listMember(null); // >> JSON Array
			if(list != null && !list.isEmpty()) {
				return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return exceptionHandling(e);
		}
	}
	
	@PutMapping("/user")
	public ResponseEntity<?> userModify(@RequestBody MemberDto memberDto){
		try {
			memberService.modifyMember(memberDto);
			List<MemberDto> list = memberService.listMember(null); // >> JSON Array
			if(list != null && !list.isEmpty()) {
				return new ResponseEntity<List<MemberDto>>(list, HttpStatus.OK);
			} else {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return exceptionHandling(e);
		}
	}

	private ResponseEntity<String> exceptionHandling(Exception e) {
		return new ResponseEntity<String>("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
