package com.leoAshu.jdbc.advanced.batch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BatchDAO {

	public static void main(String[] args) {
		try(
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "password");
				Statement stmt = conn.createStatement();
				) {
			
			stmt.addBatch("insert into account values(100, 'Ojha', 'Ashutosh', 10000)");
			stmt.addBatch("insert into account values(101, 'Ojha', 'Kirti', 1000)");
			stmt.addBatch("insert into account values(102, 'Ojha', 'Ayush', 100)");
			
			int[] result = stmt.executeBatch();
			System.out.println(result.length + " entries inserted.");
			
			for(int i: result) {
				System.out.println(i);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
