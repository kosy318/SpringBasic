package com.smart.phone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("delightshop")
public class DelightShop implements ElecShop {
	
	@Autowired
	Gallaxy[] gallaxy;

	@Override
	public void productList() {
		System.out.print("DelightShop--------");
		for(Gallaxy g : gallaxy) {
			System.out.println();
			g.info();
		}
		System.out.println("-----------------");
	}

}
