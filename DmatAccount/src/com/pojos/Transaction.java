package com.pojos;

import java.sql.Timestamp;


public class Transaction {

	private  int transaction_id;
	private int  buy_order_id;
	private int sell_order_id;
	private String  buyer_user_id;
	private String seller_user_id;
	public int getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}
	private int quantity;
	private int ISIN;
	private Timestamp timestamp;
	private double price;
	
	public int getBuy_order_id() {
		return buy_order_id;
	}
	public void setBuy_order_id(int buy_order_id) {
		this.buy_order_id = buy_order_id;
	}
	public int getSell_order_id() {
		return sell_order_id;
	}
	public void setSell_order_id(int sell_order_id) {
		this.sell_order_id = sell_order_id;
	}
	public String getBuyer_user_id() {
		return buyer_user_id;
	}
	public void setBuyer_user_id(String buyer_user_id) {
		this.buyer_user_id = buyer_user_id;
	}
	public String getSeller_user_id() {
		return seller_user_id;
	}
	public void setSeller_user_id(String seller_user_id) {
		this.seller_user_id = seller_user_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getISIN() {
		return ISIN;
	}
	public void setISIN(int iSIN) {
		ISIN = iSIN;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Transaction(int trans,int buy_order_id, int sell_order_id, String buyer_user_id, String seller_user_id, int quantity,
			int iSIN, Timestamp timestamp, double price) {
		super();
		transaction_id=trans;
		this.buy_order_id = buy_order_id;
		this.sell_order_id = sell_order_id;
		this.buyer_user_id = buyer_user_id;
		this.seller_user_id = seller_user_id;
		this.quantity = quantity;
		ISIN = iSIN;
		this.timestamp = timestamp;
		this.price = price;
	}
	

//
//	@Override
//	public String toString() {
//		return "Transaction [transaction_id=" + transaction_id + ", Price=" +
//				price + ", Quantity=" + quantity + ",   Timestamp=" + timestamp
//				+ "buyer_order_id="+buy_order_id+"seller_order_id="+sell_order_id+
//				 "buyer_user_id="+buyer_user_id+"seller_user_id="+seller_user_id+
//				"ISIN="+ISIN+ "]";
//	}
//
//	public Transaction(int trans,int buy_order_id, int sell_order_id, String buyer_user_id, String seller_user_id, int quantity,
//			int iSIN, Timestamp timestamp, double price) {
//		super();
//		transaction_id= trans;
//		this.buy_order_id = buy_order_id;
//		this.sell_order_id = sell_order_id;
//		this.buyer_user_id = buyer_user_id;
//		this.seller_user_id = seller_user_id;
//		this.quantity = quantity;
//		ISIN = iSIN;
//		this.timestamp = timestamp;
//		this.price = price;
//	}
//	public static int getTransaction_id() {
//		return transaction_id;
//	}
//	public static void setTransaction_id(int transaction_id) {
//		Transaction.transaction_id = transaction_id;
//	}
//	public int getBuy_order_id() {
//		return buy_order_id;
//	}
//	public void setBuy_order_id(int buy_order_id) {
//		this.buy_order_id = buy_order_id;
//	}
//	public int getSell_order_id() {
//		return sell_order_id;
//	}
//	public void setSell_order_id(int sell_order_id) {
//		this.sell_order_id = sell_order_id;
//	}
//	public String getBuyer_user_id() {
//		return buyer_user_id;
//	}
//	public void setBuyer_user_id(String buyer_user_id) {
//		this.buyer_user_id = buyer_user_id;
//	}
//	public String getSeller_user_id() {
//		return seller_user_id;
//	}
//	public void setSeller_user_id(String seller_user_id) {
//		this.seller_user_id = seller_user_id;
//	}
//	public int getQuantity() {
//		return quantity;
//	}
//	public void setQuantity(int quantity) {
//		this.quantity = quantity;
//	}
//	public int getISIN() {
//		return ISIN;
//	}
//	public void setISIN(int iSIN) {
//		ISIN = iSIN;
//	}
//	public Timestamp getTimestamp() {
//		return timestamp;
//	}
//	public void setTimestamp(Timestamp timestamp) {
//		this.timestamp = timestamp;
//	}
//	public double getPrice() {
//		return price;
//	}
//	public void setPrice(double price) {
//		this.price = price;
//	}	
	

}
