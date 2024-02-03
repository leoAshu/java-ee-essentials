package com.leoAshu.spring.springcore.constructorinjection.injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/leoAshu/spring/springcore/constructorinjection/injection/config.xml");
		
		Employee emp = (Employee) ctx.getBean("employee");
		
		System.out.println(emp);
	}

}
