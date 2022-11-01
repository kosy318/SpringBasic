package com.mvc.vo;

//vo(value object):customer 
public class Customer {
	
	//@NotEmpty @Size(min=4, max=12)
	private String num;

	//@NotEmpty @Size(min=4, max=12)
	private String name;
	
	//@NotEmpty @Email
	private String address;	
	

	public Customer() {}	
	
	public Customer(String num, String name, String address) {
		this.num = num;
		this.name = name;
		this.address = address;
	}

	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
