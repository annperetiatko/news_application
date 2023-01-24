<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
	<h3>Register for Places</h3>
	<div>${message}</div>
	<form action="/register" method="post">
		<div>
			<label for="username">User name:</label>
			<input type="text" name="username" placeholder="User name">
		</div>
		<div>
			<label for="password">Password:</label>
			<input type="password" name="password" placeholder="Password">		
		</div>
		<input type="submit" value="Register">
	</form>

</body>
</html>