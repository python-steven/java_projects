package com.atguigu.springmvc.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


public class MyInterceptor implements HandlerInterceptor {

	/**
	 * 前置方法：在handler方法执行之前执行
	 * 作用：身份验证，权限验证
	 */
	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		System.out.println("前置方法：正在执行中。。。。。。。");
		return true;
	}

	/**
	 * 后置方法：在handler方法执行之后执行
	 * 作用：打印日志文件的， 统计业务逻辑的时长
	 */	
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("后置方法：正在执行中。。。。。。。。。");

	}

	/**
	 * 完成方法： 在视图渲染完成之后执行
	 * 作用：处理异常      释放资源
	 */
	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("完成方法:正在执行中。。。。。。。。。");
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
