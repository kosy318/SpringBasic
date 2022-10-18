package com.animal;

public class Lion implements Animal {

	int age;
	String name;
	
	public Lion(int age) {
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
