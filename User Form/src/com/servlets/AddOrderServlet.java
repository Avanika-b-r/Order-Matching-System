package com.servlets;

import java.io.IOException;
import java.sql.Time;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.OrderDAO;
import com.dao.OrderDAOImpl;
import com.pojos.Order;


public class AddOrderServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String category = req.getParameter("Buy/Sell");
		int quantity=Integer.parseInt(req.getParameter("Quantity"));
		String type = req.getParameter("type");
		double price=Double.parseDouble(req.getParameter("Price"));		
		String fill=req.getParameter("fill");
		
		OrderDAO dao= new OrderDAOImpl();
		int rows=dao.addOrder(new Order(category_of_order, Quantity, type_of_order, price, fill));
		System.out.println(category_of_order+ ":" +Quantity+ ":" +type_of_order +":" +price+ ":" +fill);
		
		if(rows>0)
		{
			System.out.println("Inserted");
			RequestDispatcher dispatcher=req.getRequestDispatcher("index.jsp");
			dispatcher.forward(req, resp);
		}
		else {
			
			System.out.println("not inserted");
			String message="Sorry cannot place order";
			req.setAttribute("msg", message);
			RequestDispatcher dispatcher=req.getRequestDispatcher("index.jsp");
			dispatcher.forward(req, resp);
		}		
	}
}
