package com.leoAshu.spring.springcore.propertyplaceholder;

public class MyDAO {

	private String dbUser;
	private String dbPassword;

	public MyDAO(String dbUser, String dbPassword) {
		this.dbUser = dbUser;
		this.dbPassword = dbPassword;
	}

	@Override
	public String toString() {
		return "MyDAO [dbUser=" + dbUser + ", dbPassword=" + dbPassword + "]";
	}

}
