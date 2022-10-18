package com.coffee.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// @Component: xml 문서 안의 <bean> 태그를 대신해서 객체를 생성해줌
@Component("star")
public class Starbucks implements CoffeeShop {

	// 주입 받아야함
	// @Autowired: type 기준으로 주입됨. type-> 필드 이름-> @Qualifier 순서로 찾음
	@Autowired
	@Qualifier("coffee1")
	Americano ame;
	
	@Autowired
	@Qualifier("coffee4")
	CafeLatte latte;

	@Override
	public void info() {
		System.out.println(getClass().getName());
		ame.info();
		latte.info();
	}
	
}
