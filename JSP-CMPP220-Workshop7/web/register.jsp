<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! String message = ""; %>    
<% message = request.getParameter("message"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration</title>
<script type="text/javascript" src="js/customerValidation.js"></script>
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
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
<form name="regCustDetail" id="regCustDetail" method="post" action="CustomerServlet">
       <input type="hidden" name="pagename" value="registerCustDetail"/>
       	<table align="center">
       		<tr>
       			<td>UserName </td>
       			<td><input type="text" name="username" /></td>
       		</tr>
       		<tr>
       			<td>Password </td>
       			<td><input type="password" name="password"  />
       				<span class="error" id="passwordErr"></span>
       			</td>
       		</tr>
       		<tr>
       			<td>First Name  </td>
       			<td><input type="text" name="fname" />
       				<span class="error" id="fnameErr"></span>
       			</td>
       		</tr>
       		<tr>
       			<td>Last Name  </td>
       			<td><input type="text" name="lname"  />
       				<span class="error" id="lnameErr"></span>
       			</td>
       		</tr>
       		<tr>
       			<td>Address </td>
       			<td><input type="text" name="address"  />
       				<span class="error" id="addressErr"></span>
       			</td>
       		</tr>
       		<tr>
       			<td>City </td>
       			<td><input type="text" name="city"  />
       				<span class="error" id="cityErr"></span>
       			</td>
       		</tr>
       		<tr>
       			<td>Province </td>
       			<td><input type="text" name="province"  />
       				<span class="error" id="provinceErr"></span>
       			</td>
       		</tr>
       		<tr>
       			<td>Postal </td>
       			<td><input type="text" name="postal"  />
       				<span class="error" id="postalErr"></span>
       			</td>
       		</tr>
       		<tr>
       			<td>Country </td>
       			<td><input type="text" name="country"  />
       				<span class="error" id="countryErr"></span>
       			</td>
       		</tr>
       		<tr>
       			<td>Home Phone </td>
       			<td><input type="text" name="homephone"  />
       				<span class="error" id="homephoneErr"></span>
       			</td>
       		</tr>
       		<tr>
       			<td>Business Phone </td>
       			<td><input type="text" name="busphone"  />
       				<span class="error" id="busphoneErr"></span>
       			</td>
       		</tr>
       		<tr>
       			<td>Email </td>
       			<td><input type="text" name="email"  />
       				<span class="error" id="emailErr"></span>
       			</td>
       		</tr>
       		<tr>
       			<td>AgentId </td>
       			<td><input type="text" name="agentid"  />
       				<span class="error" id="agentidErr"></span>
       			</td>
       		</tr>
       		<tr>
       			<td><input type="submit" name="register" value="Register" onclick="return validateCustomer();"/></td>
       			<td><input type="button" name="clear" value="Clear" /></td>
       		</tr>
       	</table>
       </form>
</body>
</html>