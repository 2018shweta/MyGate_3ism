package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		Boolean isError=false;
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		if(email==null)
		{
			isError=true;
			request.setAttribute("emailError", "please enter email");
		}
		if(password==null)
		{
			isError=true;
			request.setAttribute("passwordError", "please enter password");
		}
		
		if (isError == true) {
			request.getRequestDispatcher("AddInstruction.jsp").forward(request, response);
		} else {
			// go ahead
			chain.doFilter(request, response);// servlet -- second filter
		}
	}
		
		
		
	

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
