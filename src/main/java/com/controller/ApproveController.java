package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;

/**
 * Servlet implementation class ApproveController
 */
public class ApproveController extends HttpServlet {
	@Override
	public void init() throws ServletException {
		System.out.println("init()");
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(" approvController dopost()");
		

		UserDao userdao = new UserDao();
		
		int userid=Integer.parseInt(request.getParameter("userid"));		
		int records = userdao.approve(userid);
		RequestDispatcher rd = null;
		if (records == 1) {
			request.setAttribute("message", "Successfully Disable");
			
			rd = request.getRequestDispatcher("ListMemberController");
		} else {
			request.setAttribute("message", "SomeThing went Wrong");
			
			rd = request.getRequestDispatcher("ListMemberController");
		}
		rd.forward(request, response);
	}
		
		
	
	
	@Override
	public void destroy() {
		System.out.println("destroy()");
	}
	
	

}
