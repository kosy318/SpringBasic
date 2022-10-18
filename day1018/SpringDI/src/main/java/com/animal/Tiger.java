package com.animal;

public class Tiger implements Animal {
	
	int age;
	String name;
	
	public Tiger(int age) {
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void info() {
		System.out.println(getClass().getSimpleName());
		System.out.println("name : " + name);
		System.out.println("age : " + age);
	}

}
