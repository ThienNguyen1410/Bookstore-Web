package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Book;
import models.ConnectionSqlite;

public class AdminDao {
	public static ArrayList<Book> listBooks = new ArrayList<>();
	
	public boolean adminLogin (String name, String pass) {
		String sql = "Select Aname, Apass From Admin Where Aname ='"+name+"' AND Apass='"+pass+"'";
		try {
			ResultSet rs = new ConnectionSqlite().choseData(sql);
			 
			if(rs.next()){
				return true;
			}
			rs.close();
		} catch ( SQLException se ) {
            System.out.println("SQL adminLogin Exception:" + se.getMessage() );
         }
         catch ( Exception e ) {
             System.out.println("Exception:" + e.getMessage() );
          }
		return false;
	}
	
	public boolean InsertadminBook (String AID, String BID, String function, String time, int Date) {
		String sql = "insert into AdminBook (Aname, BID, function, time, Date) values ('"+AID+"','"+BID+"','"+function+"','"+time+"',"+Date+")";
		try {
			new ConnectionSqlite().excuteSql(sql);
			return true;
		}
		catch ( SQLException se ) {
            System.out.println("SQL InsertadminBook Exception:" + se.getMessage() );
         }
         catch ( Exception e ) {
             System.out.println("Exception:" + e.getMessage() );
          }
		return false;
	}
	
	public ArrayList<Book> showBooks_newRelease(){
		 String sql = "select * from Book order by BID desc";
		 listBooks = new ArrayList<>();
			try {
				ResultSet rs = new ConnectionSqlite().choseData(sql);
				 
				while(rs.next()){
					Book book = new Book();
					book.setBID(rs.getString(1));
					book.setBtitle(rs.getString(2));
					book.setBauthor(rs.getString(3));
					book.setBprice(rs.getInt(4));
					book.setImage(rs.getString(5));
					book.setQuantity(rs.getInt(6));
					listBooks.add(book);
					
				}
				rs.close();
			} catch ( SQLException se ) {
	            System.out.println("SQL showBooks_newRelease Exception:" + se.getMessage() );
	         }
	         catch ( Exception e ) {
	             System.out.println("Exception:" + e.getMessage() );
	          }
		
		return listBooks;
	}
	
	public boolean selectIfExist(String BID, String Btitle, String Bauthor) {
		String sql ="Select BID, Btitle, Bauthor From Book where BID='"+BID+"' AND Btitle='"+Btitle+"' AND Bauthor='"+Bauthor+"'";
		try {
			ResultSet rs = new ConnectionSqlite().choseData(sql);
			while(rs.next()) {
				rs.close();
				return true;
			}
		}
		catch ( SQLException se ) {
            System.out.println("SQL selectIfExist Exception:" + se.getMessage() );
         }
         catch ( Exception e ) {
             System.out.println("Exception:" + e.getMessage() );
          }
		return false;
	}
	
	public boolean selectIfExistForUpdate(String BID) {
		String sql ="Select BID, Btitle, Bauthor From Book where BID='"+BID+"'";
		try {
			ResultSet rs = new ConnectionSqlite().choseData(sql);
			while(rs.next()) {
				rs.close();
				return true;
			}
		}
		catch ( SQLException se ) {
            System.out.println("SQL selectIfExist Exception:" + se.getMessage() );
         }
         catch ( Exception e ) {
             System.out.println("Exception:" + e.getMessage() );
          }
		return false;
	}
	
	public boolean insertIfNotExist(String BID, String Btitle, String Bauthor, int Bprice, String Image, int Quantity) {
		String sql = "insert into Book (BID, Btitle, Bauthor, Bprice, Image, Quantity) values ('"+BID+"','"+Btitle+"','"+Bauthor+"',"+Bprice+",'"+Image+"',"+Quantity+")";
		try {
			new ConnectionSqlite().excuteSql(sql);
			return true;
		}
		catch ( SQLException se ) {
            System.out.println("SQL selectIfExist Exception:" + se.getMessage() );
         }
         catch ( Exception e ) {
             System.out.println("Exception:" + e.getMessage() );
          }
		
		return false;
	}
	
	
	public boolean DeleteExist(String BID, String Btitle, String Bauthor) {
		String sql = "Delete From Book where BID='"+BID+"' AND Btitle='"+Btitle+"' AND Bauthor='"+Bauthor+"'";
		try {
			new ConnectionSqlite().update(sql);
			return true;
		}
		catch ( SQLException se ) {
            System.out.println("SQL DeleteExist Exception:" + se.getMessage() );
         }
         catch ( Exception e ) {
             System.out.println("Exception:" + e.getMessage() );
          }
		return false;
	}
	
	public boolean UpdateExist(String BID, int Quantity) {
		String sql = "Update Book Set Quantity="+Quantity+" where BID='"+BID+"'";
		try {
			new ConnectionSqlite().update(sql);
			return true;
		}
		catch ( SQLException se ) {
            System.out.println("SQL UpdateExist Exception:" + se.getMessage() );
         }
         catch ( Exception e ) {
             System.out.println("Exception:" + e.getMessage() );
          }
		return false;
	}
}
