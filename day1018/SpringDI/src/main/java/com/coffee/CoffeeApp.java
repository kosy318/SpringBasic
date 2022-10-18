package com.coffee;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CoffeeApp {

	public static void main(String[] args) {
		// 클래스 패스 : src/main/resource
		// ClassPathXmlApplicationContext : 클래스패스로 지정된 폴더에서 xml문서를 읽어와서 객체를 생성해주는 컨테이너
		ApplicationContext context = new ClassPathXmlApplicationContext("coffee.xml");
		
		CoffeeShop shop = context.getBean("star", CoffeeShop.class);
		shop.info();
		
		System.out.println();

		shop = context.getBean("bean", CoffeeShop.class);
		shop.info();
		
//		Coffee cof = context.getBean("coffee1", Coffee.class); //필요한 객체를 얻어오는 메소드
//		cof.info();	
	}

}
