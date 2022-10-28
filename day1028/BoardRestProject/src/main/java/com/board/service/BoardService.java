package com.board.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.board.vo.Board;

//Controller를 위한 인터페이스
public interface BoardService {
	ArrayList<Board> selectAll();//모든 레코드 검색
	Board selectOne(String num);//해당 번호의 레코드 검색
	int insert(Board b);//새 레코드 추가
	int delete(String num);
	ArrayList<Board> search(HashMap<String, String> map);
	int modify(Board b);
}
