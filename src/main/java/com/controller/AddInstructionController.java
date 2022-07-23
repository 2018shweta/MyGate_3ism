package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.InstructionBean;
import com.dao.InstructionDao;


public class AddInstructionController extends HttpServlet {
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String description=request.getParameter("description");
		String type=request.getParameter("type");
		int allow=Integer.parseInt(request.getParameter("allow"));
	
		Boolean isError=false;
		if(name==null  || name.trim().length()==0)
		{
			isError=true;
			request.setAttribute("nameError", "please enter name");
		}
		if(description==null  || description.trim().length()==0)
		{
			isError=true;
			request.setAttribute("descriptionError", "please enter name");
		}
		if(type==null  || type.trim().length()==0)
		{
			isError=true;
			request.setAttribute("typeError", "please enter name");
		}
		
		
		if(isError)
		{
			request.getRequestDispatcher("AddInstruction.jsp").forward(request, response);
		}
		else
		{
			
			
			InstructionDao instructionDao=new InstructionDao();
			InstructionBean instructionBean=new InstructionBean();
			
			
			instructionBean.setName(name);
			instructionBean.setDescription(description);
			instructionBean.setType(type);
			instructionBean.setAllow(allow);
			HttpSession session=request.getSession();
			int userid=(Integer)session.getAttribute("userid");
			
			instructionDao.AddInstruction(userid ,instructionBean);
			request.getRequestDispatcher("MemberHomePage.jsp").forward(request, response);
		}
		
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

}
