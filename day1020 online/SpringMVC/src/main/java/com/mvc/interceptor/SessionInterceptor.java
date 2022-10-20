package com.mvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

// 글쓰기 요청이 들어왔을 때 인터셉터가 체크해서 로그인 여부 확인 후에 로그인 화면ㅇ으로 보내거나 글쓰기 화면으로 보내거나 함
// servlet-context에 등록
@Component
public class SessionInterceptor implements HandlerInterceptor {

	// 컨트롤러가 호출되기 전에 실행됨: 로그인 여부
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println(handler);
		
		HttpSession session = request.getSession();
		if(session.getAttribute("id") != null) {
			return true; // 컨트롤러로 전달됨
		} else {
			response.sendRedirect("login");
			return false;
		}
	}

	// 컨트롤러가 호출되고 나서 실행됨
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
	
}
