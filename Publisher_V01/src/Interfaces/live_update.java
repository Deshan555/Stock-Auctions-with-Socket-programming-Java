/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import java.io.DataOutputStream;

import java.io.IOException;

import java.io.ObjectInputStream;

import java.net.Socket;

import java.util.Vector;

import Publisher_Obj.Send_Update;
import java.util.Timer;
import java.util.TimerTask;
import Core.cache_reader;

/**
 *
 * @author Jayashanka Deshan
 */
public class live_update extends javax.swing.JInternalFrame 
{
    cache_reader reader = new cache_reader();

    
    public live_update() 
    {
        initComponents();
        
        live_update_catcher setup = new live_update_catcher();
        
        Thread thread = new Thread(setup);
        
        thread.run();
        
        try
        {
            address.setText(reader.reader("ip_address.dat"));
            
            log_area.append("ip_address.dat Found Temp_Db Ok!\n\n");
        }
        catch(Exception Error)
        {
            log_area.append("ERROR : ip_address.dat Not Found \nERROR CODE : "+Error+"\n\n");
            
            address.setText("DB Error");            
        }
        
        try
        {
            price.setText(reader.reader("price.dat"));
            
            log_area.append("price.dat Found Temp_Db Ok!\n\n");
        }
        catch(Exception Error)
        {
            log_area.append("ERROR : price.dat Not Found \nERROR CODE : "+Error+"\n\n");
            
            price.setText("DB Error");            
        }
        
        try
        {
            id.setText(reader.reader("Item_Code.dat"));
            
            log_area.append("Item_Code.dat.dat Found Temp_Db Ok!\n\n");
        }
        catch(Exception Error)
        {
            log_area.append("ERROR : Item_Code.dat Not Found \nERROR CODE : "+Error+"\n\n");
            
            id.setText("DB Error");            
        } 
    }
    
    
    public class live_update_catcher implements Runnable
    {
        @Override
        public void run() 
        {
        Send_Update pub;

        String str;

        Vector records;
                
        try
        {
            cache_reader reader = new cache_reader();
               
            Socket clientSocket = new Socket(reader.reader("ip_address.dat"),2003);
                        
            connection.setText("Connected !!");
            
            DataOutputStream dout=new DataOutputStream(clientSocket.getOutputStream());  

            dout.writeUTF("SELECT Price , Bidder FROM Bidding_Data WHERE SYMBOL = '"+reader.reader("Item_Code.dat")+"';");  

            dout.flush();  
                    
            try (ObjectInputStream br = new ObjectInputStream(clientSocket.getInputStream()))
            {
                records = (Vector)br.readObject();
            }            
            int i =0;
            
            log_area.setEditable(false);

            while(i < records.size())
            {
                pub = (Send_Update)records.elementAt(i);
                                
                str = pub.PRICE;
                
                log_area.append("PRICE >> "+str+"\t");
                
                price.setText("LKR : "+str);
                                
                str = pub.BIDDER;
                
                log_area.append("BIDDER >> "+str+"\n\n");

                i++;

            }
            records.removeAllElements();

        } 
        catch (IOException ex) 
        {
            System.out.println("ERROR 01 : "+ex);
            
            connection.setText("Disconnected !!");
            
            price.setText("Server Error");
            
            log_area.append("ERROR CODE : "+ex+"\n");
            
            jButton1.setEnabled(false);
        } 
        catch (ClassNotFoundException ex2)
        {
            System.out.println("ERROR 02 : "+ex2);
            
            connection.setText("Disconnected !!");
            
            price.setText("Server Error");
            
            log_area.append("ERROR CODE : "+ex2+"\n\n");
            
            log_area.append("Live Updater Server Offline Try Again Shortly\n\n");
            
            jButton1.setEnabled(false);
        }
        
        }   
    }
    
    public class refresh implements Runnable
    {
        @Override
        
        public void run() 
        {
            Timer timer = new Timer();

            int begin = 0;

            int time_interval = 2000; // 1 s = 1000 ms

        timer.schedule(new TimerTask()
        {
            int counter = 0;
            
            @Override
            
            public void run()
            {
                jButton1.setEnabled(false);
                
                live_update_catcher setup = new live_update_catcher();
        
                Thread thread = new Thread(setup);
        
                thread.run();
                
                counter ++;
                
                
                if(counter >= 300)
                {
                    timer.cancel();
                    
                    jButton1.setEnabled(true);
                }
            }
        },begin ,time_interval);
        }
    }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        log_area = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        address = new javax.swing.JTextField();
        id = new javax.swing.JTextField();
        price = new javax.swing.JTextField();
        connection = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        jLabel5.setText("jLabel5");

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(null);
        setPreferredSize(new java.awt.Dimension(1080, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        log_area.setEditable(false);
        log_area.setBackground(new java.awt.Color(0, 0, 0));
        log_area.setColumns(20);
        log_area.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        log_area.setForeground(new java.awt.Color(255, 255, 255));
        log_area.setRows(5);
        log_area.setBorder(null);
        jScrollPane1.setViewportView(log_area);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, -6, 600, 390));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jLabel1.setText("My Stock Id : ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 158, 158, 48));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jLabel2.setText("Server Address : ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 18, 139, 48));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jLabel3.setText("Current Price : ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 228, 158, 48));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jLabel4.setText("Connection Status :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 88, 158, 48));

        jButton1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/video_record_30px.png"))); // NOI18N
        jButton1.setText("See Live Updates");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 315, 208, 46));

        address.setEditable(false);
        address.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        address.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        getContentPane().add(address, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 23, 225, 47));

        id.setEditable(false);
        id.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        id.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        getContentPane().add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 163, 225, 47));

        price.setEditable(false);
        price.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        price.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        getContentPane().add(price, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 233, 225, 47));

        connection.setEditable(false);
        connection.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        connection.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        getContentPane().add(connection, new org.netbeans.lib.awtextra.AbsoluteConstraints(194, 93, 225, 47));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/mitchell-luo-U1Hhinvb-v4-unsplash.jpg"))); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        refresh setup = new refresh();
        
        Thread thread = new Thread(setup);
        
        thread.run();
        
        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address;
    private javax.swing.JTextField connection;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea log_area;
    private javax.swing.JTextField price;
    // End of variables declaration//GEN-END:variables
}
