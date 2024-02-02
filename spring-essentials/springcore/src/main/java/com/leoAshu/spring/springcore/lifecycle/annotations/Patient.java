package com.leoAshu.spring.springcore.lifecycle.annotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Patient {

	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + "]";
	}

	@PostConstruct
	public void init() {
		System.out.println("init(): Patient");
	}

	@PreDestroy
	public void destroy() {
		System.out.println("destroy(): Patient");
	}

}
