package com.mvc.service;

import java.util.HashMap;

import com.mvc.vo.User;

public interface UserService {
	User login(HashMap<String, String> map);
}
