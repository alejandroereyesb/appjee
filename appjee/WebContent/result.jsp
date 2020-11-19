<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "https://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
		<title>Login Success Page</title>
	</head>
	<body>
		<% 
			String s = (String)request.getAttribute("nombre");
			
			String userName = null; //usuario
			String sessionID = null;//sesion
			Cookie[] cookies = request.getCookies();
			if(cookies !=null){
			for(Cookie cookie : cookies){
				if(cookie.getName().equals("user")) userName = cookie.getValue(); //usuario
				if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue(); //sesion
			}
			}
			if(userName == null) response.sendRedirect("login.html");
		
	    %>
		<h3>Ha sido usted logado con exito</h3>
			<h3>Esta es tu cookie!!--> <%=userName %> . Your Session ID=<%=sessionID %></h3>
		    <p> Bienvenido!!! <%= s %></p>
		    <p> Bienvenido!!! ${nombre}</p>
		    <img src="./img/ferrari.jpeg"></img>
		    
		        
		<!-- <a href="login.html">Login Page</a> -->
		<form action="LogoutServlet" method="post">
			<input type="submit" value="Logout" >
		</form>
	</body>
</html>
