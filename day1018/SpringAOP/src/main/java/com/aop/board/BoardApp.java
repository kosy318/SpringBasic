package com.aop.board;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BoardApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("board.xml");
		
		Board b = context.getBean("myboard", Board.class);
		b.write("writing");
		b.write("writing2");
		System.out.println(b.read(1));
		b.delete(0);
	}
	
}
