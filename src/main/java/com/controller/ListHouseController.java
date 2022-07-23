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

public class ListHouseController extends HttpServlet {
	

	@Override
	public void init() throws ServletException {
		
		System.out.println("init()");
		
		
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget()");
		
		HouseDao houseDao=new HouseDao();
		HouseBean houseBean=new HouseBean();
		
		HttpSession session =request.getSession();
		int userid=(Integer)session.getAttribute("userid");
		ArrayList<HouseBean> houses=houseDao.ListHousedetails(userid);
		
		request.setAttribute("houses",houses);
		System.out.println(houses);
		RequestDispatcher rd = null;
		rd=	request.getRequestDispatcher("ListHouse.jsp");
		rd.forward(request, response);
		
		
		
		
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy()");
	}
	
	
	
	
	
	
	
}
