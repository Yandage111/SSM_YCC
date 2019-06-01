package com.YCC.dao;

import org.apache.ibatis.annotations.Param;

import com.YCC.entity.manager;

public interface managerDao {
	
	public manager querymanagerByUsernameAndPassword(@Param("UserName") String UserName, @Param("password") String password);
	
	public void addmanager(manager user); 
	
	public manager queryUserByUsername(String UserName);

	
}
