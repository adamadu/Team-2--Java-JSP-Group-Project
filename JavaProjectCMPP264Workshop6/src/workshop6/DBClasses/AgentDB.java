package workshop6.DBClasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class AgentDB {

		//method to get all the agents from the database
		public static Vector<Agent> GetAgents(int agencyId){
			//declare the vector to hold all the agent objects
			Vector<Agent> agents = new Vector<Agent>();
			try 
			(
					//connect to the database
					Connection conn = DatabaseConnection.GetConnection();
					//select statement
					PreparedStatement preStatement =
							conn.prepareStatement("SELECT * FROM agents "
									+ "WHERE AgencyId = ?");)
			{
				ResultSet rset;
				//set the parameter in the statement with the agencyId
				preStatement.setInt(1, agencyId);
				//get the result set
				rset = preStatement.executeQuery();
				while (rset.next()) {
					Agent agent = new Agent();
					//set properties of agent from the result set
					agent.setAgentId(rset.getInt(1));
					agent.setAgtFirstName(rset.getString(2));
					agent.setAgtMiddleInitial(rset.getString(3));
					agent.setAgtLastName(rset.getString(4));
					agent.setAgtEmail(rset.getString(5));
					agent.setAgtBusPhone(rset.getString(6));
					agent.setAgtPosition(rset.getString(7));
					//add the new agent object to the vector
					agents.add(agent);
				}
			
			} catch (SQLException e) {
				System.err.println(e);
				return null;
			}
			
			//for testing
			//agents.forEach(agent -> System.out.println(agent.getAgtFirstName()));
			
			return agents;
		}
		
		//method to get agent by id from the database
		public static Agent GetAgentById(int agentId){
				try 
				(
						//connect to the database
						Connection conn = DatabaseConnection.GetConnection();
						//select statement
						PreparedStatement preStatement =conn.prepareStatement("SELECT * FROM agents "
								+ "WHERE AgentId = ?");)
				{
					ResultSet rset;
					Agent agent = new Agent();
					//set the parameter in the statement with the agencyId
					preStatement.setInt(1, agentId);
					//get the result set
					rset = preStatement.executeQuery();
					if (rset.next()) {
						//set properties of agent from the result set
						agent.setAgentId(rset.getInt(1));
						agent.setAgtFirstName(rset.getString(2));
						agent.setAgtMiddleInitial(rset.getString(3));
						agent.setAgtLastName(rset.getString(4));
						agent.setAgtEmail(rset.getString(5));
						agent.setAgtBusPhone(rset.getString(6));
						agent.setAgtPosition(rset.getString(7));
						rset.close();
						return agent;
					}
					else
					{
						rset.close();
						return null;
					}
					
				} catch (SQLException e) {
					System.err.println(e);
					return null;
				}
		}
		
		//method to update agent data
		public static boolean UpdateAgent(Agent newAgent){
			
			//create the sql statement
			String sql = "UPDATE agents set "
					+ "AgencyId = ?, AgtFirstName = ?, "
					+ "AgtMiddleInitial = ?, AgtLastName = ?, "
					+ "AgtEmail = ?, AgtBusPhone = ?, "
					+ "AgtPosition = ? "
					+ "WHERE AgentId = ?";
			
			try (Connection conn = DatabaseConnection.GetConnection();
					PreparedStatement preStatement = conn.prepareStatement(sql))
				{
				//populate the prepared statement
				preStatement.setInt(1, newAgent.getAgencyId());
				preStatement.setString(2, newAgent.getAgtFirstName());
				preStatement.setString(3, newAgent.getAgtMiddleInitial());
				preStatement.setString(4, newAgent.getAgtLastName());
				preStatement.setString(5, newAgent.getAgtEmail());
				preStatement.setString(6, newAgent.getAgtBusPhone());
				preStatement.setString(7, newAgent.getAgtPosition());
				preStatement.setInt(8, newAgent.getAgentId());
				
				int numRows = preStatement.executeUpdate();
				conn.close();
				
					if(numRows > 0){
					return true;
					}
					else{
					return false;
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return false;
				}

		}
		
		//method to add agents to the database
		public static boolean AddAgent(Agent agent){
			
			//create the sql statement
			String sql = "INSERT Into agents (AgentId, AgtFirstName, "
					+ "AgtMiddleInitial, AgtLastName, AgtBusPhone, "
					+ "AgtEmail, AgtPosition, AgencyId) "
					+ "Values(?,?, ?, ?," //id, firstname, lastname, initial
					+ "?,?," //phone, email
					+ "?, ?)";//position, agency
			
			try (Connection conn = DatabaseConnection.GetConnection();
					PreparedStatement preStatement = conn.prepareStatement(sql))
			{
				//populate the prepared statement
				preStatement.setInt(8, agent.getAgencyId());
				preStatement.setString(2, agent.getAgtFirstName());
				preStatement.setString(3, agent.getAgtMiddleInitial());
				preStatement.setString(4, agent.getAgtLastName());
				preStatement.setString(5, agent.getAgtBusPhone());
				preStatement.setString(6, agent.getAgtEmail());
				preStatement.setString(7, agent.getAgtPosition());
				preStatement.setInt(1, agent.getAgentId());
				
				preStatement.executeUpdate();
				return true;
				
			} catch (SQLException e) {
				System.err.println(e);
				return false;
			} 

			
		}

}
