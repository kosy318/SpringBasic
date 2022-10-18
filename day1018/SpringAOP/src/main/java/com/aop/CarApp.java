package com.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CarApp {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("aop.xml");
		
		Car c = context.getBean("avante", Car.class);
		c.setColor("red"); // 핵심 메소드 호출
		System.out.println(c.getColor());
	}

}
