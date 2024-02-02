package com.leoAshu.spring.springcore.lifecycle.xmlcfg;

public class Patient {

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void init() {
		System.out.println("init(): Patient");
	}

	public void destroy() {
		System.out.println("destroy(): Patient");
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + "]";
	}

}
