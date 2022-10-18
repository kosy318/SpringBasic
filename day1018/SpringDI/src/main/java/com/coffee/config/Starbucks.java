package com.coffee.config;

public class Starbucks implements CoffeeShop {

	Americano ame;
	CafeLatte latte;

	public Starbucks(Americano ame, CafeLatte latte) {
		super();
		this.ame = ame;
		this.latte = latte;
	}

	@Override
	public void info() {
		System.out.println(getClass().getName());
		ame.info();
		latte.info();
	}
	
}
