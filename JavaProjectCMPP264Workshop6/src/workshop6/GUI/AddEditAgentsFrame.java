/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop6.GUI;

import java.util.Vector;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import workshop6.DBClasses.AgentDB;
import workshop6.DBClasses.CustomerDB;
import workshop6.Entity.Agent;
import workshop6.Entity.Customer;
import workshop6.utils.Validator;

/**
 * All code here except the adding and removing of the customers for the agents was done by Max 
 * 
 */
public class AddEditAgentsFrame extends javax.swing.JInternalFrame {

    
    private ComboBoxModel cbAgencyModel;
    public static boolean addEditAgent;
    Agent editAgt;
    /**
     * Creates new form AddEditAgentsFrame
     */
    public AddEditAgentsFrame() {
        initComponents();
        initAgencyCombo(cmbAddEditAgencyId);
        if (addEditAgent == true)
        {
            lblAddEditAgents.setText("Add an Agent");
            btnReassignCustomers.setVisible(false);
            this.setTitle("Add an Agent");
        }
        if (addEditAgent == false)
        {
            
            
            editAgt = new Agent();
            //editAgt = AgentDB.GetAgentById(Main.cmbAgentId.getSelectedItem().toString());
            editAgt = AgentDB.GetAgentById(AgentMainFrame.cmbAgentId.getSelectedItem().toString());
            this.setTitle("Currently Editing Agent ID: " + editAgt.getAgentId());
            lblAddEditAgents.setText("Currently editing Agent ID: " + editAgt.getAgentId());
            cmbAddEditAgencyId.setSelectedItem(editAgt.getAgencyId());
                if (editAgt.isActive() == true)
                {
                    rbAddEditActive.setSelected(true);
                    rbAddEditInactive.setSelected(false);
                }
                if (editAgt.isActive() == false)
                {
                    rbAddEditActive.setSelected(false);
                    rbAddEditInactive.setSelected(true);
                }
                txtAddEditAgtBusPhone.setText(editAgt.getAgtBusPhone());
                txtAddEditAgtEmail.setText(editAgt.getAgtEmail());
                txtAddEditAgtFirstName.setText(editAgt.getAgtFirstName());
                txtAddEditAgtLastName.setText(editAgt.getAgtLastName());
                txtAddEditAgtMiddleInitial.setText(editAgt.getAgtMiddleInitial());
                txtAddEditAgtPosition.setText(editAgt.getAgtPosition());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngrpAgentStatus = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtAddEditAgtBusPhone = new javax.swing.JTextField();
        txtAddEditAgtEmail = new javax.swing.JTextField();
        txtAddEditAgtFirstName = new javax.swing.JTextField();
        txtAddEditAgtLastName = new javax.swing.JTextField();
        txtAddEditAgtMiddleInitial = new javax.swing.JTextField();
        txtAddEditAgtPosition = new javax.swing.JTextField();
        btnUpdateAgents = new javax.swing.JButton();
        btnExitAgents = new javax.swing.JButton();
        rbAddEditActive = new javax.swing.JRadioButton();
        rbAddEditInactive = new javax.swing.JRadioButton();
        cmbAddEditAgencyId = new javax.swing.JComboBox();
        lblAddEditAgents = new javax.swing.JLabel();
        btnReassignCustomers = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);

        jLabel3.setText("Agency ID");

        jLabel4.setText("Agent Email");

        jLabel5.setText("Agent Business Phone");

        jLabel6.setText("Agent First Name");

        jLabel7.setText("Agent Last Name");

        jLabel8.setText("Agent Middle Initial");

        jLabel9.setText("Agent Position");

        jLabel10.setText("Agent Status");

        txtAddEditAgtBusPhone.setName("Agent Business Phone"); // NOI18N

        txtAddEditAgtEmail.setName("Agent Email"); // NOI18N

        txtAddEditAgtFirstName.setName("Agent First Name"); // NOI18N

        txtAddEditAgtLastName.setName("Agent Last Name"); // NOI18N

        txtAddEditAgtMiddleInitial.setName("Agent middle Initial"); // NOI18N

        txtAddEditAgtPosition.setName("Agent Position"); // NOI18N

        btnUpdateAgents.setText("Update");
        btnUpdateAgents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateAgentsActionPerformed(evt);
            }
        });

        btnExitAgents.setText("Exit");
        btnExitAgents.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitAgentsActionPerformed(evt);
            }
        });

        btngrpAgentStatus.add(rbAddEditActive);
        rbAddEditActive.setText("Active");

        btngrpAgentStatus.add(rbAddEditInactive);
        rbAddEditInactive.setText("Inactive");

        cmbAddEditAgencyId.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbAddEditAgencyId.setSelectedIndex(-1);
        cmbAddEditAgencyId.setName("Agency ID"); // NOI18N
        cmbAddEditAgencyId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAddEditAgencyIdActionPerformed(evt);
            }
        });

        lblAddEditAgents.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblAddEditAgents.setText("Dynamic Title");

        btnReassignCustomers.setText("Reassign Customers");
        btnReassignCustomers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReassignCustomersActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(btnReassignCustomers, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(112, 112, 112)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtAddEditAgtPosition, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnUpdateAgents)
                                .addGap(18, 18, 18)
                                .addComponent(btnExitAgents)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtAddEditAgtLastName)
                                        .addComponent(txtAddEditAgtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtAddEditAgtMiddleInitial, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtAddEditAgtEmail)
                                        .addComponent(txtAddEditAgtBusPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(41, 41, 41))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(rbAddEditActive)
                .addGap(18, 18, 18)
                .addComponent(rbAddEditInactive)
                .addGap(49, 49, 49))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblAddEditAgents)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbAddEditAgencyId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(105, 105, 105))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lblAddEditAgents)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbAddEditAgencyId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtAddEditAgtBusPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtAddEditAgtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtAddEditAgtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtAddEditAgtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtAddEditAgtMiddleInitial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAddEditAgtPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rbAddEditActive)
                        .addComponent(rbAddEditInactive)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnExitAgents)
                    .addComponent(btnUpdateAgents)
                    .addComponent(btnReassignCustomers))
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void initAgencyCombo(JComboBox cmbAgencyId)
    {
        cbAgencyModel = new DefaultComboBoxModel(AgentDB.GetAgencyIds());
        cmbAgencyId.setModel(cbAgencyModel);     
    }
    
      private boolean AllFieldsValid()
    {
        return Validator.hasTextOrIsSelected(cmbAddEditAgencyId) 
            && Validator.hasTextOrIsSelected(txtAddEditAgtBusPhone)
                
            && Validator.hasTextOrIsSelected(txtAddEditAgtEmail)
            && Validator.isValidEmail(txtAddEditAgtEmail.getText())
                
            && Validator.hasTextOrIsSelected(txtAddEditAgtFirstName)
            && Validator.hasTextOrIsSelected(txtAddEditAgtLastName)
            && Validator.checkNotMoreThanMaxAllow(txtAddEditAgtMiddleInitial, 5)
            && Validator.hasTextOrIsSelected(txtAddEditAgtPosition)
            && Validator.hasTextOrIsSelected(btngrpAgentStatus);
    }
    

    private void btnUpdateAgentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateAgentsActionPerformed
        if(AllFieldsValid())
        {
            if (addEditAgent == true)
            {
                System.out.println("Doing steps for Add Agent");
                Agent addAgent = new Agent();
                addAgent.setAgencyId(Integer.parseInt(cmbAddEditAgencyId.getSelectedItem().toString()));
                addAgent.setAgtBusPhone(txtAddEditAgtBusPhone.getText());
                addAgent.setAgtEmail(txtAddEditAgtEmail.getText());
                addAgent.setAgtFirstName(txtAddEditAgtFirstName.getText());
                addAgent.setAgtLastName(txtAddEditAgtLastName.getText());
                addAgent.setAgtMiddleInitial(txtAddEditAgtMiddleInitial.getText());
                addAgent.setAgtPosition(txtAddEditAgtPosition.getText());
                if (rbAddEditActive.isSelected())
                {
                    addAgent.setActive(true);
                }
                else if (rbAddEditActive.isSelected())
                {
                    addAgent.setActive(false);
                }
                if(AgentDB.AddAgent(addAgent))
                {
                    //AgentDB.AddAgent(addAgent);
                    JOptionPane.showMessageDialog(null, "Agent has been successfully added!");
                    txtAddEditAgtBusPhone.setText("");
                    txtAddEditAgtEmail.setText("");
                    txtAddEditAgtFirstName.setText("");
                    txtAddEditAgtLastName.setText("");
                    txtAddEditAgtMiddleInitial.setText("");
                    txtAddEditAgtPosition.setText("");
                    AgentMainFrame.UpdateAgentsList();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Agent has not been added!");
                }
            }
            else if (addEditAgent == false)
            {
                System.out.println("Doing steps for UPDATE Agent");
                Agent editAgent = new Agent();
                editAgent.setAgentId(editAgt.getAgentId());
                editAgent.setAgencyId(Integer.parseInt(cmbAddEditAgencyId.getSelectedItem().toString()));
                editAgent.setAgtBusPhone(txtAddEditAgtBusPhone.getText());
                editAgent.setAgtEmail(txtAddEditAgtEmail.getText());
                editAgent.setAgtFirstName(txtAddEditAgtFirstName.getText());
                editAgent.setAgtLastName(txtAddEditAgtLastName.getText());
                editAgent.setAgtMiddleInitial(txtAddEditAgtMiddleInitial.getText());
                editAgent.setAgtPosition(txtAddEditAgtPosition.getText());
                if (rbAddEditActive.isSelected())
                {
                    editAgent.setActive(true);
                }
                else if (rbAddEditActive.isSelected())
                {
                    editAgent.setActive(false);
                }
                
                 //Darya: chekcing if we have an inactive agent with customers
                if (!editAgent.isActive() == true && agentHasCustomers(editAgent.getAgentId()))
                {
                    displayReassignmentDialog(editAgent.getAgentId());
                }
                else
                {
                    if (AgentDB.UpdateAgent(editAgent) != false)
                    {
                        AgentMainFrame.UpdateAgentsList();
                        JOptionPane.showMessageDialog(null, "Agent has been edited successfully!");
                    }
                }               
            }

        }
    }//GEN-LAST:event_btnUpdateAgentsActionPerformed

    //Darya: method to check if agent has any customers
    public static boolean agentHasCustomers(int agentId)
    {
        Vector<Customer> customers = new Vector<Customer>();
        customers = CustomerDB.GetCustomersByAgentId(agentId);
        if(!customers.isEmpty())
            return true;
        else
            return false;
    }
    
    //Darya: this method is work in progress
    private void displayReassignmentDialog(int agentId){
        
            int response = JOptionPane.showConfirmDialog(null, "You must re-assign this agent's customers if you wish to make this agent inactive", "Agent is Inactive",
	    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
	    if (response == JOptionPane.NO_OPTION) {
	      //System.out.println("No button clicked");
                //close dialog window
	    } else if (response == JOptionPane.YES_OPTION) {
              //open the ReassignCustomers form and pass in the agentId parameter
                if(!Main.checkIfFrameAlreadyOpen(ReassignCustomersForm.class))
                {
                    ReassignCustomersForm  reassignCustomersForm = new  ReassignCustomersForm(agentId);
                    getDesktopPane().add(reassignCustomersForm);
                    reassignCustomersForm.setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "You are currently already editing customers for an agent. Please close this window to open another editor.");
                }
              
	    } else if (response == JOptionPane.CLOSED_OPTION) {
	      //System.out.println("JOptionPane closed");
	    }
    }
    
    private void btnExitAgentsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitAgentsActionPerformed
        dispose();
    }//GEN-LAST:event_btnExitAgentsActionPerformed

    private void cmbAddEditAgencyIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAddEditAgencyIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbAddEditAgencyIdActionPerformed

    private void btnReassignCustomersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReassignCustomersActionPerformed
        if(!Main.checkIfFrameAlreadyOpen(ReassignCustomersForm.class))
        {
            ReassignCustomersForm  reassignCustomersForm = new  ReassignCustomersForm(editAgt.getAgentId());
            getDesktopPane().add(reassignCustomersForm);
            reassignCustomersForm.setVisible(true);
        }
    }//GEN-LAST:event_btnReassignCustomersActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExitAgents;
    private javax.swing.JButton btnReassignCustomers;
    private javax.swing.JButton btnUpdateAgents;
    private javax.swing.ButtonGroup btngrpAgentStatus;
    private javax.swing.JComboBox cmbAddEditAgencyId;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAddEditAgents;
    private javax.swing.JRadioButton rbAddEditActive;
    private javax.swing.JRadioButton rbAddEditInactive;
    private javax.swing.JTextField txtAddEditAgtBusPhone;
    private javax.swing.JTextField txtAddEditAgtEmail;
    private javax.swing.JTextField txtAddEditAgtFirstName;
    private javax.swing.JTextField txtAddEditAgtLastName;
    private javax.swing.JTextField txtAddEditAgtMiddleInitial;
    private javax.swing.JTextField txtAddEditAgtPosition;
    // End of variables declaration//GEN-END:variables
}
