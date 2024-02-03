package com.leoAshu.spring.springcore.constructorinjection.injection;

public class Address {
	private int hno;
	private String street;
	private String city;

	public Address(int hno, String street, String city) {
		super();
		this.hno = hno;
		this.street = street;
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [hno=" + hno + ", street=" + street + ", city=" + city + "]";
	}

	
}
