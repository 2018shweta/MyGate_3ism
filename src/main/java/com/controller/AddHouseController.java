package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.HouseBean;

import com.dao.HouseDao;




/**
 * Servlet implementation class AddHouseController
 */
public class AddHouseController extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		System.out.println("init()");
	}
	@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("dopost()");
		
		
		int houseno=Integer.parseInt(request.getParameter("houseno"));
		int houseflor=Integer.parseInt(request.getParameter("houseflor"));
		String block=request.getParameter("block");
		
		Boolean isError=false;
		if(houseno==0  )
		{isError=true;
			request.setAttribute("housenoError", "please enter houseno");
		}
		if(houseflor==0  )
		{
			isError=true;
			request.setAttribute("houseflorError", "please enter houseflor");
		}
	//RequestDispatcher rd=null;
	if(isError)
	{
		request.getRequestDispatcher("AddHouse.jsp").forward(request, response);
	}
	else {
		
		HouseDao houseDao=new HouseDao();
		HouseBean houseBean=new HouseBean();
			
			houseBean.setHouseno(houseno);
			houseBean.setHouseflor(houseflor);
			houseBean.setBlock(block);
			
			
			HttpSession session = request.getSession();
			int userid =  (Integer) session.getAttribute("userid");
			
			System.out.println(userid);
			
			
			houseDao.AddHouseDetails(houseBean,userid);
			
			
			request.getRequestDispatcher("MemberHomePage.jsp").forward(request, response);
		
		
		
	}
		
	}
	
	@Override
		public void destroy() {
		System.out.println("destroy()");
		}
	
}
