package com.mycom.myapp.calc.all;

import org.springframework.stereotype.Component;

@Component("aaa") // interface는 객체를 만들지 못하기 때문에 implements 한 class에 붙인다.
public class CalculatorImpl implements Calculator {

	@Override
	public int add(int n1, int n2) {
		System.out.println("CalculatorImpl - 1");
		return n1 + n2;
	}
	
}
