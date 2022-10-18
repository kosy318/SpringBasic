package com.coffee.config;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

public class CoffeeBean implements CoffeeShop {

	Americano ame;
	CafeLatte latte;
	
	public void setAme(Americano ame) {
		this.ame = ame;
	}

	public void setLatte(CafeLatte latte) {
		this.latte = latte;
	}

	@Override
	public void info() {
		System.out.println(getClass().getName());
		ame.info();
		latte.info();
	}

}
