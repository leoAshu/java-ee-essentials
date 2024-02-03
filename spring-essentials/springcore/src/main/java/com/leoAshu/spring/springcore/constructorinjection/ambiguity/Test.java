package com.leoAshu.spring.springcore.constructorinjection.ambiguity;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/leoAshu/spring/springcore/constructorinjection/ambiguity/config.xml");
		
		Addition addition1 = (Addition) ctx.getBean("addition1");
		
		Addition addition2 = (Addition) ctx.getBean("addition2");
	}

}
