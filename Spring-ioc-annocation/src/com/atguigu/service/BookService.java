package com.atguigu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
/**
 * 
 * @Service表示
 *  <bean id="bookService" class="com.atguigu.service.BookService" />
 *
 */

import com.atguigu.dao.BookDao;
@Service
public class BookService {

	/**
	 * @Autowired实现自动注入  
	 * 1.先按类型查找并注入
	 * 2.如果找到多个的话   就会按照属性名作为id继续查找并注入
	 * 3.如果没有找到的话，就会报错
	 * @Qualifier("bookDao") 优先选择bookDao去使用
	 */
	@Autowired(required =false)
	@Qualifier("bookDao1")
	private BookDao bookDaoExt;

	@Override
	public String toString() {
		return "BookService [bookDao=" + bookDaoExt + "]";
	}
	/**
	 * @Autowired 放在方法上面，那么此方法在对象创建之后调用
	 *     1，先按照类型查找参数并调用方法传递
	 *     2.如果找到多个的话， 就会按照参数名做为id继续查找并注入
	 *     3.如果如果没有找到会报错
	 *     @Autowired(required =false) 允许调用但不报错
	 */
	
	@Autowired(required =false)
	public void say(@Qualifier("bookDaoExt")BookDao bookDao) {
		
		System.out.println("steven 该怎么办"+bookDao);
	}
	
}
