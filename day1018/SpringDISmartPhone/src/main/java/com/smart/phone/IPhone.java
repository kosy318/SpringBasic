package com.smart.phone;

public class IPhone implements SmartPhone {

	String model;
	int price;
	String color;

	public IPhone(String model, int price) {
		this.model = model;
		this.price = price;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	@Override
	public void info() {
		System.out.println(getClass().getSimpleName());
		System.out.println("model : " + model);
		System.out.println("price : " + price + "원");
		System.out.println("color : " + color);
	}

}
