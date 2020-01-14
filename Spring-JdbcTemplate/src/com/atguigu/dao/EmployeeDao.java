package com.atguigu.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.atguigu.pojo.Employee;

//@Repository
//public class EmployeeDao{
//	
//	@Autowired
//	JdbcTemplate jdbcTemplate;
//
////	@Autowired
////	public void initJdbcTemplate(DataSource dataSource) {
////		setDataSource(dataSource);
////	}
//	
//	public int saveEmployee(Employee employee) {
//		return jdbcTemplate.update("insert into employee(`name`,`salary`) values(?,?)", employee.getName(),
//				employee.getSalary());
//	}
//	
//}
@Repository
public class EmployeeDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public int saveEmployee(Employee employee) {
		String sql = "insert into employee(`name`,`salary`) values(?,?)";
		return jdbcTemplate.update(sql, employee.getName(), employee.getSalary());
	}
}
