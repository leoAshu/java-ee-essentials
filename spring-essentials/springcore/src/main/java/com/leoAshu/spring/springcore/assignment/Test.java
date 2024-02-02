package com.leoAshu.spring.springcore.assignment;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("com/leoAshu/spring/springcore/assignment/config.xml");
		ShoppingCart cart = (ShoppingCart) ctx.getBean("shoppingCart");
		System.out.println(cart);
		ctx.close();
	}

}
