<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%! String message = ""; %>    
<% message = request.getParameter("message"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Test JSP</title>
</head>
<body>
	<h1 style="color:red">
	<% 
	if(message == null)
	{
	  out.print("");
	}
	else 
	{
	  out.print(message);
	}
	%> 
	</h1>
	<form name="login" action="CustomerServlet" method="post">
	<input type="hidden" name="pagename" value="login"/>
		<table>
			<tr>
				<td> UserName : </td>
				<td><input type="text" name="txtUserName" />
			</tr>
			<tr>
				<td> Password : </td>
				<td><input type="password" name="txtPassword" />
			</tr>
			<tr>
				<td colspan="2" align="center"><button type="submit" value="Login">Login</button>
			</tr>
		</table>
	</form>
</body>
</html>