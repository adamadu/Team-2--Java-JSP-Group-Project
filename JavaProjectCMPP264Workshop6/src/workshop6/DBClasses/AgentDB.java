package workshop6.DBClasses;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import workshop6.Entity.Agent;

public class AgentDB {
                
                //used to populate combobox with agent ID
                public static Vector GetAgentIds() {
                    //declare vector to hold the agent Id's
                    Vector agentids = new Vector();
                    try
                    (
                        //connect to database
                        Connection conn = DatabaseConnection.getConnection();
                        //select statement
                        PreparedStatement preStatement =
                                        conn.prepareStatement("SELECT AgentId FROM agents");)
                    {

                    ResultSet rset;

                    rset = preStatement.executeQuery();

                    while (rset.next()) {
                        agentids.add(rset.getString("agentid"));
                    } 

                    } catch (SQLException e) {
                                            System.err.println(e);
                                            return null;
                    }
                    return agentids;
                }
		//method to get all the agents from the database
		public static Vector<Agent> GetAgents(int agencyId){
			//declare the vector to hold all the agent objects
			Vector<Agent> agents = new Vector<Agent>();
			try 
			(
					//connect to the database
					Connection conn = DatabaseConnection.getConnection();
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
					agent.setAgtEmail(rset.getString(6));
					agent.setAgtBusPhone(rset.getString(5));
					agent.setAgtPosition(rset.getString(7));
					agent.setActive(rset.getBoolean(8));
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
						Connection conn = DatabaseConnection.getConnection();
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
						agent.setAgtEmail(rset.getString(6));
						agent.setAgtBusPhone(rset.getString(5));
						agent.setAgtPosition(rset.getString(7));
						agent.setActive(rset.getBoolean(8));
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
					+ "AgtPosition = ?, "
					+ "isActive = ? "
					+ "WHERE AgentId = ?";
			
			try (Connection conn = DatabaseConnection.getConnection();
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
				preStatement.setBoolean(8, newAgent.isActive());
				preStatement.setInt(9, newAgent.getAgentId());
				
				int numRows = preStatement.executeUpdate();
				conn.close();
				
					if(numRows > 0){
					return true;
					}
					else{
					return false;
					}
					
				} catch (SQLException e) {
					System.err.println(e);
					return false;
				}

		}
		
		//method to add agents to the database
		public static boolean AddAgent(Agent agent){
			
			//create the sql statement
			String sql = "INSERT Into agents (AgentId, AgtFirstName, "
					+ "AgtMiddleInitial, AgtLastName, AgtBusPhone, "
					+ "AgtEmail, AgtPosition, AgencyId, isActive) "
					+ "Values(?,?, ?, ?," //id, firstname, lastname, initial
					+ "?,?," //phone, email
					+ "?, ?, ?)";//position, agency, isactive
			
			try (Connection conn = DatabaseConnection.getConnection();
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
				preStatement.setBoolean(9, agent.isActive());
				
				preStatement.executeUpdate();
				return true;
				
			} catch (SQLException e) {
				System.err.println(e);
				return false;
			} 

			
		}

}
