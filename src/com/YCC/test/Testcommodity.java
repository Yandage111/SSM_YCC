package com.YCC.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.YCC.entity.commodity;
import com.YCC.service.CommodityService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:resources/spring.xml")
public class Testcommodity {
	@Autowired
	private CommodityService service;
	
	@Test
	public void queryAll(){
		 
		List<commodity> list = service.queryAll();
		
		for (commodity user : list) {
			System.out.println(user);
		}
		
	}
	@Test
	public void addcommodity(){
		 commodity comm=new commodity();
		 comm.setDescrible("黄金苹果好吃");
		 comm.setName("黄金苹果");
		 comm.setPrice(25);
		 service.addcommodity(comm);
		 
	}
	@Test
	public void deletecommodity()
	{
		service.deletecommodity(4);
		System.out.println("删除成功");
	}
	
	@Test
	public void updatecommodity()
	{
		 commodity comm=new commodity();
		 comm.setId(4);
		 comm.setDescrible("黄金苹果好吃");
		 comm.setName("黄金苹果");
		 comm.setPrice(25);
		 service.updatecommodity(comm);
	}
	
	@Test
	public void findcommodityname()
	{
			List<commodity> comm=service.findcommodityname(null,15,0);
			System.out.println(comm);
	}
	
}




