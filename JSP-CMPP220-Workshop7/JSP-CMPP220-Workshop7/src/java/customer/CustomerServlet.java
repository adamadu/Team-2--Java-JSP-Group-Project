/*
Author : Geetha Muniswamy
Date: September 29, 2015
File: Customer Servlet to handle the form inputs
*/
package customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class CustomerServlet
 */
@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//doGet(request, response);
		PrintWriter out = response.getWriter();
		String hdnParam = request.getParameter("pagename");
		System.out.println("hdnParam : " + hdnParam);
		if(hdnParam.equals("login"))
		{
			String username = request.getParameter("txtUserName");
			String password = request.getParameter("txtPassword");
			
			Customer cust = new Customer();
			cust.setUserName(username);
			cust.setPassword(password);
			System.out.println("Customer username : " + cust.getUserName());
			System.out.println("Customer password : " + cust.getPassword());
			try
			{
				/*Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelexperts", "root", "");
				PreparedStatement stmt = conn.prepareStatement("SELECT * from customers where UserName=? AND Password=?");
				stmt.setString(1, username);
				stmt.setString(2, password);
				ResultSet rs = stmt.executeQuery();
				if(rs.next() && rs.getString("Password").equals(password) && rs.getString("UserName").equals(username)) 
				{
					System.out.println("Customer name : " + rs.getString("CustFirstName"));
					conn.close();
					request.getSession().setAttribute("loginStatus", "true");
					response.sendRedirect("viewCustDetail.jsp");
				}*/
				
				boolean checkUser = DbManager.getUserCredential(cust);
				if(checkUser)
				{
					System.out.println("Valid customer");
					request.getSession().setAttribute("loginStatus", "true");
					request.getSession().setAttribute("CustomerId", cust.getCustomerId());
					System.out.println("CustomerId : " + cust.getCustomerId());
					response.sendRedirect("viewCustDetail.jsp");
				}
				else
				{
				
					String message = "User ID or Password is incorrect. Try again.";
					response.sendRedirect("login.jsp?message=" + message);
					out.print(message);
				}
				
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}

}
