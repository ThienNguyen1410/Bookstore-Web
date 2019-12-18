package com.sqlite.connect;

import java.sql.SQLException;

import models.ConnectionSqlite;

public class tryInsert {

	public static void main(String[] args) {
		String sql ="Insert into 'Order' values ('avb',1,20000)";
		String sql1 = "Insert into 'Cart' (CID,OID,UID,Bill,Dates) values (1,'avb',2,20000,22122019)";
		try {
	        new ConnectionSqlite().excuteSql(sql);
	        new ConnectionSqlite().excuteSql(sql1);
	        } 
	        catch ( SQLException se ) {
	            System.out.println("SQL Exception:" + se.getMessage() );
	         }
	         catch ( Exception e ) {
	             System.out.println("Exception:" + e.getMessage() );
	          }
	}

}
