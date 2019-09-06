package com.pojos;

import java.sql.Timestamp;

public class Orders {
	private String user_id;
	private int order_id;
	private String category;
	private int quantity;
	private String type;
	private double price;
	private Timestamp timestamp;
	private String fill;
	
	public Orders() {
		super();
	}
	public Orders(String user_id, int order_id, String category, int quantity, String type, double price,
			Timestamp timestamp, String fill) {
		super();
		this.user_id = user_id;
		this.order_id = order_id;
		this.category = category;
		this.quantity = quantity;
		this.type = type;
		this.price = price;
		this.timestamp = timestamp;
		this.fill = fill;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public String getFill() {
		return fill;
	}
	public void setFill(String fill) {
		this.fill = fill;
	}
	
	
	
	
	
}
