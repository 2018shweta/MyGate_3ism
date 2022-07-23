package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutController
 */
public class LogoutController extends HttpServlet {
	
@Override
public void init() throws ServletException {
	System.out.println("init()");
}
	
@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println(" logout init()");
	
	
	HttpSession session = request.getSession();
	session.invalidate();
	response.sendRedirect("Login.jsp");
	
	}	
@Override
	public void destroy() {
	System.out.println("destroy()");
	}
}
