/*
Author: Geetha
Date: Sep 29, 2015
File: Customer Servlet class to handle customer inputs
*/
package customer;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import javax.servlet.RequestDispatcher;
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
        // TODO Auto-generated constructor stub
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
		Customer cust = null;
		if(hdnParam.equals("login"))
		{
			String username = request.getParameter("txtUserName");
			String password = request.getParameter("txtPassword");
			
			cust = new Customer();
			cust.setUserName(username);
			cust.setPassword(password);
			try
			{
				
				boolean checkUser = DbManager.getUserCredential(cust);
				if(checkUser)
				{
					request.getSession().setAttribute("loginStatus", "true");
					request.getSession().setAttribute("CustomerId", cust.getCustomerId());
					response.sendRedirect("bookingDetails.jsp");
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
		else if(hdnParam.equals("editCustDetail"))
		{
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String address = request.getParameter("address");
			String city = request.getParameter("city");
			String province = request.getParameter("province");
			String postal = request.getParameter("postal");
			String country = request.getParameter("country");
			String homephone = request.getParameter("homephone");
			String busphone = request.getParameter("busphone");
			String email = request.getParameter("email");
			int agentId = Integer.parseInt(request.getParameter("agentid"));
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			Customer updateCustomer = new Customer();
			updateCustomer.setCustFirstName(fname);
			updateCustomer.setCustLastName(lname);
			updateCustomer.setCustAddress(address);
			updateCustomer.setCustCity(city);
			updateCustomer.setCustProv(province);
			updateCustomer.setCustPostal(postal);
			updateCustomer.setCustCountry(country);
			updateCustomer.setCustHomePhone(homephone);
			updateCustomer.setCustBusPhone(busphone);
			updateCustomer.setCustEmail(email);
			updateCustomer.setAgentId(agentId);
			updateCustomer.setUserName(username);
			updateCustomer.setPassword(password);
			updateCustomer.setCustomerId((Integer)request.getSession().getAttribute("CustomerId"));
			try
			{
				boolean updateStatus = DbManager.updateCustomer(updateCustomer);
				if(updateStatus)
				{
					response.sendRedirect("viewCustDetail.jsp");
					//RequestDispatcher rd = request.getRequestDispatcher("viewCustDetail.jsp");
					//rd.forward(request, response);
				}
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
			}
		}
	}

}
