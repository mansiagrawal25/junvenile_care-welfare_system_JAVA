/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.AdminWorkArea;

import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Job.Job;
import Business.Organization.AdminOrganization;
import Business.Organization.ManagerOrganization;
import Business.Organization.Organization;
import Business.Organization.VolunteerOrganization;
import Business.UserAccount.*;
import Business.WorkQueue.JobWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mansiagrawal
 */
public class ManageJobApplicationsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageJobApplicationsJPanel
     */
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private EcoSystem system;
    private UserAccount userAccount;

    public ManageJobApplicationsJPanel(JPanel userProcessContainer, Enterprise enterprise, EcoSystem system, UserAccount userAccount) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.enterprise = enterprise;
        this.system = system;
        this.userAccount = userAccount;
        populateTable();
    }

    public void populateTable() {

        DefaultTableModel dtm = (DefaultTableModel) tblJobWorkRequest.getModel();
        dtm.setRowCount(0);

        for (Organization organization : enterprise.getOrganizationDirectory().getOrganizationList()) {
            if (organization instanceof AdminOrganization) {
                for (WorkRequest workRequest : organization.getWorkQueue().getWorkRequestList()) {

                    if (workRequest instanceof JobWorkRequest
                            && !workRequest.getStatus().equals("Accepted")
                            && !workRequest.getStatus().equals("Rejected")) {
                        Object row[] = new Object[4];
                        row[0] = workRequest.getSender();
                        row[1] = workRequest.getReceiver();
                        row[2] = workRequest;
                        row[3] = ((JobWorkRequest) workRequest).getJob();
                        dtm.addRow(row);
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
        tblJobWorkRequest = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        btnAccept = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        lblHeader = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));
        setMaximumSize(new java.awt.Dimension(700, 700));
        setMinimumSize(new java.awt.Dimension(700, 700));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblJobWorkRequest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sender", "Receiver", "Status", "Job Title"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblJobWorkRequest.setMinimumSize(new java.awt.Dimension(375, 0));
        tblJobWorkRequest.getTableHeader().setReorderingAllowed(false);
        tblScrollPane.setViewportView(tblJobWorkRequest);

        add(tblScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(102, 100, 480, 178));

        btnDelete.setText("Reject");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(485, 310, 100, -1));

        btnAccept.setText("Accept");
        btnAccept.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptActionPerformed(evt);
            }
        });
        add(btnAccept, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 310, 100, -1));

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 650, -1, -1));

        lblHeader.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader.setText("Manage Job Application");
        add(lblHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 290, 26));
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblJobWorkRequest.getSelectedRow();
        if (selectedRow >= 0) {
            int dialogResult = JOptionPane.showConfirmDialog(this, "Are you sure you want to reject the application?", "Warning", JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION) {
                WorkRequest workRequest = (WorkRequest) tblJobWorkRequest.getValueAt(selectedRow, 2);
                workRequest.setStatus("Rejected");
                workRequest.setReceiver(userAccount);
                populateTable();
                JOptionPane.showMessageDialog(null, "Job application deleted successfully", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptActionPerformed
        // TODO add your handling code here:

        int selectedRow = tblJobWorkRequest.getSelectedRow();
        if (selectedRow >= 0) {
            int dialogResult = JOptionPane.showConfirmDialog(this, "Are you sure you want to accept the applicant?", "Warning", JOptionPane.YES_NO_OPTION);
            if (dialogResult == JOptionPane.YES_OPTION) {
                Job job = (Job) tblJobWorkRequest.getValueAt(selectedRow, 3);
                UserAccount ua = (UserAccount) tblJobWorkRequest.getValueAt(selectedRow, 0);
                WorkRequest workRequest = (WorkRequest) tblJobWorkRequest.getValueAt(selectedRow, 2);
                for (Organization org : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    if (org instanceof ManagerOrganization && job.getName().equalsIgnoreCase("manager")) {

                        if (org.getEmployeeDirectory().getEmployeeList().size() == 1) {
                            JOptionPane.showMessageDialog(null, "Manager already exists", "Information", JOptionPane.INFORMATION_MESSAGE);
                            workRequest.setStatus("Rejected");
                            workRequest.setReceiver(userAccount);
                            populateTable();
                            return;
                        }

                        Employee employee = enterprise.getEmployeeDirectory().createEmployee(ua.getApplicant().getName());
                        org.getEmployeeDirectory().createEmployee(ua.getApplicant().getName());
                        enterprise.getEmployeeDirectory().getEmployeeList().add(employee);
                        enterprise.getJobDirectory().removeJob(job);
                        system.getJobDirectory().removeJob(job);

                        break;
                    } else if (org instanceof VolunteerOrganization && job.getName().equalsIgnoreCase("volunteer")) {
                        Employee employee = enterprise.getEmployeeDirectory().createEmployee(ua.getApplicant().getName());
                        org.getEmployeeDirectory().createEmployee(ua.getApplicant().getName());
                        enterprise.getEmployeeDirectory().getEmployeeList().add(employee);
                        break;
                    }
                }

                workRequest.setStatus("Accepted");
                workRequest.setReceiver(userAccount);

                populateTable();
                JOptionPane.showMessageDialog(null, "Employee created successfully", "Warning", JOptionPane.WARNING_MESSAGE);

            }

        } else {
            JOptionPane.showMessageDialog(null, "Please select a row", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAcceptActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccept;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JTable tblJobWorkRequest;
    private javax.swing.JScrollPane tblScrollPane;
    // End of variables declaration//GEN-END:variables
}
