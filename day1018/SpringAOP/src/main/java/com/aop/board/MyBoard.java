package com.aop.board;

import java.util.HashMap;

// target 객체
public class MyBoard implements Board {
	
	int num;
	static HashMap<Integer, String> post;
	
	public MyBoard() {
		post = new HashMap<Integer, String>();
	}

	@Override
	public String read(int num) {
		return post.get(num);
	}

	@Override
	public void delete(int num) {
		post.remove(num);
	}

	@Override
	public void write(String content) {
		post.put(num, content);
		num += 1;
	}

}
