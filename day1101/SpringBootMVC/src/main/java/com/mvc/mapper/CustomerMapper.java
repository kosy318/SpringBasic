package com.mvc.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mvc.vo.Customer;

//client(CustomerServiceImpl.java)
@Mapper
public interface CustomerMapper {
	public List<Customer> selectAll();
	public Customer selectOne(String num);
	public int insert(Customer c);
	
	public int delete(String num);
	public List<Customer> findByAddress(String address);
	public int update(Customer c);
	
}





