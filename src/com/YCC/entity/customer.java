package com.YCC.entity;

public class customer {
	private int id;
	private String username;
	private String password;
	private int prices;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getPrices() {
		return prices;
	}
	public void setPrices(int prices) {
		this.prices = prices;
	}
	public customer(int id, String username, String password, int prices) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.prices = prices;
	}
	public customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "customer [id=" + id + ", username=" + username + ", password="
				+ password + ", prices=" + prices + "]";
	}
	
	
	
}
