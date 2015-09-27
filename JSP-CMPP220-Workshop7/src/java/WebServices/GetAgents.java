/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WebServices;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Adam
 */
@WebServlet(name = "GetAgents", urlPatterns = {"/GetAgents"})
public class GetAgents extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       PrintWriter out = response.getWriter();
        String selectedAgencyId = request.getParameter("selectedAgencyId");
        //String selectedAgencyId = "1";
        System.out.println("Request agents recieved with agencyid of: " + selectedAgencyId);
        JSONArray agents = new JSONArray();
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travelexperts", "root", "");
               
            
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM agents WHERE AgencyId=" + selectedAgencyId);
            
            while(result.next())
            {
                JSONObject object = new JSONObject();
                object.put("AgentId", result.getInt("AgentId"));
                object.put("AgtFirstName", result.getString("AgtFirstName"));
                object.put("AgtMiddleInitial", result.getString("AgtMiddleInitial"));
                object.put("AgtLastName", result.getString("AgtLastName"));
                object.put("AgtBusPhone", result.getString("AgtBusPhone"));
                object.put("AgtEmail", result.getString("AgtEmail"));
                object.put("AgtPosition", result.getString("AgtPosition"));
                agents.put(object);
            }
            conn.close();
        } 
        catch (ClassNotFoundException ex)
        {
            ex.printStackTrace();
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        catch (JSONException ex)
        {
            ex.printStackTrace();
        }
        if(agents.length() >= 1)
        {
            response.setContentType("application/json");
            out.print(agents);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
