package com.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CollectionApp {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("collection.xml");
		MyCollection col = context.getBean("col", MyCollection.class);
		
		col.arrayInfo();
		System.out.println();
		col.listInfo();
		System.out.println();
		col.setInfo();
		System.out.println();
		col.mapInfo();
		System.out.println();
	}

}
