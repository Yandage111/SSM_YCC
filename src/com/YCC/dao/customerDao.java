package com.YCC.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.YCC.entity.customer;

public interface customerDao {
	
	public customer querycustomerByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
	
	public void addcustomer(customer user); 
	
	public customer queryUserByUsername(String username);
	
	public void xiugaiprices(@Param("username") String username, @Param("prices") Integer prices);
	
	public List<customer> qurryall();
	
	public void shanchuyonghu(@Param("id") Integer id);
	
	public customer queryCustomerById(Integer id);
	
	public void updateyonghu(customer user);
	
	
}
