<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Product Page</title>
</head>
<body>
	<h1>VIEW PRODUCT</h1>
		<table>
			<tr>
				<td>Product Id:</td>
				<td>${p.proId}</td>
			</tr>
			<tr>
				<td>Product Name:</td>
				<td>${p.proName}</td>
			</tr>
			<tr>
				<td>Producer:</td>
				<td>${p.producer}</td>
			</tr>
			<tr>
				<td>Year Making:</td>
				<td>${p.yearMaking}</td>
			</tr>
			<tr>
				<td>Expire Date:</td>
				<td>${p.expireDate}</td>
			</tr>
			<tr>
				<td>Price:</td>
				<td>${p.price}</td>
			</tr>	
			<tr>
				<td><a href="listP">Back</a></td>
				<td><a href="initUpdateProduct?proId=${p.proId}">Update</a></td>
			</tr>		
		</table>
		
</body>
</html>