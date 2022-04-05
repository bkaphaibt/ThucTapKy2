<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Product Page</title>
</head>
<body>
	<h1>LIST PRODUCTS</h1>
	<c:if test="${not empty success}">
		<h3 style="color:green">${success}</h3>
	</c:if>
	<c:if test="${not empty error}">
		<h3 style="color:red">${error}</h3>
	</c:if>
	
	<form action="searchProductByName">
		Input product name:<input type="text" name="proName"/><input type="submit" value="Search"/>
	</form><br/>
	<table border="1">
		<tr>
			<th>Product id</th>
			<th>Product name</th>
			<th>Producer</th>
			<th>Year making</th>
			<th>Expire date</th>
			<th>Price</th>
			<th>Details</th>
			<th>Delete</th>
		</tr>
		<c:forEach items="${list}" var="p">
			<tr>
				<td>${p.proId}</td>
				<td>${p.proName}</td>
				<td>${p.producer}</td>
				<td>${p.yearMaking}</td>
				<td>${p.expireDate}</td>
				<td>${p.price}</td>
				<td>
					<a href="detailProduct?proId=${p.proId}">detail</a>
				</td>
				<td>
					<a href="deleteProduct?proId=${p.proId}" onclick="return confirm('Sure?')">delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<a href="initInsertProduct">Add New Product</a>
</body>
</html>