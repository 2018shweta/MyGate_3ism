package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.MemberBean;
import com.dao.MemberDao;


public class ListFamilyMemberController extends HttpServlet {
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget listFamilyMember ");
		
		MemberDao memberDao=new MemberDao();
		MemberBean memberBean=new MemberBean();
		HttpSession session =request.getSession();
		int userid=(Integer)session.getAttribute("userid");
		System.out.println(userid);
		ArrayList<MemberBean> members=memberDao.GetAllMembers(userid);
		
		request.setAttribute("members",members);
		System.out.println(members);
		RequestDispatcher rd = null;
		rd=	request.getRequestDispatcher("ListFamilyMember.jsp");
		rd.forward(request, response);
		
		
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}
}
