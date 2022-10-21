package com.mvc.mapper;

import java.util.HashMap;

import com.mvc.vo.User;

//Service를 위한 인터페이스
public interface UserMapper {
	public User login(HashMap<String, String> map);
}
