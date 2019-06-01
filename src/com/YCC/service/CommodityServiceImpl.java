package com.YCC.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.YCC.dao.commodityDao;
import com.YCC.entity.commodity;

@Service("commodityService")
@Transactional
public class CommodityServiceImpl implements CommodityService{

	
	@Autowired
	private commodityDao dao;
	
	@Override
	public List<commodity> queryAll() {
		
		List<commodity> commoditys = dao.queryAll();
		return commoditys;
	
	}

	@Override
	public void deletecommodity(Integer id) {
		
		dao.deletecommodity(id);
	}

	@Override
	public void updatecommodity(commodity user) {
		
		dao.updatecommodity(user);
		
	}

	@Override
	public String addcommodity(commodity user) {

		commodity queryUser = dao.querycommodityByUsername(user.getName());
		
		if(queryUser==null){
			
			dao.addcommodity(user);
			return null;
		}else{
			 return "您输入的用户名已经存在!";
		}
		
	}
	
	@Override
	public commodity queryCommodityById(Integer id) {
		commodity comm=dao.queryCommodityById(id);
		return comm;
	}

	@Override
	public List<commodity> findcommodityname(String name,int a,int b) {
		
		List<commodity> comm=dao.finduserbycommodityname(name,a,b);
		return comm;
		
	}
	
}
