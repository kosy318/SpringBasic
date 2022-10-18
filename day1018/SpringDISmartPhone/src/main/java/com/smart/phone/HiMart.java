package com.smart.phone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("himart")
public class HiMart implements ElecShop {

	@Autowired
	Gallaxy[] gallaxy;
	@Autowired
	IPhone[] iphone;

	@Override
	public void productList() {
		System.out.println("HiMart-------------");
		System.out.print("-----gallaxy-----");
		for(Gallaxy g : gallaxy) {
			System.out.println();
			g.info();
		}
		System.out.println("-----------------");
		System.out.print("-----iphone------");
		for(Gallaxy g : gallaxy) {
			System.out.println();
			g.info();
		}
		System.out.println("-----------------");
	}

}
