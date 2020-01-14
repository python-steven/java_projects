package com.atguigu.usermanage.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.usermanage.pojo.User;

public class UserServiceTest {

    private UserService userService;

    @Before
    public void setUp() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath:spring/applicationContext.xml", "classpath:spring/applicationContext-mybatis.xml",
                "classpath:spring/applicationContext-tx.xml");
        this.userService = context.getBean(UserService.class);
    }

    @Test
    public void testInsertUsers() {
        
        User user1 = new User();
        user1.setUserName("xiaofeng");
        user1.setName("凤姐");
        user1.setAge(20);
        User user2 = new User();
        user2.setUserName("dadafeng");
        user2.setName("大凤");
        user2.setAge(30);
        this.userService.insertUsers(user1, user2);
    }


}
