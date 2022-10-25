package com.todo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.mapper.TodoMapper;
import com.todo.vo.Todo;

@Service
public class TodoServiceImpl implements TodoService {
	
	@Autowired
	TodoMapper mapper;

	@Override
	public List<Todo> allList() {
		return mapper.allList();
	}

	@Override
	public Todo findByNum(String num) throws Exception {
		return mapper.findByNum(num);
	}

	@Override
	public List<Todo> findById(String word) throws Exception {
		return mapper.findById(word);
	}

	@Override
	public List<Todo> findByContent(String word) throws Exception {
		return mapper.findByContent(word);
	}

	@Override
	public boolean add(Todo todo) throws Exception {
		return mapper.add(todo);
	}

	@Override
	public boolean modify(Todo todo) throws Exception {
		return mapper.modify(todo);
	}

	@Override
	public boolean delete(String num) throws Exception {
		return mapper.delete(num);
	}

	@Override
	public boolean complete(String num) throws Exception {
		return mapper.complete(num);
	}

	@Override
	public void incomplete(String num) {
		mapper.incomplete(num);
	}
	
	@Override
	public void deleteAll() throws Exception {
		mapper.deleteAll();
	}

}
