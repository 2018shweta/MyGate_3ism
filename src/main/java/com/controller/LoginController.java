package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.UserBean;
import com.dao.UserDao;

public class LoginController extends HttpServlet {
	@Override
	public void init() throws ServletException {
		System.out.println("init()");
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		System.out.println(email);
		System.out.println(password);
		UserDao userDao = new UserDao();
		UserBean user = userDao.login(email, password);
		System.out.println("dopost");
	//	System.out.println(user.getRole());
		RequestDispatcher rd = null;
		Boolean isError=false;
		
		
		
		
		if (user == null ) {
			request.setAttribute("errorMsg", "Invalid credentials");
			rd = request.getRequestDispatcher("Login.jsp");
			System.out.println("error");

		} else {
			
			HttpSession session =request.getSession();
			session.setAttribute("userid", user.getUserid());
			
			//session.setAttribute("gmail",user.getGmail());
			System.out.println("user not null");
			if (user.getRole().equals("member") && user.getApprove()==1) {
				rd = request.getRequestDispatcher("MemberHomePage.jsp");
				System.out.println(" dao login method");
			} else if (user.getRole().equals("admin") ) {
				rd = request.getRequestDispatcher("AdminHomePage.jsp");
			} else if (user.getRole().equals("security") && user.getApprove()==1) {
				rd = request.getRequestDispatcher("SecurityHomePage.jsp");
			} else {
				rd = request.getRequestDispatcher("Login.jsp");
			}
			 
			
			

		}
		
		rd.forward(request, response);
	}
	@Override
	public void destroy() {
		System.out.println("destroy");
	}

}
