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
<link rel="stylesheet" type="text/css" href="css/main.css">
<title>Customer Profile</title>
</head>
<body>
	  <%@include file="header.jsp" %>
          <div class="content">
              <div class="container">
    
    		<%
				if((loginStatus != null) && (loginStatus.equals("true")))
			     {
			     	List<Booking> bookdtlList = DbManager.getBookingDetails(customerId);
			     	
			     	if(bookdtlList != null && bookdtlList.size() != 0)
			     	{
			     		System.out.println("Booklist size: " + bookdtlList.size());
			     		%>
    						<form name="bookDetails">
				    
						     <table>
						     	<tr>
						     		<th>Booking Id</th>
						     		<th>Booking No</th>
						     		<th>TravelerCount</th>
						     		<th>Package Name</th>
						     		<th>Package Desc</th>
						     		<th>Package Start Date</th>
						     		<th>Package End Date</th>
						     		<th>Package Base Price</th>
						     		<th>Trip Itineray No</th>
						     		<th>Trip Start Date</th>
						     		<th>Trip End Date</th>
						     		<th>Description</th>
						     		<th>Destination</th>
						     		<th>Base Price</th>
						     		<th>TripTypeName</th>
						     	</tr>
    		
    		<%
    				try
    					{
				     	for(Booking bookdtl : bookdtlList)
				     	{
				     		int packageId = bookdtl.getPackageId();
				     		int bookingId = bookdtl.getBookingId();
				     		String tripTypeId = bookdtl.getTripTypeId();
				     		if(packageId != 0)
				     		{
				     		Package pkgDtl = DbManager.getPackageDetails(packageId);
				     		
							BookingDetail tripDetails = DbManager.getTripDetails(bookingId);
							
							String tripName = DbManager.getTripName(tripTypeId);
   			 %>
				   			 
						    	<tr>
						    		
						    		<td><%=bookdtl.getBookingId() != 0 ? bookdtl.getBookingId() : 0 %></td>
						    		<td><%=bookdtl.getBookingNo() != null ? bookdtl.getBookingNo() : "" %></td>
						    		<td><%=bookdtl.getTravelerCount() != 0 ? bookdtl.getTravelerCount() : 0 %></td>
						    		<%if(pkgDtl != null) 
						    			{%>
						    		<td><%=pkgDtl.getPkgName() != null ? pkgDtl.getPkgName() : "" %></td>
						    		<td><%=pkgDtl.getPkgDesc() != null ? pkgDtl.getPkgDesc() : "" %></td>
						    		<td><%=pkgDtl.getPkgStartDate() != null ? pkgDtl.getPkgStartDate() : "" %></td>
						    		<td><%=pkgDtl.getPkgEndDate() != null ? pkgDtl.getPkgEndDate() : "" %></td>
						    		<td><%=pkgDtl.getPkgBasePrice() != 0 ? pkgDtl.getPkgBasePrice() : 0 %></td>
						    		<td><%=tripDetails.getItineraryNo() !=0 ? tripDetails.getItineraryNo() : 0 %></td>
						    		<td><%=tripDetails.getTripStart() != null ? tripDetails.getTripStart() : "" %></td>
						    		<td><%=tripDetails.getTripEnd() != null ? tripDetails.getTripEnd() : "" %></td>
						    		<td><%=tripDetails.getDescription() != null ? tripDetails.getDescription() : "" %></td>
						    		<td><%=tripDetails.getDestination() != null ? tripDetails.getDestination() : "" %></td>
						    		<td><%=tripDetails.getBasePrice() != 0 ? tripDetails.getBasePrice() : 0 %></td>
						    		<td><%=tripName != null ? tripName : "" %></td>
						    		<%} %>
						    	</tr>
				<%			
				     		}
		   		 		}
		   		 		
		   		 		}catch(Exception e){
		   		 			e.printStackTrace();
		   		 		}%>
						    </table>
						    <br/><br/>
						    </form>
		    
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
              </div>
          </div>
</body>
</html>