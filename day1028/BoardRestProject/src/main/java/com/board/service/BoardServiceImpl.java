package com.board.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.mapper.BoardMapper;
import com.board.vo.Board;

//BoardService인터페이스 안의 메소드를 구현한 객체
//Controller에게서 들어온 요청을 처리하는 객체
//mapper에게 요청을 넘김
@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	BoardMapper mapper;//interface type

	@Override
	public ArrayList<Board> selectAll() {		
		System.out.println(mapper);
		return mapper.selectAll();
	}

	@Override
	public Board selectOne(String num) {
		mapper.countUp(num);//해당 번호의 글 조회수를 올림
		return mapper.selectOne(num);
	}

	@Override
	public int insert(Board b) {
		return mapper.insert(b);
	}

	@Override
	public int delete(String num) {
		
		return mapper.delete(num);
	}

	@Override
	public ArrayList<Board> search(HashMap<String, String> map) {
		return mapper.search(map);
	}

	@Override
	public int modify(Board b) {
		return mapper.modify(b);
	}

}
