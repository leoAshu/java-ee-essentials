package com.leoAshu.jdbc.basics.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountDAO {

	public static void main(String[] args) {
		try(
				// Create connection
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "password");
				
				// Create statement
				Statement stmt = connection.createStatement();
				
				// Perform DQL operation
				ResultSet rs = stmt.executeQuery("select * from account");
				) {
			
			System.out.println(connection);
			
			
			
			// Perform operations
			// Create
//			 int result = stmt.executeUpdate("insert into account values(1, 'ojha', 'ashutosh', 10000)");
//			 System.out.println(result + " rows got inserted");
			
			// Update
//			int result = stmt.executeUpdate("update account set bal=50000 where accno=1");
//			System.out.println(result + " rows got updated");
			
			// Delete
//			int result = stmt.executeUpdate("delete from account where accno=1");
//			System.out.println(result + " rows got deleted");
			
			// Read
			
			while(rs.next()) {
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getInt(4));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
