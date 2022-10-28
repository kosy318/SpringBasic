package com.mvc.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mvc.vo.Customer;

//client(CustomerApp.java)
public interface CustomerService {
	public List<Customer> selectAll();
	public Customer selectOne(String num);
	public int insert(Customer c);
	public List<Customer> findByAddress(String address);
	public int delete(String num);	
	public int update(Customer c);
	
}





