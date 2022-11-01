package com.rest.controller;

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

import com.mvc.service.CustomerService;
import com.mvc.vo.Customer;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

//@RestController: @Controller + @ResponseBody
@CrossOrigin("*")
@RestController
@Api(value = "CustomerRestController-Version 1") // 이 클래스가 swagger리소스임을 표시
public class CustomerRestController {
	@Autowired
	CustomerService service;
	
	@GetMapping(value="/customers")
	@ApiOperation(value = "slectAll", notes = "전체 customer 목록 반환")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "페이지없음"),
		@ApiResponse(code = 500, message = "서버에러") })
	public ResponseEntity<List<Customer>> selectAll(){
		List<Customer> list = service.selectAll();
		if(list!=null && !list.isEmpty()) {
			ResponseEntity<List<Customer>> re = new ResponseEntity<List<Customer>>(list, HttpStatus.OK);
			return re;
		}
		else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@ApiOperation(value = "Customer Insert", notes = "새 customer 등록")
	@PostMapping(value="/customers")
	public ResponseEntity<?> insertMember(@RequestBody Customer customer){
		int ins = service.insert(customer);
		if(ins!=0) {
			return new ResponseEntity(HttpStatus.OK);
		}
		else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@ApiOperation(value = "Customer Update", notes = "customer 수정")
	@PutMapping(value="/customers")
	public ResponseEntity<?> updateMember(@RequestBody Customer customer){
		int ins = service.update(customer);
		if(ins!=0) {
			return new ResponseEntity(HttpStatus.OK);
		}
		else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@ApiOperation(value = "Customer Delete", notes = "customer 삭제")
	@DeleteMapping(value="/customers/{num}")
	public ResponseEntity<?> deleteMember(@PathVariable String num){
		int ins = service.delete(num);
		if(ins!=0) {
			return new ResponseEntity(HttpStatus.OK);
		}
		else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	
	@ApiOperation(value = "Customer Read", notes = "customer 한 명 정보")
	@ApiImplicitParams({
		@ApiImplicitParam(name = "num", value = "번호", required = true, dataType = "String", paramType = "path")})
	@GetMapping(value="/customers/{num}")
	public ResponseEntity<?> selectOne(@PathVariable String num){
		Customer c =  service.selectOne(num);
		
		if(c!=null) {
			return new ResponseEntity<Customer>(c,HttpStatus.OK);
		}
		else {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
	}
	

	@ApiOperation(value = "Customer Search", notes = "주소 기준 검색")
	@ApiResponses({ @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "페이지없음"),
			@ApiResponse(code = 500, message = "서버에러") })
	@GetMapping(value="/customers/find/{address}")
	public List<Customer> findByAddress2(@PathVariable String address) {
		
		return service.findByAddress(address);
	}


}
