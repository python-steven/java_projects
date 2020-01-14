package com.atgugui.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.atgugui.pojo.Person;
import com.atgugui.pojo.Person1;

public class SpringTest {

	@Test
	public void test1() throws Exception {
		//applicationContext。xml 是Spring的配置文件
		//我们需要先有一个Spring容器（spring IOC容器） 再从容器中获取配置的bean的对象     ApplicationContext接口表示Spring Ioc容器
		//ClassPathXmlApplicationContext表示从Classpath类路径下
//		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		//从文件系统路径中加载指定的xml配置文件生成spring容器
		ConfigurableApplicationContext applicationContext = new FileSystemXmlApplicationContext("config/applicationContext.xml");
		
		Person1 bean = (Person1) applicationContext.getBean("p1");
		System.out.println(bean);
		applicationContext.close();
	}
	
	@Test
	public void test2() throws Exception {
		//applicationContext。xml 是Spring的配置文件下                                  创建Spring容器对象
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		//通过类型获取Spring容器的对象
		/**
		 * 如果是找到一个就直接返回<br/>
		 * 如果是多个的时候会报错
		 * 如果找不到的时候就会报错
		 */
		Person1 bean = (Person1) applicationContext.getBean(Person1.class);//这个一般都是不用的 因为不对应的原因
		System.out.println(bean);
		applicationContext.close();
	}
	
	@Test
	public void test3() throws Exception {
		//applicationContext。xml 是Spring的配置文件下                                  创建Spring容器对象
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		//通过类型获取Spring容器的对象
		/**
		 * 如果是找到一个就直接返回<br/>
		 * 如果是多个的时候会报错
		 * 如果找不到的时候就会报错
		 */
		Person1 bean = (Person1) applicationContext.getBean("p2");
		System.out.println(bean);
		applicationContext.close();
	}
	
	@Test
	public void test4() throws Exception {
		//applicationContext。xml 是Spring的配置文件下                                  创建Spring容器对象
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		//通过类型获取Spring容器的对象
		/**
		 * 如果是找到一个就直接返回<br/>
		 * 如果是多个的时候会报错
		 * 如果找不到的时候就会报错
		 */
		Person1 bean = (Person1) applicationContext.getBean("p3");
		System.out.println(bean);
		applicationContext.close();
	}
	
	@Test
	public void test5() throws Exception {
		//applicationContext。xml 是Spring的配置文件下                                  创建Spring容器对象
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		//通过类型获取Spring容器的对象
		/**
		 * 如果是找到一个就直接返回<br/>
		 * 如果是多个的时候会报错
		 * 如果找不到的时候就会报错
		 */
		Person1 bean = (Person1) applicationContext.getBean("p4");
		System.out.println(bean);
		System.out.println(bean.getName().length());
		applicationContext.close();
	}
	
	@Test
	public void test6() {
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		//ref的测试
		Person bean = (Person) applicationContext.getBean("p8");
		System.out.println(bean);
		applicationContext.close();
	}
	@Test
	public void test7() {
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		//ref的测试
		Person bean = (Person) applicationContext.getBean("p9");
		System.out.println(applicationContext.getBean("car"));
//		System.out.println(applicationContext.getBean("car02"));  这里会报错
		System.out.println(bean.getCar());
		System.out.println(bean.getId());
		applicationContext.close();
	}
	@Test
	public void test8() {
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		//ref的测试
		Person bean = (Person) applicationContext.getBean("p10");
		System.out.println(bean);
//		System.out.println(applicationContext.getBean("car03"));也不能通过xml直接获取内部的额id=car03的bean对象
		applicationContext.close();
	}
	
	@Test
	public void test9() {
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		//ref的测试
		Person bean = (Person) applicationContext.getBean("p11");
		System.out.println(bean);
		applicationContext.close();
	}
	@Test
	public void test10() {
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		//ref的测试
		Person bean = (Person) applicationContext.getBean("p12");
		System.out.println(bean);
		applicationContext.close();
	}
	@Test
	public void test11() {
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		//ref的测试
		Person bean = (Person) applicationContext.getBean("pset");
		System.out.println(bean);
		applicationContext.close();
	}
	@Test
	public void test12() {
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		//获取util list的对象属性值的测试
//		Person bean = (Person) applicationContext.getBean("p13");
		System.out.println(applicationContext.getBean("list01"));
		applicationContext.close();
	}
	@Test
	public void test13() {
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		//获取util list的对象属性值的测试
		Person bean = (Person) applicationContext.getBean("p14");//这里会更改原来的carcar的属性值和name值
		
		System.out.println(bean);
		System.out.println(applicationContext.getBean("carcar"));
		System.out.println(applicationContext.getBean("carr"));
		applicationContext.close();
	}
	@Test
	public void test14() {
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Person bean = (Person) applicationContext.getBean("p15");
		
		System.out.println(bean);
		applicationContext.close();
	}
	@Test
	public void test15() {
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Person bean = (Person) applicationContext.getBean("p16");
		
		System.out.println(bean);
		applicationContext.close();
	}
	@Test
	public void test16() {
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Person bean = (Person) applicationContext.getBean("p17");
		
		System.out.println(bean);
		applicationContext.close();
	}
	
	@Test
	public void test17() {
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Person bean = (Person) applicationContext.getBean("p18");
		
//		System.out.println(applicationContext.getBean("parent"));如果被定义为抽象的就不能实例化
		System.out.println(bean);
		applicationContext.close();
	}
	@Test
	public void test18() {
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Person bean = (Person) applicationContext.getBean("p19");
		System.out.println(bean);
		applicationContext.close();
	}
	
	@Test
	public void test19() {
		ConfigurableApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Person bean = (Person) applicationContext.getBean("p21");
		System.out.println(bean);
		applicationContext.close();
	}
	
	
	
	
	
}
