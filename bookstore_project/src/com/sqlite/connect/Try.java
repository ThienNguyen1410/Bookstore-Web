package com.sqlite.connect;

import java.sql.*;
public class Try {

    public static void main(String[] args) {
        Connection c = null;
        PreparedStatement ps1 = null;
        ResultSet rs = null;
        try {
         Class.forName("org.sqlite.JDBC");
         c = DriverManager.getConnection("jdbc:sqlite:E:\\eclipe_workspace\\bookstore_project\\WebContent\\CustomerDatabase.db");
         c.setAutoCommit(false);
         System.out.println("Opened database successfully");
            
         String query = "Select * from User ";
         ps1 = c.prepareStatement(query);
         rs = ps1.executeQuery();
         while(rs.next()){
         int id = rs.getInt(1);
         String user   = rs.getString(2);
         String mail   = rs.getString(3);
         String name   = rs.getString(4);
         String pass   = rs.getString(5);
         
         System.out.println( "id = " + id );
         System.out.println( "name  = " + name  );
         System.out.println( "user  = " + user  );
         System.out.println( "mail  = " + mail  );
         System.out.println( "pass  = " + pass  );
         System.out.println();
         }
         rs.close();
         ps1.close();
         c.close();
        } 
        catch ( SQLException se ) {
            System.out.println("SQL Exception:" + se.getMessage() );
         }
         catch ( Exception e ) {
             System.out.println("Exception:" + e.getMessage() );
          }

    }
    
}
