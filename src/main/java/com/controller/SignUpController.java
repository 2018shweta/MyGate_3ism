package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.UserBean;
import com.dao.UserDao;

public class SignUpController extends HttpServlet {
	@Override
	public void init() throws ServletException {
		System.out.println("init()");
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost()");
		
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String gender=request.getParameter("gender");
		String role=request.getParameter("role");
		String  approve=request.getParameter("approve");
		String Contactnumber=request.getParameter("contactnumber");
		
		
		System.out.println("Firstname:"+firstname);
		System.out.println("email"+email);
		System.out.println("password"+password);
		boolean isError=false;
		if (firstname == null || firstname.trim().length() == 0) {
			isError = true;
			request.setAttribute("firstnameError", "<font color='red'>Please Enter FirstName</font>");
		} else {
			request.setAttribute("firstnameValue", firstname);
		}

		if (email == null || email.trim().length() == 0) {
			isError = true;
			request.setAttribute("emailError", "Please Enter Email");
		} else {
			request.setAttribute("emailValue", email);
		}
		
		
		
		if (password == null) {
			isError = true;
			request.setAttribute("passwordError", "Please Select Gender");
		} else {
			request.setAttribute("passwordValue", gender);
		}
		

		if (gender == null) {
			isError = true;
			request.setAttribute("genderError", "Please Select Gender");
		} else {
			request.setAttribute("genderValue", gender);
		}
		RequestDispatcher rd = null;
		if (isError == true) {
			// goback
			rd = request.getRequestDispatcher("SignUp.jsp");
		}else {
			
			UserBean userBean=new UserBean();
			
			userBean.setFirstname(firstname);
			userBean.setLastname(lastname);
			userBean.setEmail(email);
			userBean.setPassword(password);
			userBean.setGender(gender);
			userBean.setContactnumber(Contactnumber);
			userBean.setRole("member");
			userBean.setApprove(0);
			
			UserDao userDao=new UserDao();
			
			userDao.insertUser(userBean);
			request.setAttribute("msg", "Signup done...");
			
			
			
			rd=request.getRequestDispatcher("Login.jsp");
			
		}
		rd.forward(request, response);
		
		// goahead
		// goto home.jsp
		
	}
@Override
public void destroy() {
	System.out.println("destroy()");
}
}
