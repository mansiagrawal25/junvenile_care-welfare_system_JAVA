/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.AdminWorkArea;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author mansiagrawal
 */
public class AdminWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AdminWorkAreaJPanel
     */
    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private UserAccount userAccount;
    private EcoSystem system;

    public AdminWorkAreaJPanel(JPanel userProcessContainer, UserAccount userAccount, Enterprise enterprise,
            EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.enterprise = enterprise;
        this.system = system;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnManageOrganization = new javax.swing.JButton();
        btnPublishJobs = new javax.swing.JButton();
        btnManageJobApplications = new javax.swing.JButton();
        btnManageEmpUserAcc = new javax.swing.JButton();
        lblHeader = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));
        setMaximumSize(new java.awt.Dimension(700, 700));
        setMinimumSize(new java.awt.Dimension(700, 700));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnManageOrganization.setText("Manage Organization");
        btnManageOrganization.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageOrganizationActionPerformed(evt);
            }
        });
        add(btnManageOrganization, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 270, -1));

        btnPublishJobs.setText("Publish Jobs");
        btnPublishJobs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPublishJobsActionPerformed(evt);
            }
        });
        add(btnPublishJobs, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 270, -1));

        btnManageJobApplications.setText("Manage Job Applications");
        btnManageJobApplications.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageJobApplicationsActionPerformed(evt);
            }
        });
        add(btnManageJobApplications, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, 270, -1));

        btnManageEmpUserAcc.setText("Manage Employee User Account");
        btnManageEmpUserAcc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageEmpUserAccActionPerformed(evt);
            }
        });
        add(btnManageEmpUserAcc, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 360, 270, -1));

        lblHeader.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader.setText("Admin Work Area ");
        add(lblHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 270, 26));

        jLabel1.setBackground(new java.awt.Color(204, 255, 204));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/admin.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 10, 200, 230));
    }// </editor-fold>//GEN-END:initComponents

    private void btnManageOrganizationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageOrganizationActionPerformed
        // TODO add your handling code here:
        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        ManageOrganizationJPanel mojp = new ManageOrganizationJPanel(userProcessContainer, enterprise.getOrganizationDirectory());
        userProcessContainer.add("mojp", mojp);
        cardLayout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageOrganizationActionPerformed

    private void btnPublishJobsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPublishJobsActionPerformed
        // TODO add your handling code here:
        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        PublishJobsJPanel pjjp = new PublishJobsJPanel(userProcessContainer, system.getJobDirectory(), userAccount, system);
        userProcessContainer.add("pjjp", pjjp);
        cardLayout.next(userProcessContainer);
    }//GEN-LAST:event_btnPublishJobsActionPerformed

    private void btnManageJobApplicationsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageJobApplicationsActionPerformed
        // TODO add your handling code here:
        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        ManageJobApplicationsJPanel mjajp = new ManageJobApplicationsJPanel(userProcessContainer, enterprise, system, userAccount);
        userProcessContainer.add("mjajp", mjajp);
        cardLayout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageJobApplicationsActionPerformed

    private void btnManageEmpUserAccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageEmpUserAccActionPerformed
        // TODO add your handling code here:
        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        ManageEmployeeUserAccountJPanel meuajp = new ManageEmployeeUserAccountJPanel(userProcessContainer, enterprise, system);
        userProcessContainer.add("meuajp", meuajp);
        cardLayout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageEmpUserAccActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnManageEmpUserAcc;
    private javax.swing.JButton btnManageJobApplications;
    private javax.swing.JButton btnManageOrganization;
    private javax.swing.JButton btnPublishJobs;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblHeader;
    // End of variables declaration//GEN-END:variables
}
