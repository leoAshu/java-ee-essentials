package com.leoAshu.couponAndProdApp.controller;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leoAshu.couponAndProdApp.dao.CouponDAO;
import com.leoAshu.couponAndProdApp.model.Coupon;

/**
 * Servlet implementation class CouponController
 */
@WebServlet("/coupons")
public class CouponController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CouponDAO dao = new CouponDAO();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equals("create")) {			
			create(request, response);
		} else {
			find(request, response);
		}
	}

	private void create(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String couponCode = request.getParameter("couponCode");
		String discount = request.getParameter("discount");
		String expDate = request.getParameter("expiryDate");
		
		Coupon coupon = new Coupon();
		coupon.setCode(couponCode);
		coupon.setDiscount(new BigDecimal(discount));
		coupon.setExpDate(expDate);
		
		dao.save(coupon);
		
		response.setContentType("text/html");
		response.getWriter()
		.append("<b>Coupon created!</b>")
		.append("<br/><a href='/CouponAndProductApp/'>Home</a>");
	}
	
	private void find(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String couponCode = request.getParameter("couponCode");
		
		Coupon coupon = dao.find(couponCode);
		
		response.setContentType("text/html");
		response.getWriter()
		.append("<h3>Coupon Details:</h3>")
		.append(coupon.toString())
		.append("<br /><br /><a href='/CouponAndProductApp/'>Home</a>");
		
	}

}
