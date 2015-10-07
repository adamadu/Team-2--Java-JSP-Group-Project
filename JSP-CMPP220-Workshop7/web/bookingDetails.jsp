<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="customer.DbManager,customer.BookingDetail,customer.Package,java.util.List"%>
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
<title>Customer Profile</title>
</head>
<body>
	
    <table>
    	<tr>
    		<td>
    			<table>
					<tr>
						<td><a href="bookingDetails.jsp">Booking Details</a></td>
					</tr>
					<tr>
						<td><a href="viewCustDetail.jsp"> View Account Details</a>
					</tr>
					<tr>
						<td><a href="editCustDetail.jsp">Edit Account Details</a></td>
					</tr>
					<tr>
						<td><a href="logout.jsp">Logout</a></td>
					</tr>
				</table>
    		</td>
    		<td>
    		
    		<%
				if((loginStatus != null) && (loginStatus.equals("true")))
			     {
			     	List<BookingDetail> bookdtlList = DbManager.getBookingDetails(customerId);
			     	if(bookdtlList != null && bookdtlList.size() != 0)
			     	{
				     	for(BookingDetail bookdtl : bookdtlList)
				     	{
				     		int packageId = bookdtl.getPackageId();
				     		Package pkgDtl = DbManager.getPackageDetails(packageId);

   			 %>
				   			 <form name="bookDetails">
				    
						     <table>
						    	<tr>
						    		<td>Booking Id : </td>
						    		<td><%=bookdtl.getBookingId() != 0 ? bookdtl.getBookingId() : 0 %></td>
						    	</tr>
						    	<tr>
						    		<td>BookingNo : </td>
						    		<td><%=bookdtl.getBookingNo() != null ? bookdtl.getBookingNo() : "" %></td>
						    	</tr>
						    	<tr>
						    		<td>TravelerCount : </td>
						    		<td><%=bookdtl.getTravelerCount() != 0 ? bookdtl.getTravelerCount() : 0 %></td>
						    	</tr>
						    	<tr>
						    		<td>PackageId : </td>
						    		<td><%=bookdtl.getPackageId() != 0 ? bookdtl.getPackageId() : 0 %></td>
						    	</tr>
						    	<tr>
						    		<td>Package Name : </td>
						    		<td><%=pkgDtl.getPkgName() != null ? pkgDtl.getPkgName() : "" %></td>
						    	</tr>
						    	<tr>
						    		<td>Package Desc : </td>
						    		<td><%=pkgDtl.getPkgDesc() != null ? pkgDtl.getPkgDesc() : "" %></td>
						    	</tr>
						    	<tr>
						    		<td>Package Start Date : </td>
						    		<td><%=pkgDtl.getPkgStartDate() != null ? pkgDtl.getPkgStartDate() : "" %></td>
						    	</tr>
						    	<tr>
						    		<td>Package End Date : </td>
						    		<td><%=pkgDtl.getPkgEndDate() != null ? pkgDtl.getPkgEndDate() : "" %></td>
						    	</tr>
						    	<tr>
						    		<td>Package Base Price : </td>
						    		<td><%=pkgDtl.getPkgBasePrice() != 0 ? pkgDtl.getPkgBasePrice() : 0 %></td>
						    	</tr>
						    	<tr>
						    		<td>Package Agency Commission : </td>
						    		<td><%=pkgDtl.getPkgAgencyCommission() != 0 ? pkgDtl.getPkgAgencyCommission() : 0 %></td>
						    	</tr>
						    </table>
						    <br/><br/>
						    </form>
		    <%
		   		 		}%>
		   		 	<br/><br/>
		    		<input type="button" value="Print" onclick="window.print()" align="center" />
		    <%	}
		    	
		    	else
		    	{%>
		    		<h5>You have no travel bookings</h5>
		    	<%}
		    	}
		     }
		    %>
    		</td>
    	</tr>
    </table>
</body>
</html>