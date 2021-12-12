package Interfaces;

import JDBC.bidding_history;
import JDBC.text_reader;

import java.io.IOException;

import java.io.ObjectInputStream;

import java.net.Socket;

import java.util.Vector;

import Publisher.Publisher;

import Publisher.Subscriber;

import java.io.DataOutputStream;

import java.io.FileNotFoundException;

import java.io.ObjectOutputStream;
import java.util.Random;

import java.util.Timer;

import java.util.TimerTask;

import java.util.logging.Level;

import java.util.logging.Logger;

public class Bidding_Home extends javax.swing.JInternalFrame 
{

    Socket soc = null;
    
    ObjectInputStream in = null;
    
    ObjectOutputStream out = null;
    
    public Bidding_Home() 
    {
        initComponents();
        
        Random rand = new Random();

        int random_id = rand.nextInt(99999);

        String ID = String.valueOf(random_id);
        
        try
        {
            text_reader my_obj = new text_reader();
                
            name.setText(my_obj.reader()+"_TEMP ID : "+ID);
        }
        catch(Exception ex)
        {
            name.setText("System ERROR!");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        result = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        time_display = new javax.swing.JLabel();
        mes1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ip = new javax.swing.JTextField();
        price = new javax.swing.JTextField();
        item_02 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        notification = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        symbol1 = new javax.swing.JTextField();
        item_01 = new javax.swing.JTextField();
        item_03 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        results_02 = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(1230, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        result.setColumns(20);
        result.setRows(5);
        result.setAutoscrolls(false);
        jScrollPane1.setViewportView(result);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 0, 640, 350));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        time_display.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jPanel1.add(time_display, new org.netbeans.lib.awtextra.AbsoluteConstraints(236, 24, 260, 40));

        mes1.setBackground(new java.awt.Color(0, 0, 0));
        mes1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jPanel1.add(mes1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 24, 180, 40));

        jLabel1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jLabel1.setText("Bidding Price  : ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 155, 52));

        jLabel2.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jLabel2.setText("Server IP Address : ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 82, 155, 52));

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jLabel3.setText("Subscribe Items : ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 226, 155, 52));

        ip.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        ip.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        jPanel1.add(ip, new org.netbeans.lib.awtextra.AbsoluteConstraints(208, 82, 260, 54));

        price.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        price.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        jPanel1.add(price, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 370, 260, 54));

        item_02.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        item_02.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        jPanel1.add(item_02, new org.netbeans.lib.awtextra.AbsoluteConstraints(301, 226, 74, 54));

        jButton1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/connect_35px.png"))); // NOI18N
        jButton1.setText("Connect");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 493, 162, 53));

        jButton2.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/auction_35px.png"))); // NOI18N
        jButton2.setText("Bidding ");
        jButton2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(387, 493, 162, 53));

        notification.setBackground(new java.awt.Color(0, 0, 0));
        notification.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jPanel1.add(notification, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 442, 420, 40));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jLabel5.setText("User Name :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 154, 155, 52));

        name.setEditable(false);
        name.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        name.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });
        jPanel1.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 154, 260, 54));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/questions_28px.png"))); // NOI18N
        jButton3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        jButton3.setBorderPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(518, 24, 40, 40));

        jButton4.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add_shopping_cart_35px.png"))); // NOI18N
        jButton4.setText("Subscribe");
        jButton4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        jButton4.setBorderPainted(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 493, 162, 53));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jLabel4.setText("Bidding Symbol : ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 298, 155, 52));

        symbol1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        symbol1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        jPanel1.add(symbol1, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 298, 260, 54));

        item_01.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        item_01.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        jPanel1.add(item_01, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 226, 74, 54));

        item_03.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        item_03.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        jPanel1.add(item_03, new org.netbeans.lib.awtextra.AbsoluteConstraints(393, 226, 74, 54));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/mitchell-luo-U1Hhinvb-v4-unsplash.jpg"))); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 570));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 580));

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/bar_chart_30px.png"))); // NOI18N
        jLabel8.setText("My Subscriptions");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 360, 170, 40));

        results_02.setColumns(20);
        results_02.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 14)); // NOI18N
        results_02.setForeground(new java.awt.Color(51, 51, 51));
        results_02.setRows(5);
        results_02.setAutoscrolls(false);
        jScrollPane2.setViewportView(results_02);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 410, 640, 160));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/360_F_338389344_7yiAzAQt5vs7hY3ui4pxtnomXobybJbY.jpg"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 350, 640, 220));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        table_get();
        
        ip.setEditable(false);
        
        jButton1.setEnabled(false);
        
        refresh update = new refresh();
            
        Thread t = new Thread(update);
            
        t.start();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    public class refresh implements Runnable
    {
        @Override
        
        public void run() 
        {
            Timer timer = new Timer();

            int begin = 0;

            int time_interval = 1000; // 1 s = 1000 ms

        timer.schedule(new TimerTask()
        {
            int counter = 0;
            
            @Override
            
            public void run()
            {
                table_get();
                
                counter ++;
                
                time_display.setText(counter + "/ 180 SEC For Bid");

                if(counter >= 180)
                {
                    timer.cancel();
                    
                    jButton2.setEnabled(false);
                    
                    time_display.setText("Bid Time Over");
                }
            }
        },begin ,time_interval);
        }
        
    }        
    public void table_get()
    {
        Publisher pub;

        String str;

        Vector records;
        
        String address = ip.getText();

        try 
        {
         try 
         {
            soc = new Socket(address, 2000); /*making connection*/
            
            out = new ObjectOutputStream(soc.getOutputStream());
            
            in = new ObjectInputStream(soc.getInputStream());
            
            mes1.setText("Connected");
            
        }
         catch (IOException ioe) 
         {
            mes1.setText("Connection Broken");
         }
            Socket clientSocket = new Socket(address,2005);
            
            try (ObjectInputStream br = new ObjectInputStream(clientSocket.getInputStream()))
            {
                records = (Vector)br.readObject();

            }
            result.setText("");
            int i =0;

            result.append("SYMBOL\t\tPRICE\t\tSECURITY\t\tPROFIT\n");
            
            result.append("\n---------------------------------------------------------------------------------------------------------------------------------------------------\n");
            
            result.setEditable(false);

            while(i < records.size())
            {
                pub = (Publisher)records.elementAt(i);
                
                str = pub.SYMBOL;
                
                result.append(str + "\t\t");
                
                str = pub.PRICE;
                
                result.append(str + "\t\t");
                
                str = pub.Security;
                
                result.append(str + "\t\t");
                    
                str = pub.Profit;
                
                result.append(str + "\t\n\n");
                
                i++;

            }
            records.removeAllElements();

        } 
        catch (IOException ex) 
        {
            // Logger.getLogger(Clientnew.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (ClassNotFoundException ex)
        {
            // Logger.getLogger(Clientnew.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
        bidding_thread bidding_send = new bidding_thread();
        
        Thread thread = new Thread(bidding_send);
            
        thread.start();
        
        bidding_history history = new bidding_history();
        
        String data_01 = symbol1.getText();
                
        String data_02 = price.getText();
                
        try 
        {
            history.record(data_01,data_02);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Bidding_Home.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
        Quick_guide guide = null;
        try 
        {
            guide = new Quick_guide();
            
        } catch (FileNotFoundException ex) 
        {
            Logger.getLogger(Bidding_Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        guide.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        jButton4.setEnabled(false);
        
        refresh_02 update_02 = new refresh_02();
            
        Thread t = new Thread(update_02);
            
        t.start();
      
    }//GEN-LAST:event_jButton4ActionPerformed

    public class bidding_thread implements Runnable
    {

        @Override
        public void run() 
        {
        Publisher info = new Publisher();

        info.SYMBOL = symbol1.getText().trim();
        
        info.PRICE = price.getText().trim();
        
        info.user = name.getText().trim();
        
        try {
            out.writeObject(info);
            
            String mesg = (String) in.readObject();
            
            notification.setText(mesg);

            symbol1.setText("");
            
            price.setText("");
                        
            item_02.requestFocus();
            
        } 
        catch (Exception ee) 
        {
            System.out.println("can't send data" + ee);
        }
        
        table_get();
        }
        
    }
    public class Subscriber_ implements Runnable
    {
        @Override
        public void run() 
        {
        Subscriber pub;

        String str;

        Vector records;
        
        String address = ip.getText();
        
        String item_1 = item_01.getText();
        
        String item_2 = item_02.getText();
        
        String item_3 = item_03.getText();
        
        try
        {
            Socket clientSocket = new Socket(address,2004);
            
            DataOutputStream dout=new DataOutputStream(clientSocket.getOutputStream());  

            dout.writeUTF("SELECT * FROM Bidding_Data WHERE SYMBOL IN ('"+item_1+"','"+item_2+"','"+item_3+"')");  

            dout.flush();  
                    
            try (ObjectInputStream br = new ObjectInputStream(clientSocket.getInputStream()))
            {
                records = (Vector)br.readObject();
            }
            
            results_02.setText("");
            
            int i =0;

            results_02.append("SYMBOL\t\tPRICE\t\tBIDDER\n");
            
            results_02.append("\n--------------------------------------------------------------------------------------\n");
            
            results_02.setEditable(false);

            while(i < records.size())
            {
                pub = (Subscriber)records.elementAt(i);
                
                str = pub.SYMBOL;
                
                results_02.append(str + "\t\t");
                
                str = pub.PRICE;
                
                results_02.append(str + "\t\t");
                
                str = pub.BIDDER;
                
                results_02.append(str + "\n\n");
                
                i++;

            }
            records.removeAllElements();

        } 
        catch (IOException ex) 
        {
            System.out.println("ERROR 01 : "+ex);
        } 
        catch (ClassNotFoundException ex2)
        {
            System.out.println("ERROR 02 : "+ex2);
        }
        
        }
        
    }
    
    
    public class refresh_02 implements Runnable
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
                Subscriber_  update = new Subscriber_ ();
            
                Thread t = new Thread(update);
            
                t.start();
                
                counter ++;
                
                
                if(counter >= 180)
                {
                    timer.cancel();
                }
            }
        },begin ,time_interval);
        }
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ip;
    private javax.swing.JTextField item_01;
    private javax.swing.JTextField item_02;
    private javax.swing.JTextField item_03;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel mes1;
    private javax.swing.JTextField name;
    private javax.swing.JLabel notification;
    public static javax.swing.JTextField price;
    private javax.swing.JTextArea result;
    private javax.swing.JTextArea results_02;
    public static javax.swing.JTextField symbol1;
    private javax.swing.JLabel time_display;
    // End of variables declaration//GEN-END:variables
}
