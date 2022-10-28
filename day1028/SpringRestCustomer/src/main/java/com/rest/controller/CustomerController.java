package com.rest.controller;

import java.util.List;

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

import com.mvc.service.CustomerService;
import com.mvc.vo.Customer;

// @ RestController: @Controller + @ResponseBody(응답을 java에서 json으로 바꿔줌)
@RestController
public class CustomerController {
	
	@Autowired
	CustomerService customerService;

	@GetMapping(value="/customers")
	public ResponseEntity<?> selectAll(){
		List<Customer> list = customerService.selectAll();
		if(list != null && !list.isEmpty()) {
			return new ResponseEntity<List<Customer>>(list, HttpStatus.OK);
		}
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}
	
//	@GetMapping(value="/customers2")
//	public List<Customer> selectAll2(){
//		return customerService.selectAll();
//	}
	
	@GetMapping(value="/customers/{num}")
	public Customer selectOne(@PathVariable String num){
		return customerService.selectOne(num);
	}

	@PostMapping(value="/customers")
	public ResponseEntity<?> insert(@RequestBody Customer customer){
		int res = customerService.insert(customer);
		if(res != 0) {
			return new ResponseEntity<String>(HttpStatus.OK);
		}
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}
	
	@PutMapping(value="/customers")
	public ResponseEntity<?> update(@RequestBody Customer customer){
		int res = customerService.update(customer);
		if(res != 0) {
			return new ResponseEntity<String>(HttpStatus.OK);
		}
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}
	
	@DeleteMapping(value="/customers/{num}")
	public ResponseEntity<?> delete(@PathVariable String num){
		int res = customerService.delete(num);
		if(res != 0) {
			return new ResponseEntity<String>(HttpStatus.OK);
		}
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping(value="/customers/find/{address}")
	public ResponseEntity<?> findByAddress(@PathVariable String address){
		List<Customer> list = customerService.findByAddress(address);
		if(list != null && !list.isEmpty()) {
			return new ResponseEntity<List<Customer>>(list, HttpStatus.OK);
		}
		return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
	}
	
}
