package com.leoAshu.couponAndProdApp.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionUtil {

	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			InitialContext context = new InitialContext();
			DataSource source = (DataSource)context.lookup("java:comp/env/myds");
			conn = source.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
