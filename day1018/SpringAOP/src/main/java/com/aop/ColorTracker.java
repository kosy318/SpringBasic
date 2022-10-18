package com.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

// Aspect 객체; Advice(what) + Pointcut(when; joinpoint를 하나로 결합) 을 가지고 있음
// pointcut과 일치하는 때가 되면 advice가 weaving 되어 들어가서 실행이 됨
@Aspect
public class ColorTracker {
	
	// proxy가 받아서 넣어줌
	@Before("execution(void set*(*))") // 괄호 안에 pointcut을 적어줌, method가 "set"으로 시작해야하고 parameter는 1개
	public void colorTrack(JoinPoint jp) { // Advice
		System.out.println("------------------");
		System.out.println("before advice 시작!");
		
		System.out.println("target: " + jp.getTarget().getClass().getName());
		System.out.println("method: " + jp.getSignature().getName());
		System.out.println("args: " + jp.getArgs()[0]);
		
		System.out.println("before advice 끝!");
		System.out.println("------------------");
	}

//	@After("execution(String get*())")
//	public void colorTrack2(JoinPoint jp) { // Advice
//		System.out.println("------------------");
//		System.out.println("after advice 시작!");
//		
//		System.out.println("target: " + jp.getTarget().getClass().getName());
//		System.out.println("method: " + jp.getSignature().getName());
//		
//		System.out.println("after advice 끝!");
//		System.out.println("------------------");
//	}
//	오늘 왜캐 축츅 쳐지지.........................
//	당 떨어져 언니
//	살려줘
	@Around("execution(String get*())")
	public Object colorTrack2(ProceedingJoinPoint jp) throws Throwable { // Advice
		System.out.println("------------------");
		System.out.println("before!!!");
		
		Object o = jp.proceed();
		
		System.out.println("after!!!");
		System.out.println("------------------");
		return o;
	}
		
}
