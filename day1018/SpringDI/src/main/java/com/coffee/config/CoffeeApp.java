package com.coffee.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CoffeeApp {

	public static void main(String[] args) {
		// 클래스 패스 : src/main/resource
		// AnnotationConfigApplicationContext : 파라메터로 주어진 자바 클래스를 읽어서 필요한 객체를 생성해줌
		ApplicationContext context = new AnnotationConfigApplicationContext(CoffeeConfig.class);
		
		CoffeeShop shop = (Starbucks)context.getBean("getStar", CoffeeShop.class);
		shop.info();
		
		System.out.println();

		shop = (CoffeeBean)context.getBean("getBean", CoffeeShop.class);
		shop.info();
		
//		Coffee cof = context.getBean("coffee1", Coffee.class); //필요한 객체를 얻어오는 메소드
//		cof.info();	
	}

}
