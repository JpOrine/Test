package com.orine.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminFilter extends HttpServlet implements Filter {
	
	private static final long serialVersionUID = 1L;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;
		if(servletRequest.getSession().getAttribute("currentAdmin") == null){
			String url = servletRequest.getRequestURI();
			//判断获取的路径不为空且不是访问登录页面或执行登录操作时跳转  
			if(url!=null && !url.equals("") && url.indexOf("admin.jsp")<0){
				servletRequest.getRequestDispatcher("../../admin.jsp").forward(servletRequest, servletResponse);
			}
		}else{
			chain.doFilter(request, response);
		}
		
	}
}
