package com.leoAshu.couponAndProdApp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.leoAshu.couponAndProdApp.model.Coupon;
import com.leoAshu.couponAndProdApp.util.ConnectionUtil;

public class CouponDAO {
	
	public void save(Coupon coupon) {
		Connection conn = ConnectionUtil.getConnection();
		
		try {
			PreparedStatement stmt = conn.prepareStatement("insert into coupon (code, discount, exp_date) values(?, ?, ?)");
			
			stmt.setString(1, coupon.getCode());
			stmt.setBigDecimal(2, coupon.getDiscount());
			stmt.setString(3, coupon.getExpDate());
			
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public Coupon find(String code) {
		Coupon coupon = new Coupon();
		Connection conn = ConnectionUtil.getConnection();
		
		try {
			PreparedStatement stmt = conn.prepareStatement("select * from coupon where code=?");
			
			stmt.setString(1, code);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				coupon.setId(rs.getInt(1));
				coupon.setCode(rs.getString(2));
				coupon.setDiscount(rs.getBigDecimal(3));
				coupon.setExpDate(rs.getString(4));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return coupon;
	}
}
