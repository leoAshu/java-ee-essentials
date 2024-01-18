package com.leoAshu.user.app.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreateUserServlet
 */
@WebServlet("/readServlet")
public class ReadUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection conn;
       
	public void init() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "password");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		try(Statement stmt = conn.createStatement()) {
			ResultSet resultSet = stmt.executeQuery("select * from user");
			
			PrintWriter out = response.getWriter();
			
			out.print("<table>");
			out.print("<tr>");
			out.print("<th>");
			out.println("First Name");
			out.print("</th>");
			out.print("<th>");
			out.println("Last Name");
			out.print("</th>");
			out.print("<th>");
			out.println("Email");
			out.print("</th>");
			out.print("</tr>");
			
			while(resultSet.next()) {
				out.print("<tr>");
				out.print("<td>");
				out.println(resultSet.getString(1));
				out.print("</td>");
				out.print("<td>");
				out.println(resultSet.getString(2));
				out.print("</td>");
				out.print("<td>");
				out.println(resultSet.getString(3));
				out.print("</td>");
				out.print("</tr>");
			}
			
			out.print("<table>");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void destroy() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
