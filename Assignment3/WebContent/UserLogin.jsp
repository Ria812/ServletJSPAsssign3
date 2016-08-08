<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page language="java" session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login Form</title>
</head>
<body>
	<h3>Login</h3>
	<form action="LoginServlet" method="post">
		User Name:<input type="text" name="name" required /></br> </br> Password:<input
			type="password" name="password" required /></br> <br> <input
			type="Submit" value="Login" />


	</form>


</body>
</html>