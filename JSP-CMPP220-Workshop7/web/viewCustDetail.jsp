<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.sql.*,customer.Customer,customer.DbManager"%>
<%
     String loginStatus = (String)session.getAttribute("loginStatus");
     
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
     	Integer custId = (Integer)session.getAttribute("CustomerId");
     	int customerId = custId.intValue();
     	Customer cust = DbManager.getCustomer(customerId);
     	
      %>
	Hello 	<%=cust.getCustFirstName() + " " + cust.getCustLastName() %>

	<form name="viewCustDetail" method="post" action="CustomerServlet">
		<input type="hidden" name="pagename" value="viewCustDetail" />
		<table align="center">
			<tr>
				<td>First Name :</td>
				<td><%=cust.getCustFirstName() == null? "" : cust.getCustFirstName() %></td>
			</tr>
			<tr>
				<td>Last Name :</td>
				<td><%=cust.getCustLastName() == null ? "" : cust.getCustLastName() %></td>
			</tr>
			<tr>
				<td>Address :</td>
				<td><%=cust.getCustAddress() == null ? "" : cust.getCustAddress() %></td>
			</tr>
			<tr>
				<td>City :</td>
				<td><%=cust.getCustCity() == null ? "" : cust.getCustCity() %></td>
			</tr>
			<tr>
				<td>Province :</td>
				<td><%=cust.getCustProv() == null ? "" : cust.getCustProv() %></td>
			</tr>
			<tr>
				<td>Postal :</td>
				<td><%=cust.getCustPostal() == null ? "" : cust.getCustPostal() %></td>
			</tr>
			<tr>
				<td>Country :</td>
				<td><%=cust.getCustCountry() == null ? "" : cust.getCustCountry() %></td>
			</tr>
			<tr>
				<td>Home Phone :</td>
				<td><%=cust.getCustHomePhone() == null ? "" : cust.getCustHomePhone() %></td>
			</tr>
			<tr>
				<td>Business Phone :</td>
				<td><%=cust.getCustBusPhone() == null ? "" : cust.getCustBusPhone() %></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><%=cust.getCustEmail() == null ? "" : cust.getCustEmail() %></td>
			</tr>
			<tr>
				<td>AgentId :</td>
				<td><%=cust.getAgentId() == 0 ? 0 : cust.getAgentId() %></td>
			</tr>
			<tr>
				<td>UserName :</td>
				<td><%=cust.getUserName() == null ? "" : cust.getUserName() %></td>
			</tr>
			<%-- <tr>
				<td>Password :</td>
				<td><%=cust.getPassword() == null ? "" : cust.getPassword() %></td>
			</tr> --%>
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