package com.mycom.myapp.calc.hasa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // annotation 기반 spring에 자신 객체를 등록
public class UseCalculator {
	
	// #1 field에 주입
//	@Autowired // 아래 type에 맞는 객체를 만들어서 DI 해달라는 의미
//	Calculator calculator;
	
	// #2. setter 주입
//	Calculator calculator;
//	
//	@Autowired
//	public void setCalculator(Calculator calculator) {
//		this.calculator = calculator;
//	}
	
	// #3. constructor 주입
	Calculator calculator;
	
	@Autowired
	public UseCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
	
	public int add(int n1, int n2) {
		return calculator.add(n1, n2);
	}

}
