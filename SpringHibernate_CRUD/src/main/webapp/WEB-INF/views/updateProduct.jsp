<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Product Page</title>
</head>
<body>
	<h1>UPDATE PRODUCT</h1>
	<h3 style="color:red">${error }</h3>
	
	<form:form action="updateProduct" modelAttribute="p" method="post">
		<table>
			<tr>
				<td>Product Id:</td>
				<td><form:input path="proId" readonly="readonly"/></td>
			</tr>
			<tr>
				<td>Product Name:</td>
				<td><form:input path="proName"/></td>
			</tr>
			<tr>
				<td>Producer:</td>
				<td><form:input path="producer"/></td>
			</tr>
			<tr>
				<td>Year Making:</td>
				<td><form:input path="yearMaking" type="number"/></td>
			</tr>
			<tr>
				<td>Expire Date:</td>
				<td><form:input path="expireDate" type="date"/></td>
			</tr>
			<tr>
				<td>Price:</td>
				<td><form:input path="price" type="number"/></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Update"/>
				<input type="reset" value="Clear"/></td>
			</tr>
		</table>
	</form:form>
</body>
</html>