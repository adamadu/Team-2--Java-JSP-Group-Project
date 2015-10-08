<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="customer.DbManager,customer.Booking,customer.Package,customer.BookingDetail,java.util.List"%>
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
	     System.out.println("Customerid : " + customerId);
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
						<td><a href="/CPRG220Workshop7/PackageServlet">Package Details</a></td>
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
			     System.out.println("LoginStatus : " + loginStatus);
			     	List<Booking> bookdtlList = DbManager.getBookingDetails(customerId);
			     	if(bookdtlList != null && bookdtlList.size() != 0)
			     	{
			     		System.out.println("Booklist size: " + bookdtlList.size());
				     	for(Booking bookdtl : bookdtlList)
				     	{
				     		int packageId = bookdtl.getPackageId();
				     		int bookingId = bookdtl.getBookingId();
				     		String tripTypeId = bookdtl.getTripTypeId();
				     		Package pkgDtl = DbManager.getPackageDetails(packageId);
							System.out.println("Pkgname : " + pkgDtl.getPkgName());
							BookingDetail tripDetails = DbManager.getTripDetails(bookingId);
							String tripName = DbManager.getTripName(tripTypeId);
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
						    		<td>Trip Itineray No: </td>
						    		<td><%=tripDetails.getItineraryNo() !=0 ? tripDetails.getItineraryNo() : 0 %></td>
						    	</tr>
						    	<tr>
						    		<td>Trip Start Date:</td>
						    		<td><%=tripDetails.getTripStart() != null ? tripDetails.getTripStart() : "" %></td>
						    	</tr>
						    	<tr>
						    		<td>Trip End Date:</td>
						    		<td><%=tripDetails.getTripEnd() != null ? tripDetails.getTripEnd() : "" %></td>
						    	</tr>
						    	<tr>
						    		<td>Description: </td>
						    		<td><%=tripDetails.getDescription() != null ? tripDetails.getDescription() : "" %></td>
						    	</tr>
						    	<tr>
						    		<td>Destination: </td>
						    		<td><%=tripDetails.getDestination() != null ? tripDetails.getDestination() : "" %></td>
						    	</tr>
						    	<tr>
						    		<td>Base Price: </td>
						    		<td><%=tripDetails.getBasePrice() != 0 ? tripDetails.getBasePrice() : 0 %></td>
						    	</tr>
						    	<tr>
						    		<td>TripTypeName: </td>
						    		<td><%=tripName != null ? tripName : "" %></td>
						    	</tr>
						    </table>
						    <br/><br/>
						    </form>
		    <%
		   		 		}%>
		   		 	<br/><br/>
		    		<input type="button" value="Print" onclick="window.print()" />
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