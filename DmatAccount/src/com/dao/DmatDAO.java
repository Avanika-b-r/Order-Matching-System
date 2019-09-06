package com.dao;

import java.util.List;

import com.pojos.Orders;

public interface DmatDAO {


	//List<> getAllTransactions(String userid);
	List<Orders> getAllOrders(String userid);
	boolean cancelOrder(int order_id);
	
	
}
