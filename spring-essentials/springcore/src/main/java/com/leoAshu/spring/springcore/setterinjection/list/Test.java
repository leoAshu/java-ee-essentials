package com.leoAshu.spring.springcore.setterinjection.list;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/leoAshu/spring/springcore/setterinjection/list/config.xml");
		Hospital hospital = (Hospital) ctx.getBean("hospital");
		System.out.println(hospital.getName());
		System.out.println(hospital.getDepartments());
		ctx.close();
	}

}
