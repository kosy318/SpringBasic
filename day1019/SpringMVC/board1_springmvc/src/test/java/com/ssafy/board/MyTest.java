package com.ssafy.board;

import static org.junit.Assert.assertSame;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ssafy.board.model.BoardDto;

public class MyTest {

	private final Logger logger = LoggerFactory.getLogger(Test.class);
	
	@Test
	public void listTest() throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("pgno", "1");
		map.put("key", "22");
		map.put("word", "qq");
		
		assertSame(map.get("key"), "22");
	}
	
	@Test(expected=NullPointerException.class)
	public void go() {
		Map<String, String> map = null;
		System.out.println(map.isEmpty());
	}
	
	@Test(timeout = 3000)
	public void go2() {
		try {
			Thread.sleep(1000);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test
//	@Ignore
	public void modifyTest() throws Exception {
		BoardDto boardDto = new BoardDto();
		boardDto.setArticleNo(1);
		boardDto.setSubject("제목 수정해요!!!!");
		boardDto.setContent("내용도 수정해요!!!");
	}

	
}