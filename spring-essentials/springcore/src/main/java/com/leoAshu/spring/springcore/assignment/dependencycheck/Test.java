package com.leoAshu.spring.springcore.assignment.dependencycheck;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/leoAshu/spring/springcore/assignment/dependencycheck/config.xml");
		
		University university1 = (University) ctx.getBean("university");
		System.out.println(university1);
		System.out.println(university1.hashCode());
		
		University university2 = (University) ctx.getBean("university");
		System.out.println(university2);
		System.out.println(university2.hashCode());
	}

}
