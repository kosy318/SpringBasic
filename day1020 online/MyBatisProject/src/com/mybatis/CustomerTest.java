package com.mybatis;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class CustomerTest {
	
	public static void main(String[] args) {
		String conf = "res/Configuration.xml"; // 설정파일
		Reader reader;
		
		// Resources 클래스는 클래스패스나 파일 시스템 또는 웹 URL에서 자원으로 로드하도록 해준다.
		try {
			reader = Resources.getResourceAsReader(conf);
			
			SqlSessionFactoryBuilder builder  = new SqlSessionFactoryBuilder();
			SqlSessionFactory factory = builder.build(reader);
			SqlSession session = factory.openSession();	 // false(default), true(auto commit)
			
			// 1. selectList() : select 결과가 여러건일때
			List<Customer> list = session.selectList("Customer.selectAll");
			for(Customer c : list) {
				System.out.println(c);
			}
			
			System.out.println("------------------------------------------------------------------");
			
			// 2. selectOne
			Customer c = session.selectOne("Customer.selectOne", "111");
			System.out.println(c);
			
			// 3. insert
			
			session.commit();
			
			// 4. delete
			
			// 5. update
			
			// 6. 주소로 검색
		} catch (IOException e) {
			e.printStackTrace();
		} // 입력 스트림을 사용해서 read conf xml file 리소스를 가져옵니다.
	}

}
