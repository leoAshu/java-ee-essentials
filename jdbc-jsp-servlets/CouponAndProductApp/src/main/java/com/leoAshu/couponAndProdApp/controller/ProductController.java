package com.leoAshu.couponAndProdApp.controller;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.leoAshu.couponAndProdApp.dao.CouponDAO;
import com.leoAshu.couponAndProdApp.dao.ProductDAO;
import com.leoAshu.couponAndProdApp.model.Coupon;
import com.leoAshu.couponAndProdApp.model.Product;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/products")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CouponDAO couponDAO = new CouponDAO();
	private ProductDAO productDAO = new ProductDAO();
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String price = request.getParameter("price");

		String couponCode = request.getParameter("couponCode");
		Coupon coupon = couponDAO.find(couponCode);
		
		Product product = new Product();
		product.setName(name);
		product.setDescritpion(description);	
		product.setPrice(new BigDecimal(price).subtract(coupon.getDiscount()));
		
		productDAO.save(product);
		
		response.setContentType("text/html");
		response.getWriter()
		.append("<b>Product created!</b>")
		.append("<br/><a href='/CouponAndProductApp/'>Home</a>");
		
	}

}
