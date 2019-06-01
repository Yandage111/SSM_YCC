package com.YCC.service;

import java.util.List;

import com.YCC.entity.customer;

public interface CustomerService {
	
	public boolean login(String username, String password);
	
	public String regist(customer user); 
	
	public customer queryusername(String username);
	
	public void updatecustomer(String username, Integer prices);
	
	public List<customer> qurryall();
	
	public void shanchuyonghu(Integer id);
	
	public customer queryCustomerById(Integer id);
	
	public void updateyonghu(customer user);
	
}
