package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.pojos.Order;

public class OrderDAOImpl implements OrderDAO {

	private Connection openConnection()
	{
		Connection connection=null;
		try {
			connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "abcd123");
		} catch(SQLException e)
		{
			e.printStackTrace();
		}
		return connection;
	}
	
	@Override
	public int addOrder(Order order) {
		// TODO Auto-generated method stub
		int orders_placed =0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver loaded successfully");
			
			System.out.println("Connection obtained");
					
			String INSERT_ORDER="Insert into orders values(?,?,?,?,?,?,?,?)";
			PreparedStatement ps=openConnection().prepareStatement(INSERT_ORDER);
		
			
		    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		    ps.setString(1, order.getUser_id());
			ps.setInt(2, order.getOrder_id());
			ps.setString(3, order.getCategory());
			ps.setInt(4, order.getQuantity());
			ps.setString(5, order.getType());
			ps.setDouble(6, order.getPrice());
			ps.setString(7, order.getFill());
			ps.setTimestamp(8, timestamp);
			
			orders_placed=ps.executeUpdate();
			System.out.println("Orders: " +orders_placed);
		}catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return orders_placed;
	}
	}
