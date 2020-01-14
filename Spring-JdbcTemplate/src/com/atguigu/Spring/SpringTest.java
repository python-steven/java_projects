package com.atguigu.Spring;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.atguigu.dao.EmployeeDao;
import com.atguigu.pojo.Employee;



@ContextConfiguration(locations = "classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringTest {

	@Autowired
	DataSource dataSource;

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	Employee employeeDao;

	@Test
	public void testDataSource() throws Exception {
		System.out.println(dataSource.getConnection());
		System.out.println(jdbcTemplate);
	}

	// 将id=5的记录工资1300.00
	@Test
	public void test2() throws Exception {
		String sqlString="update employee set salary=? where id= ?";
		jdbcTemplate.update(sqlString,new BigDecimal(1300),5);
	}
	//实现批量插入数据
	@Test
	public void test3() throws Exception {
		String sqlString="insert employee(`name`,`salary`) values(?,?)";
		
		List<Object[]> batchArgs =new ArrayList<Object[]>();
		batchArgs.add(new Object[] {"曹操",new BigDecimal(10000)});
		batchArgs.add(new Object[] {"刘备",new BigDecimal(10000)});
		batchArgs.add(new Object[] {"孙权",new BigDecimal(10000)});
		batchArgs.add(new Object[] {"诸葛亮",new BigDecimal(10000)});
		batchArgs.add(new Object[] {"周瑜",new BigDecimal(10000)});
		
		jdbcTemplate.batchUpdate(sqlString, batchArgs);
		
	}
	//查询id=5 封装为一个java对象返回
	@Test
	public void test4() throws Exception {
		/**
		 * RowMapper 接口，可以封装到类里面bean对象
		 */
		String sqlString="select id,name,salary from employee where id=?";
		Employee employee = jdbcTemplate.queryForObject(sqlString, new BeanPropertyRowMapper<Employee>(Employee.class), 5);
		
		System.out.println(employee);
	}
	//范围查询数据
	@Test
	public void test5() throws Exception {
		String sqlString="select id,name,salary from employee where salary >= ?";
		
		jdbcTemplate.query(sqlString, new BeanPropertyRowMapper<Employee>(Employee.class), new BigDecimal(400))
		.forEach(System.out::println);	
		
	}
	//查询最大的工资
	@Test
	public void test6() throws Exception {
		String sqlString="select max(salary) from employee";
		
		BigDecimal mas = jdbcTemplate.queryForObject(sqlString, BigDecimal.class);
		System.out.println(mas);
		
	}
	// 实验7：使用带有具名参数的SQL语句插入一条员工记录，并以Map形式传入参数值
	// <!-- namedParameterJdbcTemplate -->
	@Test
	public void test7() throws Exception {
		/**
		 * :name 相当于 ? 占位符，name就是这个参数的名称
		 */
		String sql = "insert into employee(`name`,`salary`) values(:name,:salary)";

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("name", "我是命名（具名）参数的");
		paramMap.put("salary", new BigDecimal(1234));

		namedParameterJdbcTemplate.update(sql, paramMap);

	}
	@Test
	public void test8() throws Exception {
		/**
		 * :name 相当于 ? 占位符，name就是这个参数的名称
		 */
		String sql = "insert into employee(`name`,`salary`) values(:name,:salary)";
		Employee employee = new Employee(null,"对象",new BigDecimal(600));
		
		namedParameterJdbcTemplate.update(sql, new BeanPropertySqlParameterSource(employee));
		
	}
	
	// 实验9：创建Dao，自动装配JdbcTemplate对象
	@Test
	public void test9() throws Exception {
		Employee employee = new Employee(null, "我是Dao插入的", new BigDecimal(1234));
		
//		employeeDao.saveEmployee(employee);
		
	}
	// 实验9：创建Dao，自动装配JdbcTemplate对象
	@Test
	public void test10() throws Exception {
		Employee employee = new Employee(null, "我是Dao插入的", new BigDecimal(1234));
		
	}

	
	
	
}





















