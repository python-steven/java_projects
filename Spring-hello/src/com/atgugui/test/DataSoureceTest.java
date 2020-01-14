package com.atgugui.test;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DataSoureceTest {

	@Test
	public void test1() throws Exception {
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		DataSource dataSource = (DataSource) applicationContext.getBean("dataSource");
		System.out.println(dataSource.getConnection());
		
		
		
		applicationContext.close();
		
	}
}
