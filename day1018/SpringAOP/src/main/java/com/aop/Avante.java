package com.aop;

// Target 객체: 클라이언트가 호출할 핵심 메소드를 가지고 있는 객체
public class Avante implements Car {
	
	String color;

	@Override
	public void setColor(String color) {
		System.out.println("setColor 호출!");
		this.color = color;
	}

	@Override
	public String getColor() {
		System.out.println("getColor 호출!");
		return color;
	}

}
