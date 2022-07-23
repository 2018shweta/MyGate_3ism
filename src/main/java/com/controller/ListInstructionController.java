package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.InstructionBean;
import com.dao.InstructionDao;


public class ListInstructionController extends HttpServlet {
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		InstructionDao instructionDao=new InstructionDao();
		InstructionBean instructionBean=new InstructionBean();
		HttpSession session=request.getSession();
		int userid=(Integer)session.getAttribute("userid");
		
	ArrayList<InstructionBean> instructions	=instructionDao.AllInstructionList(userid);
	request.setAttribute("instructions",instructions);
	System.out.println(instructions);
	RequestDispatcher rd = null;
	rd=	request.getRequestDispatcher("ListInstruction.jsp");
	rd.forward(request, response);
	
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

}
