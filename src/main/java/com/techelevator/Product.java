package com.techelevator;
public class Product {
	
	private String slotNum;
	private double price;
	private String name;
	private int quantity;
	
	public Product(String slotNum, double price, String name, int quantity) {
		this.slotNum = slotNum;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public String getSlotNum() {
		return slotNum;
	}
	
	public double getPrice() {
		return price;
	}
	
	public String getName() {
		return name;
	}

}
