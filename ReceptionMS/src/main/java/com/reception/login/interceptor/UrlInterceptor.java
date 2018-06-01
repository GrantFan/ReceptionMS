package com.reception.login.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class UrlInterceptor implements HandlerInterceptor {

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception e)
			throws Exception {
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView mv)
			throws Exception {
	}

	/**
	 * 拦截器：拦截向后台发送的请求
	 */
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg1) throws Exception {
		// 获取请求路径
		String requestUrl = request.getRequestURI();
		System.out.println(requestUrl);
		// 判断是否放行
		boolean flag = false;
		// 如果请求是登录请求，通过拦截器，进行登录认证
		if (null != requestUrl && requestUrl.contains("login")) {//登录请求放开
			return true;
		}
		if (requestUrl.contains(".app") || requestUrl.contains(".App") || requestUrl.contains("/app")) {//app接口全部放开
			return true;
		} else {
			HttpSession session = request.getSession();
			if (null != session.getAttribute("user")) {//判断是否登录成功
				return true;
			}
			response.sendRedirect(request.getContextPath()+"/views/login/login.html");
		}
		return flag;
	}
}