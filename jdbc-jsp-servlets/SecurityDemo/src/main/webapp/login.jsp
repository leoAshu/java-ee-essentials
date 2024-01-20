<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<form action="j_security_check" method="post">
Username:
<br />
<input type="text" name="j_username" />
<br />
<br />
Password:
<br />
<input type="password" name="j_password" />
<br />
<br />
<input type="submit" value="submit" />
</form>
</body>
</html>