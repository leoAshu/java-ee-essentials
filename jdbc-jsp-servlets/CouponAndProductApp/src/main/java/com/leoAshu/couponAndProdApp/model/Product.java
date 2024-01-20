package com.leoAshu.couponAndProdApp.model;

import java.math.BigDecimal;

public class Product {

	private int id;
	private String name;
	private String descritpion;
	private BigDecimal price;
	private String couponCode;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescritpion() {
		return descritpion;
	}

	public void setDescritpion(String descritpion) {
		this.descritpion = descritpion;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", descritpion=" + descritpion + ", price=" + price
				+ ", couponCode=" + couponCode + "]";
	}

}
