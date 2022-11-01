package com.todo.service;

import java.util.HashMap;
import java.util.List;

import com.todo.vo.Todo;

public interface TodoService {

	// 초기화면
	List<Todo> allList();// 모든 할일 목록(list)
	Todo findByNum(HashMap<String, String> map) throws Exception;; // 번호로 검색. 상세화면(read)
	
	// 검색창에 검색
	List<Todo> findById(String word) throws Exception; // 사용자 id로 검색
	List<Todo> search(HashMap<String, String> map) throws Exception;

	int add(Todo todo) throws Exception;// 할일 등록
	int modify(Todo todo) throws Exception;// 할일 내용 수정
	int delete(String num) throws Exception;// 삭제 기준(사용자 id or 번호)으로 할일 삭제
	int complete(String num) throws Exception;// 번호기준 완료 여부 변경 (N->Y)
	int incomplete(String num);
	int deleteAll() throws Exception; // 모든 내용 삭제
}
