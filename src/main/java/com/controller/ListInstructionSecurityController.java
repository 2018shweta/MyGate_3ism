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

/**
 * Servlet implementation class ListInstructionSecurityController
 */
public class ListInstructionSecurityController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListInstructionSecurityController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		InstructionDao instructionDao=new InstructionDao();
		InstructionBean instructionBean=new InstructionBean();
		HttpSession session=request.getSession();
		int userid=(Integer)session.getAttribute("userid");
		
	ArrayList<InstructionBean> instructions	=instructionDao.AllInstructionListForSecurity();
	request.setAttribute("instructions",instructions);
	System.out.println(instructions);
	RequestDispatcher rd = null;
	rd=	request.getRequestDispatcher("ListInstructionForSecurity.jsp");
	rd.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
