<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
		<title>Mi primera pagina</title>
	</head>
	<body>
		<h2>Hola! Bienvenido a mi HOME - página de servlets :) </h2>
		<br>
		<p>La fecha/hora actual es: </p>
		<h3>Date=<%= new Date() %>
		</h3>
	</body>
</html>
