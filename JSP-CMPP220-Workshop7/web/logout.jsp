<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    session.removeAttribute("loginStatus");
    session.removeAttribute("CustomerId");
    session.invalidate();
    
     %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to Travel Experts</title>
</head>
<body>
	<h1> You have successfully logged out.</h1>
	<a href="login.jsp">Login Here!</a>
</body>
</html>