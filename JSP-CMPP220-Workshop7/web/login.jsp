<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%! String message = ""; %>    
<% message = request.getParameter("message"); 
    String loginStatus = (String)session.getAttribute("loginStatus");
    if(loginStatus != null)
    {
        response.sendRedirect("index.jsp");
    }
     
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/main.css">
<script></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Test JSP</title>
</head>
<body>
    <%@include file="header.jsp" %>
	<h5 style="color:red">
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
	</h5>
        <div class="content">
            <div class="container">
	<form name="login" id="login" action="CustomerServlet" method="post">
	<input type="hidden" name="pagename" value="login"/>
		<table>
                    <th colspan="2">
                        <h2>Please enter your username and password:</h2>
                    </th>
			<tr>
				<td><label>UserName <span class="mandatory"> * </span></label>  </td>
				<td><input type="text" name="txtUserName" />
					<span id="usererr" class="mandatory"></span>
				</td>
			</tr>
			<tr>
				<td> <label>Password <span class="mandatory"> * </span></label></td>
				<td><input type="password" name="txtPassword" />
					<span id="passworderr" class="mandatory"></span>
			</tr>
			<tr>
                            <td colspan="2" style="text-align: center"><button type="submit" value="Login" 
								onclick="return validateForm();">Login</button>
			</tr>
                        <tr><td colspan="2" style="text-align: center"><a href="register.jsp" align="center">Register here!</a></td></tr>
		</table>
	</form>
            </div>
        </div>
	<script>
		function validateForm()
		{
			var errormsg = false;
			var usererror,passerror;
			var username = document.login.txtUserName.value;
			var password = document.login.txtPassword.value;
			if(username == "")
			{
				usererror = "UserName is required";
				document.getElementById("usererr").innerHTML = usererror;
				errormsg = true;
			}
			else
			{
				document.getElementById("usererr").innerHTML = "";
			}
			
			if(password == "" && password.length<6)
			{
				passerror = "Password is required";true
				document.getElementById("passworderr").innerHTML = passerror;
				errormsg = true;
			}
			else
			{
				document.getElementById("passworderr").innerHTML = "";
			}
			if(errormsg)
				return false;
			else
				return true;
		}
	</script>
                
</body>
</html>