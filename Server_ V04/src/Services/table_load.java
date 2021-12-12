package Services;

import JDBC.db_conn;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import Interfaces.Bidding_Home;

import static Interfaces.Bidding_Home.table;

import net.proteanit.sql.DbUtils;


public class table_load 
{
    
   Connection conn = null;

   PreparedStatement pst = null;
   
   ResultSet rs = null;
   
    public void table_load() throws SQLException // That method load database data to jtable
    {
        conn = db_conn.connect();
       
        System.out.print("Data Base OK !!");
        
        String sql = "SELECT * FROM Data";

        pst = conn.prepareStatement(sql);
        
        rs = pst.executeQuery();
        
        table.setModel(DbUtils.resultSetToTableModel(rs));
    }
    
}
