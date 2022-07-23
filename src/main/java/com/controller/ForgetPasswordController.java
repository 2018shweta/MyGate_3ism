package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;

/**
 * Servlet implementation class ForgetPasswordController
 */
public class ForgetPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgetPasswordController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email=request.getParameter("email");
		String contactnumber=request.getParameter("contactnumber");
		Boolean isError=false;
		if(email==null || email.trim().length()==0)
		{
			isError=true;
			request.setAttribute("emailError", "please enter email");
		}
		if(contactnumber==null || email.trim().length()==0)
		{
			isError=true;
			request.setAttribute("contactnumberError", "please enter contactnumber");
		}
		if(isError)
		{
			request.getRequestDispatcher("ForgetPassword.jsp").forward(request, response);
		}
		else {
			
			UserDao userDao=new UserDao();
			UserBean userBean=new UserBean();
			Boolean flag=userDao.ForgetPassword(email,contactnumber);
			if(flag)
			{
				request.getRequestDispatcher("ResetPassword.jsp").forward(request, response);	
			}
			else
			{
				request.getRequestDispatcher("ForgetPassword.jsp").forward(request, response);
			}
			
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
