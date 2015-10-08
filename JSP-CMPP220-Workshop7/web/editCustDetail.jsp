<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*,customer.Customer,customer.DbManager"%>
    <%
     String loginStatus = (String)session.getAttribute("loginStatus");
     
    if(loginStatus == null)
    {
    	response.sendRedirect("login.jsp");
    }
    else
    {
     	Integer custId = (Integer)session.getAttribute("CustomerId");
     	int customerId = custId.intValue();
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.11.3.js"></script>
<script type="text/javascript" src="js/customerValidation.js"></script>
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
    <%@include file="header.jsp" %>
    <div class="content">
        <div class="container">

     
      <form name="editCustDetail" id="editCustDetail" method="post" action="CustomerServlet">
       <input type="hidden" name="pagename" value="editCustDetail"/>
       	<table align="center">
            	<%
	if((loginStatus != null) && (loginStatus.equals("true")))
     {
     	Customer cust = DbManager.getCustomer(customerId);
     	
    %>
    <th colspan="2"> <h2>Hello <%=cust.getCustFirstName() + " " + cust.getCustLastName()%>! </h2></th>
       		<tr>
       			<td>First Name  </td>
       			<td><input type="text" name="fname" value="<%=cust.getCustFirstName() == null? "" : cust.getCustFirstName() %>" />
       				<span class="error" id="fnameErr"></span>
       			</td>
       		</tr>
       		<tr>
       			<td>Last Name  </td>
       			<td><input type="text" name="lname" value="<%=cust.getCustLastName() == null ? "" : cust.getCustLastName() %>" />
       				<span class="error" id="lnameErr"></span>
       			</td>
       		</tr>
       		<tr>
       			<td>Address </td>
       			<td><input type="text" name="address" value="<%=cust.getCustAddress() == null ? "" : cust.getCustAddress() %>" />
       				<span class="error" id="addressErr"></span>
       			</td>
       		</tr>
       		<tr>
       			<td>City </td>
       			<td><input type="text" name="city" value="<%=cust.getCustCity() == null ? "" : cust.getCustCity() %>" />
       				<span class="error" id="cityErr"></span>
       			</td>
       		</tr>
       		<tr>
       			<td>Province </td>
       			<td><input type="text" name="province" value="<%=cust.getCustProv() == null ? "" : cust.getCustProv() %>" />
       				<span class="error" id="provinceErr"></span>
       			</td>
       		</tr>
       		<tr>
       			<td>Postal </td>
       			<td><input type="text" name="postal" value="<%=cust.getCustPostal() == null ? "" : cust.getCustPostal() %>" />
       				<span class="error" id="postalErr"></span>
       			</td>
       		</tr>
       		<tr>
       			<td>Country </td>
       			<td><input type="text" name="country" value="<%=cust.getCustCountry() == null ? "" : cust.getCustCountry() %>" />
       				<span class="error" id="countryErr"></span>
       			</td>
       		</tr>
       		<tr>
       			<td>Home Phone </td>
       			<td><input type="text" name="homephone" value="<%=cust.getCustHomePhone() == null ? "" : cust.getCustHomePhone() %>" />
       				<span class="error" id="homephoneErr"></span>
       			</td>
       		</tr>
       		<tr>
       			<td>Business Phone </td>
       			<td><input type="text" name="busphone" value="<%=cust.getCustBusPhone() == null ? "" : cust.getCustBusPhone() %>" />
       				<span class="error" id="busphoneErr"></span>
       			</td>
       		</tr>
       		<tr>
       			<td>Email </td>
       			<td><input type="text" name="email" value="<%=cust.getCustEmail() == null ? "" : cust.getCustEmail() %>" />
       				<span class="error" id="emailErr"></span>
       			</td>
       		</tr>
       		<tr>
       			<td>AgentId </td>
       			<td><input type="text" name="agentid" value="<%=cust.getAgentId() == 0 ? 0 : cust.getAgentId() %>" />
       				<span class="error" id="agentidErr"></span>
       			</td>
       		</tr>
       		<tr>
       			<td>UserName </td>
       			<td><input type="text" name="username" value="<%=cust.getUserName() == null ? "" : cust.getUserName() %>" readonly="readonly"/></td>
       		</tr>
       		<tr>
       			<td>Password </td>
       			<td><input type="password" name="password" value="<%=cust.getPassword() == null ? "" : cust.getPassword() %>" />
       				<span class="error" id="passwordErr"></span>
       			</td>
       		</tr>
       		<tr>
       			
       			<td><input type="submit" name="update" value="Update" onclick="return validateCustomer();"/></td>
       			<td><input type="reset" name="reset" value="Reset" /></td>
       		</tr>
       	</table>
       </form>
                                
     <% 
     	}
     	}
     %>
        </div>
    </div>
     <script>
     	
     	
     </script>
</body>
</html>