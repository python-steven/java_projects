package com.atguigu.springmvc.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;


public class MyHandlerExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,Exception ex) {
		
		ModelAndView mv = new ModelAndView();
		if (ex instanceof MaxUploadSizeExceededException) {
			mv.setViewName("hello");
			mv.addObject("msg", "your file size is too larger!!!!");
			
			return mv;
		}
		return null;
		
	}

}
