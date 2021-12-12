/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

/**
 *
 * @author Jayashanka Deshan
 */
import JDBC.db_conn;
import Services.Genarete_ID;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Admin_Setting extends javax.swing.JInternalFrame {

   Connection conn = null;

   PreparedStatement pst = null;
   
   ResultSet rs = null;
    
   public Admin_Setting() 
   {
       initComponents();
        
       conn = db_conn.connect();
       
       System.out.print("Data Base OK !!");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        fname = new javax.swing.JTextField();
        nic = new javax.swing.JTextField();
        mnumber = new javax.swing.JTextField();
        mail = new javax.swing.JTextField();
        pwd = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(910, 470));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 24)); // NOI18N
        jLabel1.setText("Add New Admin ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 44));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jLabel2.setText("Mobile Number : ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 208, -1, 41));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jLabel3.setText("Full Name : ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 62, -1, 41));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jLabel4.setText("NIC Number : ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 137, -1, 41));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jLabel5.setText("Password   : ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, -1, 41));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jLabel6.setText("E mail  : ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 279, -1, 41));

        fname.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        fname.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        getContentPane().add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 62, 218, 37));

        nic.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        nic.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        getContentPane().add(nic, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 144, 218, 37));

        mnumber.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        mnumber.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        getContentPane().add(mnumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 215, 218, 37));

        mail.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        mail.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        getContentPane().add(mail, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 286, 218, 37));

        pwd.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        pwd.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        getContentPane().add(pwd, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 357, 218, 37));

        jButton1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/view_30px.png"))); // NOI18N
        jButton1.setText("VIEW");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 0));
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 360, 150, 40));

        jButton2.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/add_30px.png"))); // NOI18N
        jButton2.setText("ADD");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 0));
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 360, 150, 40));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new5097410.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
        String name = fname.getText();
        
        String id = nic.getText();
        
        String number = mnumber.getText();
        
        String email = mail.getText();
        
        String password = pwd.getText();
        
        String aid = Genarete_ID.generate_Id();
        
        String SQL = "INSERT INTO Admin (ID,FULL_NAME,NIC,MOBILE,E_MAIL,PASSWORD) VALUES ('"+aid+"','"+name+"','"+id+"','"+number+"','"+email+"','"+password+"')";
        
       try 
       {
           pst = conn.prepareStatement(SQL);
           
           pst.executeUpdate();
           
           JOptionPane.showMessageDialog(null,"Your Data Successfully Recorded!!\nYOUR ADMIN ID : "+aid);
       } 
       catch (SQLException ex) 
       {
           Logger.getLogger(Admin_Setting.class.getName()).log(Level.SEVERE, null, ex);
           
           JOptionPane.showMessageDialog(null,"ERROR : "+ex);
       }
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
       Admin_Table table;
       try 
       {
           table = new Admin_Table();
           
           table.setVisible(true);
       } 
       catch (SQLException ex) 
       {
           Logger.getLogger(Admin_Setting.class.getName()).log(Level.SEVERE, null, ex);
       }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField fname;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField mail;
    private javax.swing.JTextField mnumber;
    private javax.swing.JTextField nic;
    private javax.swing.JTextField pwd;
    // End of variables declaration//GEN-END:variables
}
