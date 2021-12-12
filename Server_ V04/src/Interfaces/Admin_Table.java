package Interfaces;

import JDBC.db_conn;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.logging.Level;

import java.util.logging.Logger;

import net.proteanit.sql.DbUtils;


public class Admin_Table extends javax.swing.JFrame {


   Connection conn = null;

   PreparedStatement pst = null;
   
   ResultSet rs = null;
   
   
    public Admin_Table() throws SQLException 
    {
        initComponents();
        
          conn = db_conn.connect();
       
          System.out.print("Data Base OK !!");
          
          table_load();
    }
    
    
    public void table_load() throws SQLException // That method load database data to jtable
    {
        String sql = "SELECT * FROM Admin";

        pst = conn.prepareStatement(sql);
        
        rs = pst.executeQuery();
        
        table.setModel(DbUtils.resultSetToTableModel(rs));
    }
        
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 14)); // NOI18N
        table.setForeground(new java.awt.Color(51, 51, 51));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6"
            }
        ));
        jScrollPane1.setViewportView(table);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 753, 274));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/360_F_338389344_7yiAzAQt5vs7hY3ui4pxtnomXobybJbY.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 50));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) 
    {

        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                try 
                {
                    new Admin_Table().setVisible(true);
                } 
                catch (SQLException ex) 
                {
                    Logger.getLogger(Admin_Table.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
