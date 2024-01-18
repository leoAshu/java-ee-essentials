package com.leoAshu.servlet.basics;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/add")
public class AdditionServlet extends GenericServlet {

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		if (request.getParameter("number1") != null && request.getParameter("number2") != null) {
			Integer num1 = Integer.parseInt(request.getParameter("number1"));
			Integer num2 = Integer.parseInt(request.getParameter("number2"));
			PrintWriter out = response.getWriter();
			out.println("The result is " + (num1 + num2));
		}
	}

}
