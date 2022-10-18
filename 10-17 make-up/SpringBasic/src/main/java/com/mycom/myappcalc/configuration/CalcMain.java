package com.mycom.myappcalc.configuration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CalcMain {

	public static void main(String[] args) {
		// Spring DI 사용 x
//		Calculator calculator = new Calculator(); // 직접 코드에서 객체를 생성
//		System.out.println(calculator.add(5, 7));
		
		// Spring DI 사용
		// Spring 실행환경 구성
		//  Spring Framework에서 제공하는 클래스를 이용
		//  Configuration 클래스 기반에는 xml 문서 사용 x <= xml 문서를 Java Class로 대체
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("calc-xml.xml");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CalcConfiguration.class);
		
		
		// Spring 객체 생성 요구 => Spring이 객체를 생성해서 넘겨준다.
		//  소문자
		Calculator calculator = (Calculator)context.getBean("calculator"); // Spring 에게 객체 생성 요구(만들어 줘!)
		
		System.out.println(calculator.add(7, 7));
	}
	
}
