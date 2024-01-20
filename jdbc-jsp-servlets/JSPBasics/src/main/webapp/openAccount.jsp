<%@ page import="java.sql.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%!
    	Connection conn;
    	PreparedStatement stmt;
    	
    	public void jspInit() {
    		try {			
    			Class.forName("com.mysql.cj.jdbc.Driver");
    			conn = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "password");
    			stmt = conn.prepareStatement("insert into account values(?,?,?,?)");
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	}
    	
    	public void jspDestroy() {
    		try {
    			stmt.close();
    			conn.close();
    		} catch(Exception e) {
    			e.printStackTrace();
    		}
    	}
    %>
    
    <% 
    
    	int accno = Integer.parseInt(request.getParameter("accno"));
    	String lastName = request.getParameter("lastname");
    	String firstName = request.getParameter("firstname");
    	int balance = Integer.parseInt(request.getParameter("bal"));
    	
    	stmt.setInt(1, accno);
    	stmt.setString(2, lastName);
    	stmt.setString(3, firstName);
    	stmt.setInt(4, balance);
    	
    	stmt.executeUpdate();
    %>
    
    <%@ include file="openaccount.html" %>