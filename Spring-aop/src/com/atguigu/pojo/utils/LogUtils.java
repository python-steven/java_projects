package com.atguigu.pojo.utils;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//加 @Order（1）可以优先执行这个logUtils


@Component
//表示一个切面类@Aspect
@Aspect
public class LogUtils {
	
	@Pointcut(value ="execution(public * com.atguigu.*.Calculator.*(..))")
	public static void pointcut1() {
		
	}
	
	
	
	/**
	 * 表示前置通知
	 *  @Before 表示切入面
	 *  Before(value ="execution(访问权限    返回值类型    包名+类名+方法名)")
	 *  public * com.atguigu.*.Calculator.*(int, *)
	 *  *表示返回任何类型的值     *可以寻找任何包下的    * 任何函数名   *第二个参数任意
	 *  value ="" 表示切入点
	 */
	@Before(value ="pointcut1()")
	public static void logBefore(JoinPoint jp) {
		System.out.println("当前日记是：当前是【"+jp.getSignature().getName()+"】操作，参数是："+Arrays.asList(jp.getArgs()));
	}
	
	@After(value = "pointcut1()")
	public static void logAfter(JoinPoint jp) {
		System.out.println("后置日记是：当前是【"+jp.getSignature().getName()+"】操作，参数是："+Arrays.asList(jp.getArgs()));
	}
	
	@AfterThrowing(value = "pointcut1()",throwing = "e")
	public static void logAfterThrowing(JoinPoint jp,Exception e) {
		System.out.println("当前日记是：当前是【"+jp.getSignature().getName()+"】操作，异常是："+e);
	}
	
	@AfterReturning(value = "pointcut1()",returning = "result")
	public static void logAfterReturning(JoinPoint jp,Object result) {
		System.out.println("返回日记是：当前是【"+jp.getSignature().getName()+"】操作，结果是："+result);
	}

	@Around(value = "pointcut1()")
	public static Object around(ProceedingJoinPoint pjp) throws Throwable {
		Object result = null;
		try {
			System.out.println("环绕的 前置通知");
			result = pjp.proceed();			
		}catch (Exception e) {
			System.out.println("环绕的异常通知");
			throw e;
		}finally {
			System.out.println("环绕的 后置通知");
		}
		System.out.println("环绕的 返回值 通知");
		return result;
	}
	
}










