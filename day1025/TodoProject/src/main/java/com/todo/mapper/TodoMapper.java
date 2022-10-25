package com.todo.mapper;

import java.util.List;

import com.todo.vo.Todo;

// Service를 위한 인터페이스
public interface TodoMapper {
	
	List<Todo> allList();// 모든 할일 목록
	Todo findByNum(String num); // 번호로 검색
	List<Todo> findById(String word); // 사용자 id로 검색
	List<Todo> findByContent(String word);
//	List<Todo> findByDate(String sdate, String edate);// 날짜로 검색
	
	boolean add(Todo todo);// 할일 등록
	boolean modify(Todo todo);// 할일 내용 수정
	boolean delete(String num);// 삭제 기준(사용자 id or 번호)으로 할일 삭제
	boolean complete(String num);// 번호기준 완료 여부 변경 (N->Y)
	void incomplete(String num);
	void deleteAll(); // 모든 내용 삭제

}
