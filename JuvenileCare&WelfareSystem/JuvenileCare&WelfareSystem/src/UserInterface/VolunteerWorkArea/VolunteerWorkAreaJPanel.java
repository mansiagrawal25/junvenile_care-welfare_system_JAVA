/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.VolunteerWorkArea;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author anish
 */
public class VolunteerWorkAreaJPanel extends javax.swing.JPanel {

    /**
     * Creates new form VolunteerWorkAreaJPanel
     */
    private JPanel userProcessContainer;
    private EcoSystem system;
    private UserAccount userAccount;
    private Organization organization;
    private Enterprise enterprise;

    public VolunteerWorkAreaJPanel(JPanel userProcessContainer, EcoSystem system, UserAccount userAccount, Organization organization, Enterprise enterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        this.userAccount = userAccount;
        this.organization = organization;
        this.enterprise = enterprise;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnOngoingProjects = new javax.swing.JButton();
        lblHeader = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));
        setMaximumSize(new java.awt.Dimension(700, 700));
        setMinimumSize(new java.awt.Dimension(700, 700));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnOngoingProjects.setText("Ongoing Projects");
        btnOngoingProjects.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOngoingProjectsActionPerformed(evt);
            }
        });
        add(btnOngoingProjects, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, -1, 30));

        lblHeader.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHeader.setText("Volunteer Work Area");
        add(lblHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 270, 26));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/others.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, 130, 200));
    }// </editor-fold>//GEN-END:initComponents

    private void btnOngoingProjectsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOngoingProjectsActionPerformed
        // TODO add your handling code here:
        CardLayout cardLayout = (CardLayout) userProcessContainer.getLayout();
        OngoingProjectsJPanel opjp = new OngoingProjectsJPanel(userProcessContainer, system, userAccount, organization, enterprise);
        userProcessContainer.add("OngoingProjectsJPanel", opjp);
        cardLayout.next(userProcessContainer);
    }//GEN-LAST:event_btnOngoingProjectsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOngoingProjects;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblHeader;
    // End of variables declaration//GEN-END:variables
}
