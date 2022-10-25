package com.todo.service;

import java.util.List;

import com.todo.vo.Notice;

public interface NoticeService {

	List<Notice> allList();// 모든 공지 목록
	Notice findByNum(String num) throws Exception;; // 번호로 검색. 상세화면(readNotice)
	
	// 검색창에 검색
	List<Notice> findByContent(String word) throws Exception; // 내용으로 like 검색

	boolean add(Notice notice) throws Exception;// 공지 등록
	boolean modify(Notice notice) throws Exception;// 공지 내용 수정
	boolean delete(String num) throws Exception;// 공지 삭제
}
