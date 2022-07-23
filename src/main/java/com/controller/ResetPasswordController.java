package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;

/**
 * Servlet implementation class ResetPasswordController
 */
public class ResetPasswordController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String newpassword = request.getParameter("newpassword");
		String confirmpassword = request.getParameter("confirmpassword");
		String email = request.getParameter("email");
		Boolean isError = false;
		if (email == null || email.trim().length() == 0) {
			isError = true;
			request.setAttribute("emailError", "please enter email");
		}
		 if (newpassword == null || newpassword.trim().length() == 0) {
			isError = true;
			request.setAttribute("newpasswordError", "please enter new password");

		}
		 if (confirmpassword == null || confirmpassword.trim().length() == 0) {
			isError = true;
			request.setAttribute("confirmpasswordError", "please enter confirm password");
		}

		UserDao userDao = new UserDao();
		if (newpassword.equals(confirmpassword)!=true) {
			System.out.println("zxcvb");
			isError = true;
		}
		if (isError) {
			System.out.println("asdfg");
			request.getRequestDispatcher("ResetPassword.jsp").forward(request, response);
			request.setAttribute("msg", " please enter newpassword and confirmpassword same!!");
		} else {
			System.out.println("qwer");
			Boolean up1 = userDao.ResetPassword(email, newpassword);
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
	}

	

}
