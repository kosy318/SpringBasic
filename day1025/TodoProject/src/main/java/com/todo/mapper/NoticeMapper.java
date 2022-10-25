package com.todo.mapper;

import java.util.List;

import com.todo.vo.Notice;

// Service를 위한 인터페이스
public interface NoticeMapper {
	
	List<Notice> allList();// 모든 공지 목록
	Notice findByNum(String num); // 번호로 검색
	List<Notice> findByContent(String word);
	
	boolean add(Notice notice); // 공지 등록
	boolean modify(Notice notice);// 공지 수정
	boolean delete(String num);// 삭제 기준으로 공지 삭제

}
