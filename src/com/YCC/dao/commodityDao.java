package com.YCC.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.YCC.entity.commodity;





public interface commodityDao {
	
	public void addcommodity(commodity comm); 
	
	public commodity querycommodityByUsername(String name);

	public List<commodity> queryAll();
	
	public void deletecommodity(Integer id);
	
//	public commodity querycommodityById(Integer id);
	
	public void updatecommodity(commodity user);
	
	public commodity queryCommodityById(Integer id);
	
	public List<commodity> finduserbycommodityname(@Param("name") String name, @Param("lowprice") int lowprice, @Param("highprice") int highprice);
	
	
}
