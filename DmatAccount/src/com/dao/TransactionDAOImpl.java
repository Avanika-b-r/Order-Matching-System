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
import com.pojos.Transaction;



public class TransactionDAOImpl implements TransactionDAO{

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
	public int addTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		int transaction_placed =0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("driver loaded successfully");
			
			System.out.println("Connection obtained");
					
			String INSERT_TRANSACTION="Insert into TRANSACTION values(?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps=openConnection().prepareStatement(INSERT_TRANSACTION);
		
			Timestamp timestamp= new Timestamp(System.currentTimeMillis());
			
			ps.setInt(1, transaction.getTransaction_id());
			ps.setInt(2, transaction.getBuy_order_id());
			ps.setInt(3, transaction.getSell_order_id());
			ps.setString(4, transaction.getBuyer_user_id());
			ps.setString(5, transaction.getSeller_user_id());
			ps.setInt(6, transaction.getQuantity());
			ps.setInt(7, transaction.getISIN());
			ps.setTimestamp(8,timestamp);
			ps.setDouble(9, transaction.getPrice());
			
			transaction_placed=ps.executeUpdate();
			System.out.println("Transaction: " +transaction_placed);
		}catch (ClassNotFoundException | SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return transaction_placed;
	}
	
	@Override
	public List<Transaction> getAllTransactions(String userid) {
		// TODO Auto-generated method stub
		
		List<Transaction> listTrans = new ArrayList<Transaction>();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver loaded successfully");
			
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","abcd123");
			System.out.println("connection obtained");
			
			String find_all = "select * from transaction";
		
			
			Statement st = conn.createStatement();
			ResultSet set = st.executeQuery(find_all);
		
			while(set.next())
			{
				int trans_id = set.getInt("transaction_id");
				int buy_id = set.getInt("buy_order_id");
				int sell_id = set.getInt("sell_order_id");
				String buy_uid = set.getString("buyer_user_id");
				String sell_uid = set.getString("seller_user_id");
				int quant = set.getInt("quantity");
				int isin = set.getInt("isin");
				Timestamp time = set.getTimestamp("Timestamp");
				double price = set.getDouble("price");
				Transaction tran = new Transaction(trans_id,buy_id, sell_id, buy_uid, sell_uid, quant, isin, time, price);
				listTrans.add(tran);
				
			}
			System.out.println("list size:"+listTrans.size());
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listTrans;
		
	}
}
