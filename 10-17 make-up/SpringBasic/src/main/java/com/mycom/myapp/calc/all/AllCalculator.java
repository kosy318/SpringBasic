package com.mycom.myapp.calc.all;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class AllCalculator {

	@Autowired
	@Qualifier("bbb")
	Calculator calculator; // interface type을 구현한 객체가 만들어진다.
	
	public int add(int n1, int n2) {
		return calculator.add(n1, n2);
	}
	
}
