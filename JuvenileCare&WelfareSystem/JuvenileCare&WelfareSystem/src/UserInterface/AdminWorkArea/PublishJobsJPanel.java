/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.AdminWorkArea;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Job.Job;
import Business.Job.JobDirectory;
import Business.Network.City;
import Business.Network.Country;
import Business.Network.State;
import Business.UserAccount.*;
import java.awt.CardLayout;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mansiagrawal
 */
public class PublishJobsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form PublishJobsJPanel
     */
    private JPanel userProcessContainer;
    private JobDirectory jobDirectory;
    private UserAccount userAccount;
    private EcoSystem system;

    public PublishJobsJPanel(JPanel userProcessContainer, JobDirectory jobDirectory, UserAccount userAccount, EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.jobDirectory = jobDirectory;
        this.userAccount = userAccount;
        this.system = system;
        populateTable();
    }

    private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) tblJobs.getModel();
        model.setRowCount(0);

        if (jobDirectory != null) {
            for (Job job : jobDirectory.getJobList()) {
                Object[] row = new Object[5];
          

                for (Country c : system.getNetworkList()) {
                    for (State s : c.getStateList()) {
                        for (City city : s.getCityList()) {
                            for (Enterprise e : city.getEnterpriseDirectory().getEnterpriseList()) {
                                for (UserAccount ua : e.getUserAccountDirectory().getUserAccountList()) {
                                    if (userAccount.getUsername().equals(ua.getUsername())) {
                                        if (e.equals(job.getEnterprise())) {
                                            row[0] = c;
                                            row[1] = s;
                                            row[2] = city;
                                            row[3] = job.getEnterprise();
                                            row[4] = job;
                                            model.addRow(row);
                                        }
                                    }
                                }
                            }
                        }
                    }

                }

               
            }
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

        tblScrollPane = new javax.swing.JScrollPane();
        tblJobs = new javax.swing.JTable();
        lblName = new javax.swing.JLabel();
        txtFldName = new javax.swing.JTextField();
        btnSubmit = new javax.swing.JButton();
        btnDeleteJob = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblHeader = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));
        setMaximumSize(new java.awt.Dimension(700, 700));
        setMinimumSize(new java.awt.Dimension(700, 700));
        setPreferredSize(new java.awt.Dimension(700, 700));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblJobs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Country", "State", "City", "NGO", "Job Title"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblJobs.setMinimumSize(new java.awt.Dimension(375, 0));
        tblScrollPane.setViewportView(tblJobs);

        add(tblScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 500, 190));

        lblName.setText("Job Title:");
        add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 390, -1, -1));
        add(txtFldName, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 390, 150, -1));

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        add(btnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 440, -1, -1));

        btnDeleteJob.setText("Delete Job");
        btnDeleteJob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteJobActionPerformed(evt);
            }
        });
        add(btnDeleteJob, new org.netbeans.lib.awtextra.AbsoluteConstraints(447, 310, 120, 30));

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 660, -1, -1));

        lblHeader.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader.setText("Publish Jobs");
        add(lblHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 280, 26));
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
        String name = txtFldName.getText();
        if (!name.equals("")) {

            // validate name
            String regex = "^[a-z A-Z]+$";
            Pattern namePattern = Pattern.compile(regex);
            Matcher nameMatcher = namePattern.matcher(name);

            if (!nameMatcher.matches()) {
                JOptionPane.showMessageDialog(null, "Invalid characters in job title", "Warning", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            if(name.equalsIgnoreCase("Manager") || name.equalsIgnoreCase("Volunteer")){
                 for (Country c : system.getNetworkList()) {
                for (State s : c.getStateList()) {
                    for (City cy : s.getCityList()) {
                        for (Enterprise e : cy.getEnterpriseDirectory().getEnterpriseList()) {
                            for (UserAccount ua : e.getUserAccountDirectory().getUserAccountList()) {
                                if (ua.getUsername().equals(userAccount.getUsername())) {
                                    Job job = jobDirectory.createJob(name);
                                    job.setEnterprise(e);
                                }
                            }
                        }
                    }
                }
            }
            }else{
                 JOptionPane.showMessageDialog(null, "Job can be posted for 'Manager' or 'Volunteer' position only", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
           
            populateTable();
            txtFldName.setText("");
            JOptionPane.showMessageDialog(null, "Job posted successfully", "Info", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Please enter text", "Warning", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnDeleteJobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteJobActionPerformed
        // TODO add your handling code here:

        int selectedRow = tblJobs.getSelectedRow();
        if (selectedRow >= 0) {
            int dialogResult = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete the Job?", "Warning", JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION) {
                Job job = (Job) tblJobs.getValueAt(selectedRow, 4);

                system.getJobDirectory().removeJob(job);
                populateTable();
                JOptionPane.showMessageDialog(null, "Job deleted successfully", "Warning", JOptionPane.WARNING_MESSAGE);

            }

        } else {
            JOptionPane.showMessageDialog(null, "Please select a row", "Warning", JOptionPane.WARNING_MESSAGE);
        }

    }//GEN-LAST:event_btnDeleteJobActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDeleteJob;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblName;
    private javax.swing.JTable tblJobs;
    private javax.swing.JScrollPane tblScrollPane;
    private javax.swing.JTextField txtFldName;
    // End of variables declaration//GEN-END:variables
}
