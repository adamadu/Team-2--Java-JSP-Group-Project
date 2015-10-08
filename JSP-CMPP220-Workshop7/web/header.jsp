<%-- 
    Document   : header
    Created on : Oct 8, 2015, 2:27:11 PM
    Author     : 450175
--%>

<%
    String logStatus = (String)session.getAttribute("loginStatus");
    if(logStatus != null)
    {
        %>
        <div class="header">
            <div class="container">
                <div class="company_logo">
                    <img src="logo.png">
                </div>
                <div class="header_nav">
                    <ul>
                        <li><a href="index.jsp">HOME</a>  </li>
                        <li><a href="/JSP-CMPP220-Workshop7/PackageServlet">PACKAGES</a>  </li>
                        <li><a href="viewCustDetail.jsp">VIEW ACCOUNT</a>  </li>
                        <li><a href="editCustDetail.jsp">EDIT ACCOUNT</a>  </li>
                        <li><a href="logout.jsp">LOGOUT</a></li>
                    </ul>
                </div>
            </div>
            <div class="clearboth"></div>
        </div>
        <%
    } 
    else
    {
        %>
        <div class="header">
            <div class="container">
                <div class="company_logo">
                    <img src="logo.png">
                </div>
                <div class="header_nav">
                    <ul>
                        <li><a href="index.jsp">HOME</a>  </li>
                        <li><a href="register.jsp">REGISTER</a>  </li>
                        
                        <li><a href="login.jsp">LOGIN</a></li>
                    </ul>
                </div>
            </div>
            <div class="clearboth"></div>
        </div>
        <%
    }
    %>


