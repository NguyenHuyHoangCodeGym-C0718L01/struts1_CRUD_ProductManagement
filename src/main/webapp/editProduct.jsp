<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="s"%>
<%@ page import="model.Product"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit product</title>
</head>
<body>
	<html:link action="/home.html">Return home page</html:link>
	<br>
	<br>
	<html:form action="/process-edit-product.html" method="post">
		<%Product product = (Product) request.getAttribute("product"); %>
		<html:text name="prod" property="id" readonly="true" value="<%=product.getId()%>"></html:text>
		<br>
		<label>Product Name</label>
		<html:text property="name" name="prod" value="<%=product.getName()%>"></html:text>
		<br>
		<label>Product price</label>
		<html:text property="price" name="prod" value="<%=product.getPrice()%>"></html:text>
		<br>
		<label>Product description</label>
		<html:textarea property="description" name="prod" value="<%=product.getDescription()%>"></html:textarea>
		<br>
		<html:submit>Edit Product</html:submit>
	</html:form>
</body>
</html>