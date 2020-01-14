package com.atguigu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.atguigu.service.TransactionService;

public class SpringTestServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ApplicationContext applicationContext = (ApplicationContext)WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		
		TransactionService transactionService = (TransactionService) applicationContext.getBean("transactionService");
		transactionService.mutiUpdates();
		
	}

}
