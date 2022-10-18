package com.animal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnimalApp {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("animal.xml");
		
		Zoo seoulZoo = context.getBean("seoul", Zoo.class);
		seoulZoo.info();
		
		System.out.println("--------------------");
		
		Zoo londonZoo = context.getBean("london", Zoo.class);
		londonZoo.info();
	}

}
