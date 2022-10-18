package com.animal;

public class LondonZoo implements Zoo {

	Tiger t1;
	Lion l1;
	
	public LondonZoo(Tiger t1) {
		this.t1 = t1;
	}

	public void setL1(Lion l1) {
		this.l1 = l1;
	}

	@Override
	public void info() {
		System.out.println(getClass().getSimpleName());
		t1.info();
		l1.info();
	}
}
