package Interfaces;
import JDBC.db_conn;
import Publisher.Publisher;
import Server.*;
import Services.Backup_log;
import Services.Bidding_logs;
import javax.swing.JOptionPane;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Services.table_load;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import Services.Subscribers_Handler;

public class Bidding_Home extends javax.swing.JInternalFrame 
{
    Publisher_Register register = new Publisher_Register();
    
    Profit_Update profit_updater = new Profit_Update();
    
    public Bidding_Home() throws SQLException 
    {
        initComponents();
               
        table_load table = new table_load();
        
        table.table_load();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        log_area = new javax.swing.JTextArea();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBorder(null);
        setPreferredSize(new java.awt.Dimension(910, 470));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/auction_30px.png"))); // NOI18N
        jButton1.setText("BIDDING START");
        jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 175, 50));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/eye_25px.png"))); // NOI18N
        jButton5.setToolTipText("View Static");
        jButton5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        jButton5.setBorderPainted(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 10, 40, 40));

        jButton2.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(51, 51, 51));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save_30px.png"))); // NOI18N
        jButton2.setText("SAVE LOG");
        jButton2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 175, 50));

        table.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(table);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, 420, 440));

        log_area.setEditable(false);
        log_area.setBackground(new java.awt.Color(51, 51, 51));
        log_area.setColumns(20);
        log_area.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        log_area.setForeground(new java.awt.Color(255, 255, 255));
        log_area.setLineWrap(true);
        log_area.setRows(5);
        log_area.setBorder(null);
        jScrollPane2.setViewportView(log_area);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 490, 300));

        jButton3.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(51, 51, 51));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/refresh_30px.png"))); // NOI18N
        jButton3.setText("REFRESH TABLE");
        jButton3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        jButton3.setBorderPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 175, 50));

        jButton4.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(51, 51, 51));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/start_30px.png"))); // NOI18N
        jButton4.setText("RUN SERVER");
        jButton4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 0, true));
        jButton4.setBorderPainted(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 175, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/new5097410.png"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 150));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        int x = JOptionPane.showConfirmDialog(null,"Are You Want Back Up Current Activity Log");
        
        if(x == 0)
        {
        String data = log_area.getText();
        
        Backup_log back_obj = new Backup_log();
        
        JOptionPane.showMessageDialog(null,back_obj.backup(data));
        
        back_obj.backup(data);
        
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        int x = JOptionPane.showConfirmDialog(null,"ARE YOU REALLY WANT START BIDDING");
        
        log_area.append("Bidding Server Power Up : Port 2000\n\n");
        
        if(x == 0)
        {
            Updater update = new Updater();
            
            Thread t = new Thread(update);
            
            t.start();
                       
        }       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       
        table_load table = new table_load();
                
        try 
        {
            table.table_load();
                       
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(Bidding_Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
        table_send send = new table_send();
        
        Subscription_push push_subscription = new Subscription_push();
        
        push_update push_updater = new push_update();
        
        Thread thread_01 = new Thread(register);
            
        thread_01.start();
        
        Thread thread_02 = new Thread(profit_updater);
            
        thread_02.start();
        
            
        log_area.append("Publiser Register Server Power Up : Port 2002\n\n");
        
        log_area.append("Push Updater Server Power Up : Port 2003\n\n");
        
        log_area.append("Profit Updater Server Power Up : Port 2001\n\n");
        
        log_area.append("Table Send Server Power Up : Port 2005\n\n");
        
        log_area.append("Push Service Server Power Up : Port 2004\n\n");
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
        Summery setup9 = new Summery();
        
        setup9.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed


public class Updater implements Runnable
{
   ServerSocket socket1;
    
   Connection conn = null;

   PreparedStatement pst = null;
   
   ResultSet rs = null;
   
   int port = 2000;
 
    @Override
    public void run() 
    {
        try {
            socket1 = new ServerSocket(port);

            System.out.println("server is now ready....");
                        
            log_area.append("Server is now ready for Bidding \n\n");
            
            while (true) {
                Socket clientconnection = socket1.accept();

                System.out.println("Client OK !!");
                                
                Thread.sleep(0);

                Handler handler1 = new Handler(clientconnection);

                handler1.start();
            }
        } 
        catch (IOException | InterruptedException ioe) 
        {
            System.out.println("error");
            
            log_area.append("Error :"+ioe+"\n\n");
        }
    }
    
    class Handler extends Thread // Class Handler
    {
        ObjectInputStream in = null;

        ObjectOutputStream out = null;

        public Handler(Socket request)
        {
            try 
            {
                in = new ObjectInputStream(request.getInputStream());

                out = new ObjectOutputStream(request.getOutputStream());
            } 
            catch (IOException io) 
            {
                System.out.println("can't take i/o stream");
                
                log_area.append("Error :"+io+"\n\n");
                
                
            }
        }
        public void run( )
        {
            try{
                while(true)
                {
                    Publisher  p1=(Publisher)in.readObject();

                    Connection conn = null;

                    PreparedStatement pst = null;

                    db_conn db = new db_conn();

                    conn = db.connect();
                    
                    String symbol = p1.SYMBOL;
                    
                    String price = p1.PRICE;
                    
                    String id = p1.user;
                    
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

                    Date date = new Date();
                    
                    String time_details = formatter.format(date);
                    
                    log_area.append(time_details+"\n\nNew Bidding\n"+id+" DO New Bidding For "+symbol+"\nPrice:"+price+"\n\n");
                    
                    String SQL = "SELECT PRICE FROM Data WHERE SYMBOL = '"+symbol+"'";
                    
                     ResultSet rs = null;
                     
                    try 
                    {
                        Statement stmt = conn.createStatement();
            
                        rs = stmt.executeQuery(SQL);
  
                        while(rs.next())
                        {
                             String string_value = rs.getString("PRICE");
                             
                             float int_value = Float.parseFloat(string_value);
                             
                             String bidding_value0 = price;
                             
                             float bidding_value1 = Float.parseFloat(bidding_value0);
                             
                             if(bidding_value1 > int_value)
                             {
                                PreparedStatement stat1= conn.prepareStatement("UPDATE Data SET PRICE='"+price+"' WHERE SYMBOL = '"+symbol+"'");
                                
                                PreparedStatement stat2= conn.prepareStatement("UPDATE Bidding_Data SET Price='"+price+"',Bidder = '"+id+"' WHERE SYMBOL = '"+symbol+"'");
                                
                                int ko = stat2.executeUpdate();

                                int k = stat1.executeUpdate();
                                                            
                                if(k == 1)
                                {
                                    out.writeObject("Bidding successfully Saved!");
                                    
                                    log_area.append("Bid Accept\nUser Name :"+id+"\nBidding Status :"+symbol+" Value "+string_value+" < "+price+"");
                                    
                                    Bidding_logs log = new Bidding_logs();
                                    
                                    String file_name = "accept_log.txt";
                                    
                                    Subscribers_Handler my_obj = new Subscribers_Handler();
                                    
                                    my_obj.Subscribers(id,symbol);
                                    
                                    log.bid_backup(file_name,id,time_details,symbol,price);
                                }
                                else
                                {
                                    out.writeObject("System Error!!");
                                }                    
                             }
                             else
                             {
                                 out.writeObject("Fail : Bid Move to Trash");
                                 
                                 log_area.append("Bid Move to Trash\nUser Name :"+id+"\nBidding Status :"+symbol+" Value "+string_value+" > "+price+"");
                                 
                                String file_name1 = "reject_log.txt";
                                
                                Bidding_logs log = new Bidding_logs();
                                    
                                log.bid_backup(file_name1,id,time_details,symbol,price);
                             }                            
                        }
                    }
                    
                    catch(IOException | NumberFormatException | SQLException ex)
                    {
                        out.writeObject("Error :"+ex);
                        
                        System.out.print(ex);
                    }                                                  
                }                        
            }
            catch(IOException | ClassNotFoundException ee)
            {
                try
                {
                    out.writeObject("Something Wrong");
                }
                catch(IOException Error)
                {
                    System.out.print("Error Code : "+Error);
                }
            }
        }
    }
}
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTextArea log_area;
    public static javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}


