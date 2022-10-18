package com.aop.board;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

// aspect 객체
@Aspect
public class BoardTracker {
	
	// delete나 write 할 때 로그인 체크
	@Before("execution(void *(*))")
	public void loginCheck(JoinPoint jp) {
		System.out.println(">> 로그인 체크");
	}
	
	// read작업 후에 "num 번호의 글을 읽었습니다."; 로그 남기기(sysout)
	@After("execution(String read(int))")
	public void readTracker(JoinPoint jp) {
		System.out.println(">> " + jp.getArgs()[0] + "번 글을 읽었습니다.");
	}

}
