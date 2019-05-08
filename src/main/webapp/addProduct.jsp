<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add new Product</title>
</head>
<body>
	<html:link action="/home.html">Return home page</html:link>
	<br>
	<logic:present name="message">
		<bean:write name="message" />
	</logic:present>
	<br>
	<html:form action="/process-add-product.do" method="post">
		<label>Product Name</label>
		<html:text property="name" name="prod"></html:text>
		<br>
		<label>Product price</label>
		<html:text property="price" name="prod"></html:text>
		<br>
		<label>Product description</label>
		<html:textarea property="description" name="prod"></html:textarea>
		<br>
		<html:submit>Add new Product</html:submit>
	</html:form>
</body>
</html>