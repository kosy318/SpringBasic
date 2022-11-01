package com.board.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.board.vo.Board;

//Service를 위한 인터페이스
@Mapper
public interface BoardMapper {
	ArrayList<Board> selectAll();//모든 레코드 검색
	Board selectOne(String num);//해당 번호의 레코드 검색
	int insert(Board b);//새 레코드 추가
	int countUp(String num);
	int delete(String num);
	ArrayList<Board> search(HashMap<String, String> map);
	int modify(Board b);
}
