package com.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BoardTest {

	public static void main(String[] args) {
		String conf = "res/Configuration.xml"; // 설정파일
		Reader reader;

		// Resources 클래스는 클래스패스나 파일 시스템 또는 웹 URL에서 자원으로 로드하도록 해준다.
		try {
			reader = Resources.getResourceAsReader(conf);

			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			SqlSessionFactory factory = builder.build(reader);
			SqlSession session = factory.openSession(); // false(default), true(auto commit)

			System.out.println("selectAll------------------------------------------------------------------");
			// selectList() : select 결과가 여러건일때
			List<Board> list = session.selectList("Board.selectAll");
			for (Board b : list) {
				System.out.println(b);
			}

			System.out.println("selectOne------------------------------------------------------------------");

			// selectOne
			Board b1 = session.selectOne("Board.selectOne", "10");
			System.out.println(b1);

			System.out.println("insert------------------------------------------------------------------");

			// insert
			Board in = new Board(null, "1234", "이름", null, "제목", "내용", 0);
			session.insert("Board.insert", in);
			session.commit();
			list = session.selectList("Board.selectAll");
			for (Board b : list) {
				System.out.println(b);
			}
			
			System.out.println("count up------------------------------------------------------------------");

			// count up
			session.update("countUp", "1");
			session.commit();
			list = session.selectList("Board.selectAll");
			for (Board b : list) {
				System.out.println(b);
			}
			

			System.out.println("delete------------------------------------------------------------------");

			// delete
			String num = "33";
			session.delete("Board.delete", num);
			session.commit();
			list = session.selectList("Board.selectAll");
			for (Board b : list) {
				System.out.println(b);
			}

			System.out.println("update------------------------------------------------------------------");

			// update
			Board b2 = session.selectOne("Board.selectOne", "22");
			b2.setTitle("Testing");
			session.update("Board.update", b2);
			session.commit();
			list = session.selectList("Board.selectAll");
			for (Board b : list) {
				System.out.println(b);
			}

			System.out.println("selectByTitle------------------------------------------------------------------");

			HashMap<String, String> map = new HashMap<String, String>();
			map.put("condition", "title");
			map.put("word", "2");
			// 제목으로 검색
			List<Board> list2 = session.selectList("Board.select", map);
			for (Board b : list2) {
				System.out.println(b);
			}
			
			System.out.println("selectByName------------------------------------------------------------------");

			map.put("condition", "name");
			map.put("word", "test");
			// 이름으로 검색
			List<Board> list3 = session.selectList("Board.select", map);
			for (Board b : list3) {
				System.out.println(b);
			}
			
			System.out.println("login------------------------------------------------------------------");
			// login
		} catch (IOException e) {
			e.printStackTrace();
		} // 입력 스트림을 사용해서 read conf xml file 리소스를 가져옵니다.
	}

}
