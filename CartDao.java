package dao;

import java.util.ArrayList;


import java.sql.ResultSet;
import java.sql.SQLException;

import models.Book;
import models.ConnectionSqlite;

public class CartDao {
    public static ArrayList<Book> listBooks = new ArrayList<>();
    public static ArrayList<Book> cartBooks = new ArrayList<>();
    
    public CartDao() {
    	String sql = "Select * From Book";
		 listBooks = new ArrayList<>();
			try {
				ResultSet rs = new ConnectionSqlite().choseData(sql);
				 
				while(rs.next()){
					Book book = new Book();
					book.setBID(rs.getString(1));
					book.setBtitle(rs.getString(2));
					book.setBauthor(rs.getString(3));
					book.setBprice(rs.getDouble(4));
					book.setImage(rs.getString(5));
					book.setQuantity(1);
					listBooks.add(book);
				}rs.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
    }
    
    public ArrayList<Book> getListBooks() {
		return listBooks;
	}

	public void setListBooks(ArrayList<Book> listBooks) {
		CartDao.listBooks = listBooks;
	}

	public  ArrayList<Book> getCartBooks() {
		return cartBooks;
	}

	public void setCartBooks(ArrayList<Book> cartBooks) {
		CartDao.cartBooks = cartBooks;
	}
	
	public ArrayList<Book> showBooks_novel(){
		 String sql = "Select CategoryBook.BID, Btitle, Bauthor, Bprice, Image From Book, CategoryBook Where Book.BID = CategoryBook.BID AND CTID = 'NOVEL'";
		 listBooks = new ArrayList<>();
			try {
				ResultSet rs = new ConnectionSqlite().choseData(sql);
				 
				while(rs.next()){
					Book book = new Book();
					book.setBID(rs.getString(1));
					book.setBtitle(rs.getString(2));
					book.setBauthor(rs.getString(3));
					book.setBprice(rs.getDouble(4));
					book.setImage(rs.getString(5));
					listBooks.add(book);
				}rs.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		
		return listBooks;
	}
	public ArrayList<Book> showBooks_art(){
		String sql = "Select CategoryBook.BID, Btitle, Bauthor, Bprice, Image From Book, CategoryBook Where Book.BID = CategoryBook.BID AND CTID = 'ART'";
		 listBooks = new ArrayList<>();
			try {
				ResultSet rs = new ConnectionSqlite().choseData(sql);
				 
				while(rs.next()){
					Book book = new Book();
					book.setBID(rs.getString(1));
					book.setBtitle(rs.getString(2));
					book.setBauthor(rs.getString(3));
					book.setBprice(rs.getDouble(4));
					book.setImage(rs.getString(5));
					listBooks.add(book);
				}rs.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		
		return listBooks;
	}	public ArrayList<Book> showBooks_study(){
		String sql = "Select CategoryBook.BID, Btitle, Bauthor, Bprice, Image From Book, CategoryBook Where Book.BID = CategoryBook.BID AND CTID = 'STUDY'";
		 listBooks = new ArrayList<>();
			try {
				ResultSet rs = new ConnectionSqlite().choseData(sql);
				 
				while(rs.next()){
					Book book = new Book();
					book.setBID(rs.getString(1));
					book.setBtitle(rs.getString(2));
					book.setBauthor(rs.getString(3));
					book.setBprice(rs.getDouble(4));
					book.setImage(rs.getString(5));
					listBooks.add(book);
				}rs.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		
		return listBooks;
	}	public ArrayList<Book> showBooks_life(){
		String sql = "Select CategoryBook.BID, Btitle, Bauthor, Bprice, Image From Book, CategoryBook Where Book.BID = CategoryBook.BID AND CTID = 'SELFHELP'";
		 listBooks = new ArrayList<>();
			try {
				ResultSet rs = new ConnectionSqlite().choseData(sql);
				 
				while(rs.next()){
					Book book = new Book();
					book.setBID(rs.getString(1));
					book.setBtitle(rs.getString(2));
					book.setBauthor(rs.getString(3));
					book.setBprice(rs.getDouble(4));
					book.setImage(rs.getString(5));
					listBooks.add(book);
				}rs.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		
		return listBooks;
	} 
	
	public ArrayList<Book> showBooks_bestSeller(){
		 String sql = "Select * From Book ORDER BY RANDOM() LIMIT 15";
		 listBooks = new ArrayList<>();
			try {
				ResultSet rs = new ConnectionSqlite().choseData(sql);
				 
				while(rs.next()){
					Book book = new Book();
					book.setBID(rs.getString(1));
					book.setBtitle(rs.getString(2));
					book.setBauthor(rs.getString(3));
					book.setBprice(rs.getDouble(4));
					book.setImage(rs.getString(5));
					listBooks.add(book);
				}rs.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		
		return listBooks;
	}
	
	public ArrayList<Book> showBooks_best2019(){
		 String sql = "SELECT * FROM Book ORDER BY RANDOM() LIMIT 15";
		 listBooks = new ArrayList<>();
			try {
				ResultSet rs = new ConnectionSqlite().choseData(sql);
				 
				while(rs.next()){
					Book book = new Book();
					book.setBID(rs.getString(1));
					book.setBtitle(rs.getString(2));
					book.setBauthor(rs.getString(3));
					book.setBprice(rs.getDouble(4));
					book.setImage(rs.getString(5));
					listBooks.add(book);
				}rs.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		
		return listBooks;
	}
	
	public ArrayList<Book> showBooks_newRelease(){
		 String sql = "select * from Book order by BID desc LIMIT 15;";
		 listBooks = new ArrayList<>();
			try {
				ResultSet rs = new ConnectionSqlite().choseData(sql);
				 
				while(rs.next()){
					Book book = new Book();
					book.setBID(rs.getString(1));
					book.setBtitle(rs.getString(2));
					book.setBauthor(rs.getString(3));
					book.setBprice(rs.getDouble(4));
					book.setImage(rs.getString(5));
					listBooks.add(book);
					
				}
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		
		return listBooks;
	}
	
	public ArrayList<Book> showBooks_children(){
		String sql = "Select CategoryBook.BID, Btitle, Bauthor, Bprice, Image From Book, CategoryBook Where Book.BID = CategoryBook.BID AND CTID = 'CHILDREN'";
		 listBooks = new ArrayList<>();
			try {
				ResultSet rs = new ConnectionSqlite().choseData(sql);
				 
				while(rs.next()){
					Book book = new Book();
					book.setBID(rs.getString(1));
					book.setBtitle(rs.getString(2));
					book.setBauthor(rs.getString(3));
					book.setBprice(rs.getDouble(4));
					book.setImage(rs.getString(5));
					listBooks.add(book);
				}rs.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		
		return listBooks;
	}
	
	public void createCIDforDB(String UserName) {
		
		String sql = "insert into Cart (CID) values ('"+UserName+"')";
		try {
			new ConnectionSqlite().excuteSql(sql);
		} catch ( SQLException se ) {
            System.out.println("SQL Exception:" + se.getMessage() );
         }
         catch ( Exception e ) {
             System.out.println("Exception:" + e.getMessage() );
          }
	}
	
	public void insertCart (int UID, String CID, String BID) {
		String sql = "Insert into UserCartBook (UID, CID, BID, Quantity) values ("+UID+",'"+CID+"','"+BID+"',1)";
		try {
			new ConnectionSqlite().excuteSql(sql);;	
		} catch ( SQLException se ) {
            System.out.println("SQL Exception:" + se.getMessage() );
         }
         catch ( Exception e ) {
             System.out.println("Exception:" + e.getMessage() );
          }
	}

	public ArrayList<Book> cartShow(String UserName){
		 String sql = "Select Book.Image, Book.Btitle, Book.Bprice, UserCartBook.Quantity, Book.BID From Book, Cart, UserCartBook Where Book.BID = UserCartBook.BID AND Cart.CID='"+UserName+"' AND Cart.CID = UserCartBook.CID ";
		 listBooks = new ArrayList<>();
			try {
				ResultSet rs = new ConnectionSqlite().choseData(sql);
				 
				while(rs.next()){
					Book book = new Book();
					book.setImage(rs.getString(1));
					book.setBtitle(rs.getString(2));
					book.setBprice(rs.getDouble(3)*rs.getInt(4));
					book.setQuantity(rs.getInt(4));
					book.setBID(rs.getString(5));
					listBooks.add(book);	
				}
				rs.close();
			} catch ( SQLException se ) {
	            System.out.println("SQL Exception:" + se.getMessage() );
	         }
	         catch ( Exception e ) {
	             System.out.println("Exception:" + e.getMessage() );
	          }
		
		return listBooks;
	}
	
	public boolean updateQuan(int Quan, String itemID, String Cid) {
		String sql = "Update UserCartBook set Quantity ="+Quan+" Where BID ='"+itemID+"' AND CID ='"+Cid+"'";
		try {
			new ConnectionSqlite().update(sql);
           return true;	
		} catch ( SQLException se ) {
            System.out.println("SQL Exception:" + se.getMessage() );
         }
         catch ( Exception e ) {
             System.out.println("Exception:" + e.getMessage() );
          }
		return false;
	}
	
	public void quantityZero(String itemID, String Cid) {
		String sql = "Delete From UserCartBook Where BID ='"+itemID+"' AND CID ='"+Cid+"'";
		try {
			new ConnectionSqlite().update(sql);
		} catch ( SQLException se ) {
            System.out.println("SQL Exception:" + se.getMessage() );
         }
         catch ( Exception e ) {
             System.out.println("Exception:" + e.getMessage() );
          }
	}
	
	public void deleteAllCart(String Cid) {
		String sql = "Delete From UserCartBook Where CID ='"+Cid+"'";
		try {
			new ConnectionSqlite().update(sql);
		} catch ( SQLException se ) {
            System.out.println("SQL Exception:" + se.getMessage() );
         }
         catch ( Exception e ) {
             System.out.println("Exception:" + e.getMessage() );
          }
	}
	
}
