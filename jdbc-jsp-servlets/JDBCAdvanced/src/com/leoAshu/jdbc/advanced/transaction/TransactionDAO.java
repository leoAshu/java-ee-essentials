package com.leoAshu.jdbc.advanced.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionDAO {

	public static void main(String[] args) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "password");
			Statement stmt = conn.createStatement();
			
			// default true
			conn.setAutoCommit(false);
			
			stmt.executeUpdate("update account set bal=bal-1000 where accno=100");
			stmt.executeUpdate("update account set bal=bal+500 where accno=101");
			stmt.executeUpdate("update account set bal=bal+500 where accno=102");
			
			// commit when transaction completes
			conn.commit();
			
		} catch(Exception e) {
			try {
				conn.close();
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
	}
}
