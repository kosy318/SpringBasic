package com.mvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class SessionInterceptor implements HandlerInterceptor {

	// 컨트롤러가 호출되기 전에 실행됨: 로그인 여부
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println(handler);

		HttpSession session = request.getSession();
		if (session.getAttribute("id") != null) {
			return true; // 컨트롤러로 전달됨
		} else {
			response.sendRedirect("login");
			return false;
		}
	}
}