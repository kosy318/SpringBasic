package com.coffee.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Configuration: xml문서를 대신해서 필요한 객체를 생성해 줌.
@Configuration
public class CoffeeConfig {
	
	// @Bean: <bean>태그를 대싷남. <bean id="getAme" class="">
	@Bean
	public Americano getAme() {
		Americano a = new Americano(2000);
		a.setOrigin("kenya");
		return a;
	}
	
	@Bean
	public CafeLatte getLatte() {
		CafeLatte a = new CafeLatte(3500);
		a.setOrigin("columbia");
		return a;
	}

	// <bean id="getStar" ...>
	@Bean
	public Starbucks getStar() {
		return new Starbucks(getAme(), getLatte());
	}

	// <bean id="getBean" ...>
	@Bean
	public CoffeeBean getBean() {
		CoffeeBean c = new CoffeeBean();
		c.setAme(getAme());
		c.setLatte(getLatte());
		return c;
	}
	
}
