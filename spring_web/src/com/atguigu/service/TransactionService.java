package com.atguigu.service;

import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.atguigu.dao.BookDao;
import com.atguigu.dao.UserDao;

@Service
public class TransactionService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BookDao bookDao;
	
	@Transactional
	public void multiUpdate() throws FileNotFoundException {
		userDao.updateUser();
		bookDao.updateBook();
		
	}
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BookService bookService;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void mutiUpdates() {
		
		userService.updateUser();
		
		bookService.updateBook();
	}
	
	
	
	
	
	
	
	
	
	
}
/*
 * 默认情况下时      会回滚数据， 意思就是不会更改数据表  只要当中有错误就不不会去更改数据
 * @Transactional 
 * 
 * 表示不回滚数据   表示到错误行之后都不执行数据的更改数据
 * @Transactional(noRollbackFor = ArithmeticException.class)
 * 
 * 默认值是false 表示允许修改数据
 * @Transactional(readOnly = false) 如果是true 表示只能读数据
 * 
 * 表示超过三秒就超时异常
 *  @Transactional(timeout = 3)
 * 
 * 表示的是事物是全部加在事物提交当中， 如果有异常的话就会回滚数据， 不会更改数据表的数据
 * Propagation.REQUIRED
 * 
 * 
 * 表示事物添加的在里面当中， 挂起当前事物    开启新事物的执行 之后再恢复当前事物的运行
 * 
 * Propagation.NEW
 * */

