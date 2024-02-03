package com.leoAshu.spring.springcore.assignment.setterinjection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/leoAshu/spring/springcore/assignment/setterinjection/config.xml");
		ShoppingCart cart = (ShoppingCart) ctx.getBean("shoppingCart");
		System.out.println(cart);
		ctx.close();
	}

}
