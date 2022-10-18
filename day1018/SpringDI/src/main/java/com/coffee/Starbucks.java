package com.coffee;

public class Starbucks implements CoffeeShop {

	// 주입 받아야함
	Americano ame;
	CafeLatte latte;

	public Starbucks(Americano ame, CafeLatte latte) {
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
