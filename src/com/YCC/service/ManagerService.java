package com.YCC.service;



import com.YCC.entity.manager;

public interface ManagerService {
	
	public boolean login(String UserName, String password);
	
	public String regist(manager user); 
	
	
	
}
