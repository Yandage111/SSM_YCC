package com.YCC.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.YCC.entity.manager;
import com.YCC.service.ManagerService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:resources/spring.xml")
public class TestService {
	
	@Autowired
	private ManagerService service;
	
	
	@Test
	public void test1(){
		
		boolean flag = service.login("天才第一", "123456");
		
		System.out.println(flag);
		
	}
	
	@Test
	public void test2(){
		 
		manager user = new manager("大家好","李四",20,"123456","女");
		
		service.regist(user); 
		
		
	}
	
	
	
	 
}
