package com.leoAshu.couponAndProdApp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.leoAshu.couponAndProdApp.model.Product;
import com.leoAshu.couponAndProdApp.util.ConnectionUtil;

public class ProductDAO {
	
	public void save(Product product) {
		Connection conn = ConnectionUtil.getConnection();
		
		try {
			PreparedStatement stmt = conn.prepareStatement("insert into product (name, description, price) values(?, ?, ?)");
			
			stmt.setString(1, product.getName());
			stmt.setString(2, product.getDescritpion());
			stmt.setBigDecimal(3, product.getPrice());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
