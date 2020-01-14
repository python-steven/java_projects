package com.atgugui.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.atgugui.pojo.Person;

public class MyBeanProcessor implements BeanPostProcessor {

	/**
	 * 初始化方法之后条用
	 */
	@Override
	public Object postProcessAfterInitialization(Object arg0, String arg1) throws BeansException {
		System.out.println("init ways after "+arg0+"   "+arg1);
		if("p21".equals(arg1)) {
			
			Person person = (Person) arg0;
			person.setName("这是我给的值");
		}
		
		return arg0;
	}

	/**
	 * 初始化之前调用
	 */
	@Override
	public Object postProcessBeforeInitialization(Object arg0, String arg1) throws BeansException {
		System.out.println("init ways before "+arg0+"   "+arg1);
		return arg0;
	}

}
