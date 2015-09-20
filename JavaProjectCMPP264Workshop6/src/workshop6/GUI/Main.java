package workshop6.GUI;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import workshop6.DBClasses.AgentDB;
import workshop6.DBClasses.PackageDB;
import workshop6.Entity.Agent;
import workshop6.Entity.Package;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 692496
 */
public class Main extends javax.swing.JFrame {
    
    private ComboBoxModel cbAgentIdModel;
    private ComboBoxModel cbPackageIdModel;
    public Package pkg;
    public Package modPkg;
    public Agent agt;

    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        initPackageIdCombo(cmbPackageId);
        initAgentIdCombo(cmbAgentId);
    }

    //Method to retrieve package details from Add or Edit package frame
    public void postData(Package modPkg)
    {    
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //this.cmbPackageId.setSelectedIndex(modPkg.getPackageId());
        this.txtPkgName.setText(modPkg.getPkgName());
        this.txtPkgDescription.setText(modPkg.getPkgDesc());
        this.txtPkgStartDate.setText(sdf.format(modPkg.getPkgStartDate()));
        this.txtPkgEndDate.setText(sdf.format(modPkg.getPkgEndDate()));
        this.txtPkgAgencyCommission.setText(Double.toString(modPkg.getPkgAgencyCommission()));
        this.txtPkgBasePrice.setText(Double.toString(modPkg.getPkgBasePrice()));      
        //cmbPackageId.removeAllItems();
        //initPackageIdCombo(cmbPackageId);
        pkg = modPkg;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        btngrpAgentStatus = new javax.swing.ButtonGroup();
        pnMain = new javax.swing.JTabbedPane();
        agentMaintainPanel = new javax.swing.JPanel();
        agentFieldPanel = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        cmbAgentId = new javax.swing.JComboBox();
        txtAgencyId = new javax.swing.JTextField();
        txtAgentBusPhone = new javax.swing.JTextField();
        txtAgentFirstName = new javax.swing.JTextField();
        txtAgentLastName = new javax.swing.JTextField();
        txtAgentMiddleInitial = new javax.swing.JTextField();
        txtAgentPosition = new javax.swing.JTextField();
        rbActive = new javax.swing.JRadioButton();
        rbInactive = new javax.swing.JRadioButton();
        txtAgentEmail = new javax.swing.JTextField();
        btnEditAgent = new javax.swing.JButton();
        btnAddAgent = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        cmbPackageId = new javax.swing.JComboBox();
        txtPkgName = new javax.swing.JTextField();
        txtPkgAgencyCommission = new javax.swing.JTextField();
        txtPkgBasePrice = new javax.swing.JTextField();
        txtPkgDescription = new javax.swing.JTextField();
        btnAddPackages = new javax.swing.JButton();
        btnEditPackages = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listProducts = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        listSuppliers = new javax.swing.JList();
        txtPkgStartDate = new javax.swing.JTextField();
        txtPkgEndDate = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnMain.setName("Agents"); // NOI18N

        agentFieldPanel.setLayout(new java.awt.GridBagLayout());

        jLabel14.setText("Agent ID");
        jLabel14.setName(""); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 34;
        gridBagConstraints.insets = new java.awt.Insets(22, 0, 0, 0);
        agentFieldPanel.add(jLabel14, gridBagConstraints);

        jLabel18.setText("Agency ID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 34;
        gridBagConstraints.insets = new java.awt.Insets(22, 0, 0, 0);
        agentFieldPanel.add(jLabel18, gridBagConstraints);

        jLabel19.setText("Agent Email");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 34;
        gridBagConstraints.insets = new java.awt.Insets(22, 0, 0, 0);
        agentFieldPanel.add(jLabel19, gridBagConstraints);

        jLabel20.setText("Agent Business Phone");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 34;
        gridBagConstraints.insets = new java.awt.Insets(22, 0, 0, 0);
        agentFieldPanel.add(jLabel20, gridBagConstraints);

        jLabel21.setText("Agent First Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 34;
        gridBagConstraints.insets = new java.awt.Insets(22, 0, 0, 0);
        agentFieldPanel.add(jLabel21, gridBagConstraints);

        jLabel22.setText("Agent Last Name");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 34;
        gridBagConstraints.insets = new java.awt.Insets(22, 0, 0, 0);
        agentFieldPanel.add(jLabel22, gridBagConstraints);

        jLabel23.setText("Agent Middle Initial");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 34;
        gridBagConstraints.insets = new java.awt.Insets(22, 0, 0, 0);
        agentFieldPanel.add(jLabel23, gridBagConstraints);

        jLabel24.setText("Agent Position");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 34;
        gridBagConstraints.insets = new java.awt.Insets(22, 0, 0, 0);
        agentFieldPanel.add(jLabel24, gridBagConstraints);

        jLabel25.setText("Agent Status");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 34;
        gridBagConstraints.insets = new java.awt.Insets(22, 0, 0, 0);
        agentFieldPanel.add(jLabel25, gridBagConstraints);

        cmbAgentId.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbAgentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAgentIdActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 61;
        gridBagConstraints.insets = new java.awt.Insets(22, 0, 0, 0);
        agentFieldPanel.add(cmbAgentId, gridBagConstraints);

        txtAgencyId.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 61;
        gridBagConstraints.insets = new java.awt.Insets(22, 0, 0, 0);
        agentFieldPanel.add(txtAgencyId, gridBagConstraints);

        txtAgentBusPhone.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 61;
        gridBagConstraints.insets = new java.awt.Insets(22, 0, 0, 0);
        agentFieldPanel.add(txtAgentBusPhone, gridBagConstraints);

        txtAgentFirstName.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 61;
        gridBagConstraints.insets = new java.awt.Insets(22, 0, 0, 0);
        agentFieldPanel.add(txtAgentFirstName, gridBagConstraints);

        txtAgentLastName.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 61;
        gridBagConstraints.insets = new java.awt.Insets(22, 0, 0, 0);
        agentFieldPanel.add(txtAgentLastName, gridBagConstraints);

        txtAgentMiddleInitial.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 61;
        gridBagConstraints.insets = new java.awt.Insets(22, 0, 0, 0);
        agentFieldPanel.add(txtAgentMiddleInitial, gridBagConstraints);

        txtAgentPosition.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 61;
        gridBagConstraints.insets = new java.awt.Insets(22, 0, 0, 0);
        agentFieldPanel.add(txtAgentPosition, gridBagConstraints);

        btngrpAgentStatus.add(rbActive);
        rbActive.setText("Active");
        rbActive.setEnabled(false);
        rbActive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbActiveActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 61;
        gridBagConstraints.insets = new java.awt.Insets(22, 0, 0, 0);
        agentFieldPanel.add(rbActive, gridBagConstraints);

        btngrpAgentStatus.add(rbInactive);
        rbInactive.setText("Inactive");
        rbInactive.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 61;
        gridBagConstraints.insets = new java.awt.Insets(22, 0, 0, 1);
        agentFieldPanel.add(rbInactive, gridBagConstraints);

        txtAgentEmail.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 61;
        gridBagConstraints.insets = new java.awt.Insets(22, 0, 0, 0);
        agentFieldPanel.add(txtAgentEmail, gridBagConstraints);

        btnEditAgent.setText("Edit");

        btnAddAgent.setText("Add");

        javax.swing.GroupLayout agentMaintainPanelLayout = new javax.swing.GroupLayout(agentMaintainPanel);
        agentMaintainPanel.setLayout(agentMaintainPanelLayout);
        agentMaintainPanelLayout.setHorizontalGroup(
            agentMaintainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(agentMaintainPanelLayout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(btnAddAgent, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92)
                .addComponent(btnEditAgent, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, agentMaintainPanelLayout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(agentFieldPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        agentMaintainPanelLayout.setVerticalGroup(
            agentMaintainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(agentMaintainPanelLayout.createSequentialGroup()
                .addComponent(agentFieldPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(agentMaintainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditAgent)
                    .addComponent(btnAddAgent))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pnMain.addTab("Agent Maintain", agentMaintainPanel);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Package ID");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(38, 50, -1, -1));

        jLabel11.setText("Package Name");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 90, -1, -1));

        jLabel12.setText("Package Base Price");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        jLabel13.setText("Package Start Date");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 165, -1, -1));

        jLabel15.setText("Package End Date");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        jLabel16.setText("Package Agency Commission");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, -1));

        jLabel17.setText("Package Description");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 125, -1, -1));

        cmbPackageId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPackageIdActionPerformed(evt);
            }
        });
        jPanel2.add(cmbPackageId, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 47, 178, -1));

        txtPkgName.setEnabled(false);
        jPanel2.add(txtPkgName, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 87, 241, -1));

        txtPkgAgencyCommission.setEnabled(false);
        jPanel2.add(txtPkgAgencyCommission, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, 155, -1));

        txtPkgBasePrice.setEnabled(false);
        jPanel2.add(txtPkgBasePrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 155, -1));

        txtPkgDescription.setEnabled(false);
        jPanel2.add(txtPkgDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 120, 233, -1));

        btnAddPackages.setText("Add");
        btnAddPackages.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPackagesActionPerformed(evt);
            }
        });
        jPanel2.add(btnAddPackages, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 310, -1, -1));

        btnEditPackages.setText("Edit");
        btnEditPackages.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditPackagesActionPerformed(evt);
            }
        });
        jPanel2.add(btnEditPackages, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, -1, -1));

        listProducts.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listProducts);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 339, 170, 197));

        listSuppliers.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(listSuppliers);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(282, 339, 225, 197));

        txtPkgStartDate.setEditable(false);
        txtPkgStartDate.setEnabled(false);
        jPanel2.add(txtPkgStartDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 155, -1));

        txtPkgEndDate.setEditable(false);
        txtPkgEndDate.setEnabled(false);
        jPanel2.add(txtPkgEndDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, 155, -1));

        pnMain.addTab("Packages", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnMain)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnMain, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pnMain.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Geetha - Method to call the edit package frame and edit the existing package
    private void btnEditPackagesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditPackagesActionPerformed
        AddEditPackages addEditPackage = new AddEditPackages(this);
        addEditPackage.addPackages = false;
        addEditPackage.pkg = pkg;
        addEditPackage.setVisible(true);
        addEditPackage.displayPackage(pkg);
    }//GEN-LAST:event_btnEditPackagesActionPerformed

    //Geetha - Method to call Add Package frame to add the new package
    private void btnAddPackagesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPackagesActionPerformed
        AddEditPackages addEditPackage = new AddEditPackages(this);
        addEditPackage.addPackages = true;
        addEditPackage.setVisible(true);
    }//GEN-LAST:event_btnAddPackagesActionPerformed

    private void cmbAgentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAgentIdActionPerformed
        String agentId = (String)cmbAgentId.getSelectedItem();
        agt = AgentDB.GetAgentById(agentId); 
        txtAgentFirstName.setText(agt.getAgtFirstName());
        txtAgentMiddleInitial.setText(agt.getAgtMiddleInitial());
        txtAgentLastName.setText(agt.getAgtLastName());
        txtAgentEmail.setText(agt.getAgtEmail());
        txtAgentBusPhone.setText(agt.getAgtBusPhone());
        txtAgentPosition.setText(agt.getAgtPosition());
        txtAgencyId.setText(Integer.toString(agt.getAgencyId()));
        
        if (agt.isActive() == true)
        {
            rbActive.setSelected(true);
        }
        
        if (!agt.isActive() == true)
        {
            rbInactive.setSelected(true);
        }
    }//GEN-LAST:event_cmbAgentIdActionPerformed

    private void rbActiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbActiveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbActiveActionPerformed

    private void cmbPackageIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPackageIdActionPerformed
        String packageId = (String) cmbPackageId.getSelectedItem();
        pkg = PackageDB.getPackage(packageId);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        currency.setMinimumFractionDigits(2);
        txtPkgName.setText(pkg.getPkgName());
        txtPkgDescription.setText(pkg.getPkgDesc());
        txtPkgStartDate.setText(df.format(pkg.getPkgStartDate()));
        txtPkgEndDate.setText(df.format(pkg.getPkgEndDate()));
        txtPkgBasePrice.setText(currency.format(pkg.getPkgBasePrice()));
        txtPkgAgencyCommission.setText(currency.format(pkg.getPkgAgencyCommission()));
    }//GEN-LAST:event_cmbPackageIdActionPerformed
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
                
            }          
        });
    }
    
    //Geetha - Method to retrieve all packageid from the database and load it in combo box
    private void initPackageIdCombo(JComboBox cmbPackageId)
    {
        cbPackageIdModel = new DefaultComboBoxModel(PackageDB.getPackageIDs());
        cmbPackageId.setModel(cbPackageIdModel);
    }
    
    private void initAgentIdCombo(JComboBox cmbAgentId)
    {
        cbAgentIdModel = new DefaultComboBoxModel(AgentDB.GetAgentIds());
        cmbAgentId.setModel(cbAgentIdModel);     
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel agentFieldPanel;
    private javax.swing.JPanel agentMaintainPanel;
    private javax.swing.JButton btnAddAgent;
    private javax.swing.JButton btnAddPackages;
    private javax.swing.JButton btnEditAgent;
    private javax.swing.JButton btnEditPackages;
    private javax.swing.ButtonGroup btngrpAgentStatus;
    private javax.swing.JComboBox cmbAgentId;
    private javax.swing.JComboBox cmbPackageId;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList listProducts;
    private javax.swing.JList listSuppliers;
    private javax.swing.JTabbedPane pnMain;
    private javax.swing.JRadioButton rbActive;
    private javax.swing.JRadioButton rbInactive;
    private javax.swing.JTextField txtAgencyId;
    private javax.swing.JTextField txtAgentBusPhone;
    private javax.swing.JTextField txtAgentEmail;
    private javax.swing.JTextField txtAgentFirstName;
    private javax.swing.JTextField txtAgentLastName;
    private javax.swing.JTextField txtAgentMiddleInitial;
    private javax.swing.JTextField txtAgentPosition;
    private javax.swing.JTextField txtPkgAgencyCommission;
    private javax.swing.JTextField txtPkgBasePrice;
    private javax.swing.JTextField txtPkgDescription;
    private javax.swing.JTextField txtPkgEndDate;
    private javax.swing.JTextField txtPkgName;
    private javax.swing.JTextField txtPkgStartDate;
    // End of variables declaration//GEN-END:variables
}
