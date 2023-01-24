<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="menu.jsp" %>
	<h3>My Favorite Places</h3>
	<form action="/" method="post">
		<input type="text" name="city" placeholder="City"/>
		<input type="text" name="country" placeholder="Country"/>
		<input type="submit" value="Create a new place"/>
	</form>
	<table>
		<tr>
			<td>ID</td>
			<th>City</th>
			<th>Country</th>
		</tr>
		<c:forEach items="${places}" var="place">
			<tr>
				<td>${place.id}</td>
				<td>${place.city}</td>
				<td>${place.country}</td>
				<td><a href="/places/${place.id}">Details</a></td>
				<td>
					<form action="deletePlace" method="post">
						<input type="hidden" name="id" value="${place.id}"/>
						<input type="submit" value="Delete"/>
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	<br/>
	
	<form action="/filtered" method="post">
		<input type="text" name="filter"/>
		<input type="submit" value="Filter"/>
	</form>
	<h3>Filtered Places</h3>
	<table>
		<tr>
			<td>ID</td>
			<th>City</th>
			<th>Country</th>
		</tr>
		<c:forEach items="${filteredPlaces}" var="place">
			<tr>
				<td>${place.id}</td>
				<td>${place.city}</td>
				<td>${place.country}</td>
				<td><a href="/places/${place.id}">Details</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>