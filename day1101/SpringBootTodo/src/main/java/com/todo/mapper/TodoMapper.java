package com.todo.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.todo.vo.Todo;

// Service를 위한 인터페이스
@Mapper
public interface TodoMapper {
	
	List<Todo> allList();// 모든 할일 목록
	Todo findByNum(HashMap<String, String> map); // 번호로 검색
	List<Todo> findById(String word); // 사용자 id로 검색
	List<Todo> search(HashMap<String, String> map); // date, content
	
	int add(Todo todo);// 할일 등록
	int modify(Todo todo);// 할일 내용 수정
	int delete(String num);// 삭제 기준(사용자 id or 번호)으로 할일 삭제
	int complete(String num);// 번호기준 완료 여부 변경 (N->Y)
	int incomplete(String num);
	int deleteAll(); // 모든 내용 삭제

}
