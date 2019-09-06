package com.pojos;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

import oracle.sql.DATE;

public class Order {
	
	
	private String user_id;
	private int order_id;
	private String category;
	private int quantity;
	private String type;	
	private double price;
	private String fill;
	private Timestamp timestamp;

	@Override
	public String toString() {
		return "Order [user_id=" + user_id + ", order_id=" + order_id + ", category=" + category + ", quantity="
				+ quantity + ", type=" + type + ", price=" + price + ", fill=" + fill + ", timestamp=" + timestamp
				+ "]";
	}

	public Order(String user_id, String category, int quantity, String type, double price, String fill)
	 {
		super();
		this.user_id = user_id;
		this.category = category;
		this.quantity = quantity;
		this.type = type;
		this.price = price;
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

	public String getFill() {
		return fill;
	}

	public void setFill(String fill) {
		this.fill = fill;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

}
