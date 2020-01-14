package com.atguigu.dao;


import org.springframework.stereotype.Repository;
/**
 * 
 * @Repository 注解表示
 * <bean id="bookDao" class="com.atguigu.dao.BookDao" />
 *@Repository("id")  意思是换掉了bean'的id
 *在使用的时候就是获取id 而不是bookDao
 *
 */
@Repository
public class BookDaoExt extends BookDao {


	
}
