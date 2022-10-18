package com.mycom.myappcalc.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // Spring이 인식하는 특별한 자바 클래스
public class CalcConfiguration {
	
	@Bean
	public Calculator calculator() {
		return new Calculator();
	}

}
