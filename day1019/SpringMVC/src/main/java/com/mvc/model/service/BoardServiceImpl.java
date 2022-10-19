package com.mvc.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.model.dao.BoardDAO;
import com.mvc.model.vo.Board;

//BoardService인터페이스 안의 메소드를 구현한 객체
//Controller에게서 들어온 요청을 처리하는 객체
//DAO에게 요청을 넘김
@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	BoardDAO dao;//interface type

	@Override
	public ArrayList<Board> selectAll() {		
		return dao.selectAll();
	}

	@Override
	public Board selectOne(String num) {
		dao.countUp(num);//해당 번호의 글 조회수를 올림
		return dao.selectOne(num);
	}

	@Override
	public void insert(Board b) {
		dao.insert(b);
	}

	@Override
	public int delete(String num) {
		
		return dao.delete(num);
	}

	@Override
	public ArrayList<Board> searchWord(String search, String word) {
		return dao.search(search, word);
	}

	@Override
	public void modify(Board b) {
		dao.modify(b);
	}

}
