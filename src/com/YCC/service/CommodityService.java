package com.YCC.service;

import java.util.List;


import com.YCC.entity.commodity;


public interface CommodityService {
	
	public String addcommodity(commodity user); 
	
	public List<commodity> queryAll();
	
	public void deletecommodity(Integer id);
	
	public void updatecommodity(commodity user);
	
	public commodity queryCommodityById(Integer id);
	
	public List<commodity> findcommodityname(String name, int a, int b);
}
