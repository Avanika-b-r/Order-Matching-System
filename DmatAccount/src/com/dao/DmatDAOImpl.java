package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.pojos.Orders;

public class DmatDAOImpl implements DmatDAO {



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
	public List<Orders> getAllOrders(String userid) {
		// TODO Auto-generated method stub
		
		List<Orders> listOrders = new ArrayList<Orders>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver loaded successfully");
			
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","abcd123");
			System.out.println("connection obtained");
			
			String find_all = "select * from orders";
		
			
			Statement st = conn.createStatement();
			ResultSet set = st.executeQuery(find_all);
		
			while(set.next())
			{
				String user_id = set.getString("user_id");
				System.out.println(user_id);
				int id = set.getInt("order_id");
				String category = set.getString("category");
				int quantity = set.getInt("quantity");
				String order_type = set.getString("type");
				double price = set.getDouble("price");
				Timestamp date_time = set.getTimestamp("timestamp");
				String all_none = set.getString("fill");
				Orders orders = new Orders(user_id,id,category,quantity,order_type,price,date_time, all_none);
				listOrders.add(orders);
			}
			System.out.println("list size:"+listOrders.size());
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listOrders;
		
	}

	
	@Override
	public boolean cancelOrder(int order_id) {
		// TODO Auto-generated method stub
		boolean orders_cancelled=false;
		String CANCEL_ORDER="Delete from orders where order_id=?";
		try
		{
			PreparedStatement ps= openConnection().prepareStatement(CANCEL_ORDER);
			ps.setInt(1,order_id);
			
			int rows=ps.executeUpdate();
			if(rows>0) {
				orders_cancelled=true;
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
		return orders_cancelled;
	}
}
