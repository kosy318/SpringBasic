package com.mycom.myapp.calc.all;

import org.springframework.stereotype.Component;

@Component("bbb") // interface는 객체를 만들지 못하기 때문에 implements 한 class에 붙인다.
public class CalculatorImpl2 implements Calculator {

	@Override
	public int add(int n1, int n2) {
		System.out.println("CalculatorImpl - 2");
		return n1 + n2;
	}
	
}
