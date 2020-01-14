package com.atguigu.springmvc.pojo;

import java.util.Arrays;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class User {

	private String userName;
	private Integer age;
	private Double salary;
	private Boolean isMarry;
	private String[] interests;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date birthday;
	@JsonIgnore
	private String Password;
	
	
	
	
	
	
	
	
	
	
	public User() {
		super();
	}
	public User(String userName, Integer age, Double salary, Boolean isMarry, String[] interests, Date birthday,
			String password) {
		super();
		this.userName = userName;
		this.age = age;
		this.salary = salary;
		this.isMarry = isMarry;
		this.interests = interests;
		this.birthday = birthday;
		Password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Boolean getIsMarry() {
		return isMarry;
	}
	public void setIsMarry(Boolean isMarry) {
		this.isMarry = isMarry;
	}
	public String[] getInterests() {
		return interests;
	}
	public void setInterests(String[] interests) {
		this.interests = interests;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	@Override
	public String toString() {
		return "User [userName=" + userName + ", age=" + age + ", salary=" + salary + ", isMarry=" + isMarry
				+ ", interests=" + Arrays.toString(interests) + ", birthday=" + birthday + ", Password=" + Password
				+ "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
