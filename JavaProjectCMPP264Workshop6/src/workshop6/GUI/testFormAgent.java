package workshop6.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import workshop6.DBClasses.AgentDB;
import workshop6.Entity.Agent;

public class testFormAgent extends JFrame {

	private JPanel contentPane;
	private static JTextField txtAgentId;
	private static JTextField txtFirst;
	private static JTextField txtIni;
	private static JTextField txtLast;
	private static JTextField txtPhone;
	private static JTextField txtEmail;
	private static JTextField txtPos;
	private static JTextField txtAgency;
	private static Agent agent;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testFormAgent frame = new testFormAgent();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public testFormAgent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 498);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAgentid = new JLabel("AgentID");
		lblAgentid.setBounds(43, 46, 89, 16);
		contentPane.add(lblAgentid);
		
		txtAgentId = new JTextField();
		txtAgentId.setBounds(170, 43, 457, 22);
		contentPane.add(txtAgentId);
		txtAgentId.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First name");
		lblFirstName.setBounds(43, 75, 89, 16);
		contentPane.add(lblFirstName);
		
		txtFirst = new JTextField();
		txtFirst.setBounds(170, 72, 457, 22);
		contentPane.add(txtFirst);
		txtFirst.setColumns(10);
		
		JLabel lblInitital = new JLabel("Initital");
		lblInitital.setBounds(43, 104, 89, 16);
		contentPane.add(lblInitital);
		
		txtIni = new JTextField();
		txtIni.setBounds(170, 101, 457, 22);
		contentPane.add(txtIni);
		txtIni.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(43, 133, 89, 16);
		contentPane.add(lblLastName);
		
		txtLast = new JTextField();
		txtLast.setBounds(170, 130, 457, 22);
		contentPane.add(txtLast);
		txtLast.setColumns(10);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(43, 162, 89, 16);
		contentPane.add(lblPhone);
		
		txtPhone = new JTextField();
		txtPhone.setBounds(170, 159, 457, 22);
		contentPane.add(txtPhone);
		txtPhone.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(43, 191, 89, 16);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(170, 188, 457, 22);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblPosition = new JLabel("Position");
		lblPosition.setBounds(43, 220, 89, 16);
		contentPane.add(lblPosition);
		
		txtPos = new JTextField();
		txtPos.setBounds(170, 217, 457, 22);
		contentPane.add(txtPos);
		txtPos.setColumns(10);
		
		JLabel lblAgencyid = new JLabel("AgencyId");
		lblAgencyid.setBounds(43, 249, 89, 16);
		contentPane.add(lblAgencyid);
		
		txtAgency = new JTextField();
		txtAgency.setBounds(170, 246, 457, 22);
		contentPane.add(txtAgency);
		txtAgency.setColumns(10);
		
		JButton btnGetAgent = new JButton("Get Agent");
		btnGetAgent.setBounds(43, 306, 89, 25);
		btnGetAgent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int agentId = Integer.parseInt(txtAgentId.getText());
					agent = AgentDB.GetAgentById(agentId);
					DisplayAgent();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		contentPane.add(btnGetAgent);
		
		JButton btnUpdateAgent = new JButton("Update Agent");
		btnUpdateAgent.setBounds(170, 306, 457, 25);
		btnUpdateAgent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GrabData(agent);
				AgentDB.UpdateAgent(agent);
			}
		});
		contentPane.add(btnUpdateAgent);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(43, 338, 89, 25);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Clear();
			}
		});
		contentPane.add(btnClear);
		
		JButton btnAddAgent = new JButton("Add agent");
		btnAddAgent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Agent addedAgent = new Agent();
				GrabData(addedAgent);
				AgentDB.AddAgent(addedAgent);
			}
		});
		btnAddAgent.setBounds(43, 376, 97, 25);
		contentPane.add(btnAddAgent);
	}
	
	public static void DisplayAgent() throws SQLException{
		/*
		int agentID = Integer.parseInt(txtAgentId.getText());
		Agent agent = new Agent();
		agent = AgentDB.GetAgentById(agentID);*/
		txtFirst.setText(agent.getAgtFirstName());
		txtLast.setText(agent.getAgtLastName());
		txtIni.setText(agent.getAgtMiddleInitial());
		txtPhone.setText(agent.getAgtBusPhone());
		txtEmail.setText(agent.getAgtEmail());
		txtAgency.setText(Integer.toString(agent.getAgencyId()));
		txtPos.setText(agent.getAgtPosition());
		
		
	}
	
	public static void Clear(){
	
		txtFirst.setText("");
		txtLast.setText("");
		txtIni.setText("");
		txtPhone.setText("");
		txtEmail.setText("");
		txtAgency.setText("");
		txtPos.setText("");
		txtAgentId.setText("");
		
	}
	
	public static void GrabData(Agent agent){
		agent.setAgencyId(Integer.parseInt(txtAgency.getText()));
		agent.setAgentId((Integer.parseInt(txtAgentId.getText())));
		agent.setAgtBusPhone(txtPhone.getText());
		agent.setAgtEmail(txtEmail.getText());
		agent.setAgtFirstName(txtFirst.getText());
		agent.setAgtLastName(txtLast.getText());
		agent.setAgtMiddleInitial(txtIni.getText());
		agent.setAgtPosition(txtPos.getText());
	}
}
