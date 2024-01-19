package com.leoAshu.isc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PreparedStatement stmt;
	
	public void init() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "password");
			stmt = conn.prepareStatement("select * from user where email=? and password=?");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			
			stmt.setString(1, userName);
			stmt.setString(2, password);
			
			ResultSet resultSet = stmt.executeQuery();
			
			RequestDispatcher requestDispatcher;
			
			if (resultSet.next()) {
				requestDispatcher = request.getRequestDispatcher("/homeServlet");
				request.setAttribute("message", "Welcome to Interservlet Communication " + userName);
				requestDispatcher.forward(request, response);
			} else {
				requestDispatcher = request.getRequestDispatcher("/login.html");
				requestDispatcher.include(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
