package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.UserBean;
import com.dao.UserDao;

/**
 * Servlet implementation class ListMemberController
 */
public class ListMemberController extends HttpServlet {

	
	
	@Override
	public void init() throws ServletException {
		
	}
	@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		
		UserDao userDao=new UserDao();
		
		System.out.println("jnknkd");
		ArrayList<UserBean> users =UserDao.getAllMember();
		request.setAttribute("users",users);
		System.out.println(users);
		request.setAttribute("users", users);
		RequestDispatcher rd = null;
		rd=	request.getRequestDispatcher("ListMember.jsp");
		rd.forward(request, response);
		
		
		
		}

	@Override
		public void destroy() {
			
		}
}
