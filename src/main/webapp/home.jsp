<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home page</title>
</head>
<body>
	<html:link action="/add-product.html">Create new Product</html:link>
	<br>
	<logic:present name="message">
		<bean:write name="message" />
	</logic:present>
	<br>
	<table border="1" cellpadding="2" cellspacing="2">
		<tr>
			<th>Product name</th>
			<th>Product price</th>
			<th>Product description</th>
			<th>Option</th>
		</tr>
		<logic:iterate name="list" id="listId">
			<tr>
				<td><bean:write name="listId" property="name"/></td>
				<td><bean:write name="listId" property="price" format="#################"/></td>
				<td><bean:write name="listId" property="description"/></td>
				<td>
					<html:link action="/edit-product.html" paramName="listId" paramId="idProd" paramProperty="id">Edit</html:link> | <html:link action="/delete-product.html" paramName="listId" paramId="idProd" paramProperty="id" onclick="return confirm('Are you sure?')">Delete</html:link> 
				</td>
			</tr>
		</logic:iterate>
	</table>
</body>
</html>