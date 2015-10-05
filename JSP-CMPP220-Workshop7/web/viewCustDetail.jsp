<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.sql.*,customer.Customer,customer.DbManager"%>
<%
     String loginStatus = (String)session.getAttribute("loginStatus");
     Integer custId = (Integer)session.getAttribute("CustomerId");
     int customerId = custId.intValue();
     //Customer cust = null;
     System.out.println("Customer id in view jsp is : " + customerId);
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	if((loginStatus != null) && (loginStatus.equals("true")))
     {
     	Customer cust = DbManager.getCustomer(customerId);
     	
      %>
	Hello 	<%=cust.getCustFirstName() + " " + cust.getCustLastName() %>

	<form name="viewCustDetail" method="post" action="CustomerServlet">
		<input type="hidden" name="pagename" value="viewCustDetail" />
		<table align="center">
			<tr>
				<td>First Name</td>
				<td><input type="text" name="fname"
					value="<%=cust.getCustFirstName() == null? "" : cust.getCustFirstName() %>"
					disabled="disabled" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lname"
					value="<%=cust.getCustLastName() == null ? "" : cust.getCustLastName() %>"
					disabled="disabled" /></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" name="address"
					value="<%=cust.getCustAddress() == null ? "" : cust.getCustAddress() %>"
					disabled="disabled" /></td>
			</tr>
			<tr>
				<td>City</td>
				<td><input type="text" name="city"
					value="<%=cust.getCustCity() == null ? "" : cust.getCustCity() %>"
					disabled="disabled" /></td>
			</tr>
			<tr>
				<td>Province</td>
				<td><input type="text" name="province"
					value="<%=cust.getCustProv() == null ? "" : cust.getCustProv() %>"
					disabled="disabled" /></td>
			</tr>
			<tr>
				<td>Postal</td>
				<td><input type="text" name="postal"
					value="<%=cust.getCustPostal() == null ? "" : cust.getCustPostal() %>"
					disabled="disabled" /></td>
			</tr>
			<tr>
				<td>Country</td>
				<td><input type="text" name="country"
					value="<%=cust.getCustCountry() == null ? "" : cust.getCustCountry() %>"
					disabled="disabled" /></td>
			</tr>
			<tr>
				<td>Home Phone</td>
				<td><input type="text" name="homephone"
					value="<%=cust.getCustHomePhone() == null ? "" : cust.getCustHomePhone() %>"
					disabled="disabled" /></td>
			</tr>
			<tr>
				<td>Business Phone</td>
				<td><input type="text" name="busphone"
					value="<%=cust.getCustBusPhone() == null ? "" : cust.getCustBusPhone() %>" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email"
					value="<%=cust.getCustEmail() == null ? "" : cust.getCustEmail() %>"
					disabled="disabled" /></td>
			</tr>
			<tr>
				<td>AgentId</td>
				<td><input type="text" name="agentid"
					value="<%=cust.getAgentId() == 0 ? 0 : cust.getAgentId() %>"
					disabled="disabled" /></td>
			</tr>
			<tr>
				<td>UserName</td>
				<td><input type="text" name="username"
					value="<%=cust.getUserName() == null ? "" : cust.getUserName() %>"
					disabled="disabled" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password"
					value="<%=cust.getPassword() == null ? "" : cust.getPassword() %>"
					disabled="disabled" /></td>
			</tr>
		</table>
	</form>
	<% 
     } 
     else
     {
     	response.sendRedirect("login.jsp");
     }
	%>
</body>
</html>