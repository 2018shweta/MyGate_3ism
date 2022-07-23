package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.HouseBean;
import com.bean.MemberBean;
import com.dao.HouseDao;
import com.dao.MemberDao;


public class AddFamilyMemberController extends HttpServlet {
	@Override
	public void init() throws ServletException {
		System.out.println("Addfamily member init");
	}
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("Addfamily member dopodt()");
	
	String name=request.getParameter("name");
	String contactnumber=request.getParameter("contactnumber");
	int age=Integer.parseInt(request.getParameter("age"));
	String gender=request.getParameter("gender");
    String email=request.getParameter("email");
    
    
    Boolean isError=false;
    if(name==null || name.trim().length()==0)
    {
    	isError=true;
    	request.setAttribute("nameError","pelase enter name");
    }
    
    if(contactnumber==null  || contactnumber.trim().length()==0)
    {
    	isError=true;
    	request.setAttribute("contactnumberError","pelase enter contactnumber");
    }
    if(email==null || email.trim().length()==0)
    {
    	isError=true;
    	request.setAttribute("emailError","pelase enter email");
    }
    if(age==0  )
    {
    	isError=true;
    	request.setAttribute("ageError","pelase enter  valid age");
    }
    
    if(isError)
    {
    	request.getRequestDispatcher("AddFamilyMember.jsp").forward(request, response);
    }
    else {
    	System.out.println("iserror"+isError);
    	MemberDao memberDao=new MemberDao();
    	MemberBean memberBean=new MemberBean();
    	System.out.println(name);
    	memberBean.setName(name);
    	memberBean.setContactnumber(contactnumber);
    	memberBean.setAge(age);
    	memberBean.setGender(gender);
    	memberBean.setEmail(email);
    	HouseDao houseDao =new HouseDao();
    	HouseBean houseBean=new HouseBean();
    	HttpSession session=request.getSession();
    	int userid = (Integer)(session.getAttribute("userid"));
    	memberBean.setHouseid(houseBean.getHouseid());
    	memberBean.setUserid(userid);	
    	//memberBean.setUserid(houseBean.getUserid());
    	System.out.println(userid);
    	memberDao.AddFamilyMember(memberBean);
    	
    	request.getRequestDispatcher("MemberHomePage.jsp").forward(request, response);
    	
    }
}
@Override
public void destroy() {
	System.out.println("Addfamily member destroy()");
}
}
