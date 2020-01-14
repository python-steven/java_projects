package com.atguigu.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.pojo.Calculate;
import com.atguigu.pojo.Calculator;

public class SpringTest {

	@Test
	public void test1() throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		//当我们被代理对象 没有实现任何接口的时候 底层使用    代理   返回的对象是子类型的所有需要使用  类接收
		Calculate calculate = (Calculate) applicationContext.getBean("calculator");
		calculate.add(10, 10);
		System.out.println("------------------");
		calculate.div(1, 0);
	}
}
