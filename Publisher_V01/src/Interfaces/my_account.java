/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;


import Core.cache_reader;

import Core.cache_writer;

import Publisher_Obj.Publisher;
import java.awt.Color;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class my_account extends javax.swing.JInternalFrame 
{

    Socket soc = null;
    
    ObjectInputStream in = null;
    
    ObjectOutputStream out = null;
    
    cache_reader reader = new cache_reader();
    
    cache_writer writer = new cache_writer();
    
    public my_account() 
    {
        initComponents();
        
        number.setEditable(false);
        try 
         {
            soc = new Socket(reader.reader("ip_address.dat"), 2001);
            
            out = new ObjectOutputStream(soc.getOutputStream());
            
            in = new ObjectInputStream(soc.getInputStream());
            
            msg.setForeground(Color.green);
            
            msg.setText("SERVER : Connected");
          }
        
        catch(Exception Error_01)
        {
           msg.setForeground(Color.red);
                       
           msg.setText("SERVER : Disconnected");
            
           jButton1.setEnabled(false);
           
           System.out.println(Error_01);
        }
        
        try
        {
            name.setText(reader.reader("Company_Name.dat"));
            
            code.setText(reader.reader("Item_Code.dat"));
            
            price.setText(reader.reader("Price.dat"));
            
            profit.setText(reader.reader("Profit.dat"));
            
            number.setText(reader.reader("Code_Security.dat"));
        }
        catch(Exception ERROR)
        {
            msg.setText("DB ERROR");
            
            jButton1.setEnabled(false);
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
        name = new javax.swing.JLabel();
        price = new javax.swing.JLabel();
        code = new javax.swing.JLabel();
        number = new javax.swing.JTextField();
        profit = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        msg = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setPreferredSize(new java.awt.Dimension(1080, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("My Organization");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 201, 45));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jLabel2.setText("Organization Code : ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 144, 176, 42));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jLabel3.setText("Price : ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 204, 176, 42));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jLabel4.setText("Profit : ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(555, 96, 119, 42));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jLabel5.setText("Security Code : ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(555, 156, -1, 42));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jLabel6.setText("Organization Name : ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 84, 176, 42));

        name.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        getContentPane().add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 84, 234, 42));

        price.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        getContentPane().add(price, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 204, 234, 42));

        code.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        getContentPane().add(code, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 144, 234, 42));

        number.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        number.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 0));
        number.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numberActionPerformed(evt);
            }
        });
        getContentPane().add(number, new org.netbeans.lib.awtextra.AbsoluteConstraints(741, 160, 243, 42));

        profit.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        profit.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        getContentPane().add(profit, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 90, 243, 42));

        jButton1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/update_left_rotation_40px.png"))); // NOI18N
        jButton1.setText("Update Profit");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 250, 190, 50));

        msg.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        getContentPane().add(msg, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 250, 230, 50));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/5082238.jpg"))); // NOI18N
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void numberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numberActionPerformed
        
    }//GEN-LAST:event_numberActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        profit_update update = new profit_update();
        
        Thread thread = new Thread(update);
        
        thread.run();
    }//GEN-LAST:event_jButton1ActionPerformed


    
public class profit_update implements Runnable
{
        @Override
        public void run() 
        {

        Publisher info = new Publisher();
        
        info.C_SYMBOL = code.getText().trim();
                
        info.S_NUMBER = number.getText().trim();
        
        info.PROFIT = profit.getText().trim();
        
        //info.PASSWORD = pwd.getText().trim();
        
        try {
            out.writeObject(info);
            
            String mesg = (String) in.readObject();
            
            System.out.println("SERVER MESSAGE : "+mesg);
            
            msg.setText(mesg);
            
            writer.writer("Profit.dat",profit.getText());
            
            profit.setText(reader.reader("Profit.dat"));
                                                           
            price.requestFocus();
            
        } 
        catch (Exception ee) 
        {
            System.out.println("can't send data" + ee);
        }
    }
        
}
    
    
    
    
    
    
    
    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel code;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel msg;
    private javax.swing.JLabel name;
    private javax.swing.JTextField number;
    private javax.swing.JLabel price;
    private javax.swing.JTextField profit;
    // End of variables declaration//GEN-END:variables
}
