package com.todo.service;

import java.util.HashMap;
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
	public Todo findByNum(HashMap<String, String> map) throws Exception {
		return mapper.findByNum(map);
	}

	@Override
	public List<Todo> findById(String word) throws Exception {
		return mapper.findById(word);
	}

	@Override
	public int add(Todo todo) throws Exception {
		return mapper.add(todo);
	}

	@Override
	public int modify(Todo todo) throws Exception {
		return mapper.modify(todo);
	}

	@Override
	public int delete(String num) throws Exception {
		return mapper.delete(num);
	}

	@Override
	public int complete(String num) throws Exception {
		return mapper.complete(num);
	}

	@Override
	public int incomplete(String num) {
		return mapper.incomplete(num);
	}
	
	@Override
	public int deleteAll() throws Exception {
		return mapper.deleteAll();
	}

	@Override
	public List<Todo> search(HashMap<String, String> map) throws Exception {
		return mapper.search(map);
	}

}
