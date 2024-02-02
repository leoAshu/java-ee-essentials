package com.leoAshu.spring.springcore.reference;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/leoAshu/spring/springcore/reference/config.xml");
		Student student = (Student) ctx.getBean("student");
		System.out.println(student);
		ctx.close();
	}

}
