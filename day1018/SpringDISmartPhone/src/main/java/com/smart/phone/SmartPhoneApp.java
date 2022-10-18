package com.smart.phone;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SmartPhoneApp {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("smartphone.xml");
		
		ElecShop delightshop = context.getBean("delightshop", ElecShop.class);
		delightshop.productList();
		
		ElecShop himart = context.getBean("himart", ElecShop.class);
		himart.productList();
	}

}
