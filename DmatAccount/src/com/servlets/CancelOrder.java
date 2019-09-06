package com.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DmatDAO;
import com.dao.DmatDAOImpl;
import com.dao.TransactionDAO;
import com.dao.TransactionDAOImpl;
import com.pojos.Orders;
import com.pojos.Transaction;

/**
 * Servlet implementation class CancelOrder
 */
@WebServlet("/cancelOrder")
public class CancelOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		DmatDAO dao= new DmatDAOImpl();
		System.out.println(request.getParameter("id"));
		dao.cancelOrder(Integer.parseInt(request.getParameter("id")));
		
		TransactionDAO tDao = new TransactionDAOImpl();
		List<Orders> list = new ArrayList<Orders>();
		list = dao.getAllOrders("");
		request.setAttribute("getOrders", list);
		List<Transaction> list1 = new ArrayList<Transaction>();
		list1 = tDao.getAllTransactions("");
		request.setAttribute("getTrans", list1);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("display.jsp");
		dispatcher.forward(request, response);
		

	}

}
