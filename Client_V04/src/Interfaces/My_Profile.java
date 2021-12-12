
package Interfaces;

import JDBC.db_conn;
import JDBC.text_genarator;
import JDBC.text_reader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Jayashanka Deshan
 */
public class My_Profile extends javax.swing.JInternalFrame {

    Connection conn = null;

   PreparedStatement pst = null;
   
   ResultSet rs = null;
   
    public My_Profile() throws FileNotFoundException 
    {
        initComponents();
        
        String db_name = "Bidding_History.ZTOCK";
        
        FileInputStream fis = new FileInputStream(db_name);

        Scanner output = new Scanner(fis);
        
        String history = null;

        while (output.hasNext())
        {
            history = output.nextLine();
            
            panel.append(history+"\n");
        }
        
        data_load();
    }
    
    
    public  void data_load() throws FileNotFoundException
    {
        text_reader my_obj = new text_reader();
                
        String user_name = my_obj.reader();
        
        db_conn db = new db_conn();
            
        conn = db.connect();
       
        String SQL = "SELECT * FROM Users WHERE USER_NAME = '"+user_name+"'";
        
        try 
        {
            Statement stmt = conn.createStatement();
            
            rs = stmt.executeQuery(SQL);
  
            while(rs.next())
            {
                String user_id = rs.getString("ID");
                
                uid.setText(user_id);
                
                uname.setText(user_name);
                
                String full_name = rs.getString("FULL_NAME");
                
                fname.setText(full_name);
                
                String email = rs.getString("E_MAIL_ADDRESS");
                
                mail.setText(email);
                
                String pwd = rs.getString("PASSWORD");
                
                password.setText(pwd);  
                
                String NUMBER = rs.getString("MOBILE_NUMBER");
                
                number.setText(NUMBER);  
            }                        
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(My_Profile.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        jLabel7 = new javax.swing.JLabel();
        uid = new javax.swing.JTextField();
        number = new javax.swing.JTextField();
        password = new javax.swing.JTextField();
        fname = new javax.swing.JLabel();
        uname = new javax.swing.JLabel();
        mail = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        panel = new javax.swing.JTextArea();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(1230, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jLabel1.setText("Full Name :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 285, 123, 39));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 36)); // NOI18N
        jLabel2.setText("MY PROFILE");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 21, 207, 65));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jLabel3.setText("User ID :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 131, 123, 39));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jLabel4.setText("User Name  :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 208, 123, 39));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jLabel5.setText("Mobile Number  : ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 437, -1, 39));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jLabel6.setText("Password : ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 512, 131, 39));

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jLabel7.setText("E mail Address : ");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 361, 131, 39));

        uid.setEditable(false);
        uid.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        uid.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        getContentPane().add(uid, new org.netbeans.lib.awtextra.AbsoluteConstraints(237, 128, 241, 46));

        number.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        number.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        getContentPane().add(number, new org.netbeans.lib.awtextra.AbsoluteConstraints(237, 434, 241, 46));

        password.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        password.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        getContentPane().add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(237, 509, 241, 46));

        fname.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        getContentPane().add(fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(237, 280, 241, 48));

        uname.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        getContentPane().add(uname, new org.netbeans.lib.awtextra.AbsoluteConstraints(237, 203, 241, 48));

        mail.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        mail.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        getContentPane().add(mail, new org.netbeans.lib.awtextra.AbsoluteConstraints(237, 358, 241, 46));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh_30px.png"))); // NOI18N
        jButton1.setToolTipText("Refresh");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(505, 128, 52, 46));

        jButton2.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/update_30px.png"))); // NOI18N
        jButton2.setText("Update");
        jButton2.setToolTipText("Update Account Details");
        jButton2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 480, 129, 46));

        jButton3.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/database_export_30px.png"))); // NOI18N
        jButton3.setText("Export");
        jButton3.setToolTipText("Export Account Details");
        jButton3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        jButton3.setBorderPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 480, 129, 46));

        panel.setEditable(false);
        panel.setColumns(20);
        panel.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        panel.setRows(5);
        panel.setText("TIME                            SYMBOL                  PRICE");
        jScrollPane1.setViewportView(panel);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 100, 530, 370));

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 24)); // NOI18N
        jLabel9.setText("MY BIDDING HISTORY");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 30, 240, 50));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/5082238.jpg"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1230, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         
        try 
        {
            data_load();
        } catch (FileNotFoundException ex) 
        {
            Logger.getLogger(My_Profile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        String id = uid.getText();
        
        String e_mail = mail.getText();
        
        String mobile_no = number.getText();
        
        String pwd = password.getText();
        
        String SQL = "UPDATE Users SET E_MAIL_ADDRESS='"+e_mail+"',MOBILE_NUMBER='"+mobile_no+"',PASSWORD='"+pwd+"' WHERE ID='"+id+"'";
        
        int x = JOptionPane.showConfirmDialog(null,"ARE YOU REALLY WANT UPDATE YOUR INFO");
        
        if(x == 0)
        {        
        try 
        {
            pst = conn.prepareStatement(SQL);
            
            int row = pst.executeUpdate();

            if (row > 0)
                {
                    System.out.println("UPDATE successfully");
                    
                    JOptionPane.showMessageDialog(null,"UPDATE COMPLETE");
                    
                    e_mail = "";
                    
                    mobile_no = "";
                    
                    pwd = "";
                }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(My_Profile.class.getName()).log(Level.SEVERE, null, ex);
            
            JOptionPane.showMessageDialog(null,"ERROR :"+ex);
        }
        }



    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        String id = uid.getText();
        
        String e_mail = mail.getText();
        
        String mobile_no = number.getText();
        
        String pwd = password.getText();
        
        String name = uname.getText();
        
        String f_name = fname.getText();
        
        text_genarator backup = new text_genarator();
        
        try 
        {
            String message = backup.add_data(id,id,name,f_name,e_mail,mobile_no,pwd);
            
            JOptionPane.showMessageDialog(null,message);
            
        } catch (IOException ex) 
        {
            Logger.getLogger(My_Profile.class.getName()).log(Level.SEVERE, null, ex);
            
            JOptionPane.showMessageDialog(null,"ERROR :"+ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel fname;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextField mail;
    public static javax.swing.JTextField number;
    private javax.swing.JTextArea panel;
    public static javax.swing.JTextField password;
    public static javax.swing.JTextField uid;
    public static javax.swing.JLabel uname;
    // End of variables declaration//GEN-END:variables
}
