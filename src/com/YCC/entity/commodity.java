package com.YCC.entity;

public class commodity {
	private Integer id;
	private String name;
	private Integer price;
	private String describle;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getDescrible() {
		return describle;
	}
	public void setDescrible(String describle) {
		this.describle = describle;
	}
	@Override
	public String toString() {
		return "commodity [id=" + id + ", name=" + name + ", price=" + price
				+ ", describle=" + describle + "]";
	}
	public commodity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public commodity(Integer id, String name, Integer price, String describle) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.describle = describle;
	}
	
	
	
}
