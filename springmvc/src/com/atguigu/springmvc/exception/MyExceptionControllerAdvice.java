package com.atguigu.springmvc.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
/**
 * 优先局部   ----精确优先----全局
 * @author Z15123001
 * 处理异常信息的方法
 * 1.实现处理解析器接口的方法： HandlerExceptionResolver resloverException(ex)                ---无法做到精确匹配
 * 2,xml方式 SimpleMappingExceptionResolver: 在springMvc配置文件中  exceptionMapping中                        ---很难定制和控制
 * 3,@ExceptionHandler 声明一个方法是异常处理 局部异常处理， 作用范围只在当前controller中有效                     		---文件超大扑住不到
 * 4,@ControllerAdvice+@Exceptionhandler：声明一个全局的异常处理方法 							---推荐使用此方法， 方便扩展
 *
 */
@ControllerAdvice
public class MyExceptionControllerAdvice {

	ModelAndView mv = new ModelAndView();
	@ExceptionHandler
	public ModelAndView handlerException1(Exception e) {
		mv.setViewName("hello");
		mv.addObject("msg", "your have error");
		return mv;
	}
	@ExceptionHandler
	public ModelAndView handerException2(RuntimeException ex) {
		mv.setViewName("hello");
		mv.addObject("msg", "run error");
		return mv;
	}
	
}
