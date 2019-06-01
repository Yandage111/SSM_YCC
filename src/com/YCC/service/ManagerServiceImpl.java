package com.YCC.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.YCC.dao.managerDao;
import com.YCC.entity.manager;

@Service("managerService")
@Transactional
public class ManagerServiceImpl implements ManagerService{


	@Autowired
	private managerDao dao;

	@Override
	public boolean login(String UserName, String password) {
		
		manager user = dao.querymanagerByUsernameAndPassword(UserName, password);
		
		if(user==null){
			return false;
		}
		
		return true;
		
	}

	@Override
	public String regist(manager user) {
		
		manager queryUser = dao.queryUserByUsername(user.getUserName());
		
		if(queryUser==null){
			
			dao.addmanager(user);
			return null;
		}else{
			return "您输入的用户名已经存在!";
		}
		
	}
	
	

	

	
	 
	
	
}
