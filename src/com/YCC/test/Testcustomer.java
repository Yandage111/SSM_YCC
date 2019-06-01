package com.YCC.test;



import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.YCC.entity.customer;
import com.YCC.service.CustomerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:resources/spring.xml")
public class Testcustomer {
	@Autowired
	private CustomerService service;
	

	@Test
	public void test1(){
		
		boolean flag = service.login("张三", "123456");
		
		System.out.println(flag);
		
	}
	
	@Test
	public void test2(){
		 
		customer user = new customer();
		user.setPassword("123456");
		user.setPrices(80);
		user.setUsername("李四");
		service.regist(user); 
		
		
	}
	@Test
	public void test3()
	{
		service.updatecustomer("张三", 100);
	}
	@Test
	public void test4()
	{
		List<customer> sss=service.qurryall();
		System.out.println(sss);
	}
	@Test
	public void test5()
	{
		service.shanchuyonghu(5);
		
	}
	@Test
	public void test6()
	{
		customer sss=service.queryCustomerById(4);
		System.out.println(sss);
		
	}
}
