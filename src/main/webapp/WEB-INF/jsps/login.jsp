<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Custom Login Page</title>
</head>
<body>
	<h3>Custom Login Page</h3>
	
	<form action="/login" method="post">
		<input type="text" name ="username" placeholder="Username"/>
		<input type="password" name="password"/>
		<input type="submit" value="Login"/>
	</form>
</body>
</html>