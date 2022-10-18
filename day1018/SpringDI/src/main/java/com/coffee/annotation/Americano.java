package com.coffee.annotation;

public class Americano implements Coffee{
	//info() 호출 전에 값이 주입이 되어 있어야 함
	int price;
	String origin;
	
	public Americano(int price) { // 생성자로 주입
		this.price=price;
	}
	
	
	public void setOrigin(String origin) { // setter로 주입
		this.origin = origin;
	}


	public void info() {
		System.out.println("Americano:강렬한 에스프레소 샷과 뜨거운 물의 조화");
		System.out.println("가격: "+price); // info 메소드가 호출되기 전에 값이 주입되어야 한다
		System.out.println("원산지: "+origin);
	}

}
