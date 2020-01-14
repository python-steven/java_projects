package com.atguigu.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.atguigu.pojo.Calculate;
import com.atguigu.pojo.Calculator;



@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringTest {
	
	@Autowired
	Calculate calculate;
	@Test
	public void test1() throws Exception {
		calculate.add(10, 10);
		calculate.div(10, 0);
	}
}



//public class SpringTest {
//	
//	@Test
//	public void test1() throws Exception {
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//		//当我们被代理对象 没有实现任何接口的时候 底层使用    代理   返回的对象是子类型的所有需要使用  类接收
//		Calculate calculate = (Calculate) applicationContext.getBean("calculator");
//		calculate.add(10, 10);
//		System.out.println("------------------");
//		calculate.div(1, 0);
//	}
//}
