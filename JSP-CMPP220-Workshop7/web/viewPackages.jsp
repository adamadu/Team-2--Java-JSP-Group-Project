<%-- 
    Document   : viewPackages
    Created on : Oct 7, 2015, 7:54:44 AM
    Author     : DaryaO
--%>

<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="packages.PackageDB"%>
<%@page import="packages.Package"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Available Travel Packages</title>
    </head>
    <body>
        <table>
            <tr><th>Current Travel Packages</th></tr>
            <%
                
                List<Package> pkgs = new ArrayList<Package>();
                pkgs = PackageDB.listPackages();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                NumberFormat formatter = NumberFormat.getCurrencyInstance();
                for(Package pkg : pkgs){ %>
            <tr>
                <td><%=pkg.getPkgName()%></td>
                <td><%=pkg.getPkgDesc()%></td>
                <td><%=dateFormat.format(pkg.getPkgStartDate())%></td>
                <td><%=dateFormat.format(pkg.getPkgEndDate())%></td>
                <td><%=formatter.format(pkg.getPkgBasePrice())%></td>
            </tr>
                
              <%
                }  
                %>
        </table>
        
    </body>
</html>
