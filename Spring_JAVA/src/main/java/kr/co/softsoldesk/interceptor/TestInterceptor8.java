package kr.co.softsoldesk.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class TestInterceptor8 implements HandlerInterceptor {

	
	//Controller의 메서드가 호출되기 전에 수행
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("TestInterceptor8 - preHandle");
		return true;  // 요청처리에 대한 진행을 중단
	}
	//Controller의 메소드가 호출된 후에 수행
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		System.out.println("TestInterceptor8 - postHandle");

	}
	//View 처리까지 되면 호출됨
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		System.out.println("TestInterceptor8 - atferCompletion");
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

	
}
