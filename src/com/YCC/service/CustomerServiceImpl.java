package com.YCC.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.YCC.dao.customerDao;
import com.YCC.entity.customer;
@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private customerDao dao;
	
	@Override
	public boolean login(String username, String password) {
		customer user = dao.querycustomerByUsernameAndPassword(username, password);
		
		if(user==null){
			return false;
		}
		
		return true;

		
		
	}

	@Override
	public String regist(customer user) {
		customer queryUser = dao.queryUserByUsername(user.getUsername());
		
		if(queryUser==null){
			
			dao.addcustomer(user);
			return null;
		}else{
			return "您输入的用户名已经存在!";
		}
	}

	@Override
	public customer queryusername(String username) {
		
		customer customer1=dao.queryUserByUsername(username);
		return customer1;
		
	}

	@Override
	public void updatecustomer(String username, Integer prices) {
		
		dao.xiugaiprices(username, prices);
		
	}

	@Override
	public List<customer> qurryall() {
		List<customer> cuss=dao.qurryall();
		return cuss;
	}

	@Override
	public void shanchuyonghu(Integer id) {

		dao.shanchuyonghu(id);
		
	}

	@Override
	public customer queryCustomerById(Integer id) {
		customer ccc=dao.queryCustomerById(id);
		
		return ccc;
	}

	@Override
	public void updateyonghu(customer user) {
		
		dao.updateyonghu(user);
		
	}
	

}
