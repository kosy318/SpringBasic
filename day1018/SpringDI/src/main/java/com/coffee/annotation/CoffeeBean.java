package com.coffee.annotation;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

// @Component 사용시 id를 지정하지 않으면 클래스 이름이 id가 되고 첫번째 글자는 소문자로 바뀜
@Component
public class CoffeeBean implements CoffeeShop {

	// @Resource: name 기준으로 주입됨
	// 이름을 정해놓지 않으면 필드 이름으로 찾는다.
	// id에 없으면 name에서 찾는다
	@Resource
	Americano ame;
	
	@Resource(name="coffee2")
	CafeLatte latte;
	
	@Override
	public void info() {
		System.out.println(getClass().getName());
		ame.info();
		latte.info();
	}

}
