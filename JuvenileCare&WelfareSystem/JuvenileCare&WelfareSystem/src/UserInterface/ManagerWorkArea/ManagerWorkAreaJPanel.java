/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.ManagerWorkArea;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author ashwi
 */
public class ManagerWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManagerWorkAreaJPanel
     */
    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Organization organization;
    private Enterprise enterprise;
    private EcoSystem system;
    public ManagerWorkAreaJPanel(JPanel userProcessContainer,EcoSystem system, UserAccount userAccount, Organization organization, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer; 
        this.userAccount = userAccount;
        this.organization = organization;
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

        btnManageFundingAgencies = new javax.swing.JButton();
        btnPostTasks = new javax.swing.JButton();
        btnViewIssues = new javax.swing.JButton();
        btnProjects = new javax.swing.JButton();
        btnAccount = new javax.swing.JButton();
        btnViewVolunteers = new javax.swing.JButton();
        lblHeader = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));
        setMaximumSize(new java.awt.Dimension(700, 700));
        setMinimumSize(new java.awt.Dimension(700, 700));
        setPreferredSize(new java.awt.Dimension(700, 700));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnManageFundingAgencies.setText("Manage Funding Agencies");
        btnManageFundingAgencies.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageFundingAgenciesActionPerformed(evt);
            }
        });
        add(btnManageFundingAgencies, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 220, -1));

        btnPostTasks.setText("Post Tasks");
        btnPostTasks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPostTasksActionPerformed(evt);
            }
        });
        add(btnPostTasks, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 220, 217, -1));

        btnViewIssues.setText("View Issues");
        btnViewIssues.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewIssuesActionPerformed(evt);
            }
        });
        add(btnViewIssues, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, 217, -1));

        btnProjects.setText("Projects");
        btnProjects.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProjectsActionPerformed(evt);
            }
        });
        add(btnProjects, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 360, 217, -1));

        btnAccount.setText("Account");
        btnAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccountActionPerformed(evt);
            }
        });
        add(btnAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 430, 217, -1));

        btnViewVolunteers.setText("View Volunteers");
        btnViewVolunteers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewVolunteersActionPerformed(evt);
            }
        });
        add(btnViewVolunteers, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 500, 217, -1));

        lblHeader.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader.setText("Manager Work Area");
        add(lblHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 220, 26));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/manager.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, 160, 190));
    }// </editor-fold>//GEN-END:initComponents

    private void btnManageFundingAgenciesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageFundingAgenciesActionPerformed
        // TODO add your handling code here:
        CardLayout  cardLayout = (CardLayout) userProcessContainer.getLayout();
        ManageFundingAgenciesJPanel mfawajp = new ManageFundingAgenciesJPanel(userProcessContainer, system, userAccount, organization, enterprise);
        userProcessContainer.add("ManageFundingAgenciesJPanel",mfawajp);
        cardLayout.next(userProcessContainer);
    }//GEN-LAST:event_btnManageFundingAgenciesActionPerformed

    private void btnPostTasksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPostTasksActionPerformed
        // TODO add your handling code here:
        CardLayout  cardLayout = (CardLayout) userProcessContainer.getLayout();
        PostTasksJPanel ptjp = new PostTasksJPanel(userProcessContainer, userAccount, organization, enterprise);
        userProcessContainer.add("PostTasksJPanel",ptjp);
        cardLayout.next(userProcessContainer);
    }//GEN-LAST:event_btnPostTasksActionPerformed

    private void btnViewIssuesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewIssuesActionPerformed
        // TODO add your handling code here:
        CardLayout  cardLayout = (CardLayout) userProcessContainer.getLayout();
        ViewIssuesJPanel vijp = new ViewIssuesJPanel(userProcessContainer, userAccount, organization, enterprise);
        userProcessContainer.add("ViewIssuesJPanel",vijp);
        cardLayout.next(userProcessContainer);
    }//GEN-LAST:event_btnViewIssuesActionPerformed

    private void btnProjectsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProjectsActionPerformed
        // TODO add your handling code here:
        CardLayout  cardLayout = (CardLayout) userProcessContainer.getLayout();
        ProjectsJPanel pjp = new ProjectsJPanel(userProcessContainer,userAccount, organization, enterprise);
        userProcessContainer.add("ProjectsJPanel",pjp);
        cardLayout.next(userProcessContainer);
    }//GEN-LAST:event_btnProjectsActionPerformed

    private void btnAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccountActionPerformed
        // TODO add your handling code here:
        CardLayout  cardLayout = (CardLayout) userProcessContainer.getLayout();
        AccountJPanel ajp = new AccountJPanel(userProcessContainer,userAccount, organization, enterprise);
        userProcessContainer.add("AccountJPanel",ajp);
        cardLayout.next(userProcessContainer);
    }//GEN-LAST:event_btnAccountActionPerformed

    private void btnViewVolunteersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewVolunteersActionPerformed
        // TODO add your handling code here:
        CardLayout  cardLayout = (CardLayout) userProcessContainer.getLayout();
        ViewVolunteerJPanel vvjp = new ViewVolunteerJPanel(userProcessContainer,userAccount, organization, enterprise);
        userProcessContainer.add("ViewVolunteerJPanel",vvjp);
        cardLayout.next(userProcessContainer);
    }//GEN-LAST:event_btnViewVolunteersActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccount;
    private javax.swing.JButton btnManageFundingAgencies;
    private javax.swing.JButton btnPostTasks;
    private javax.swing.JButton btnProjects;
    private javax.swing.JButton btnViewIssues;
    private javax.swing.JButton btnViewVolunteers;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblHeader;
    // End of variables declaration//GEN-END:variables
}
