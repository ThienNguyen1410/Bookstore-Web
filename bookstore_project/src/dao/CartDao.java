 package dao;

import java.util.ArrayList;

import com.sqlite.connect.RandomString;

import java.sql.ResultSet;

import models.Book;
import models.Cart;
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
				}rs.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		
		return listBooks;
	}
	
	public ArrayList<Book> showBooks_children(){
		 String sql = "Select * From Book LIMIT 15";
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
	
	public boolean createCIDforDB() {
        Cart cart = new Cart();
		
		RandomString rand = new RandomString();
		cart.setCID(rand.randomAlphaNumeric(4));
		String CID = cart.getCID();
		
		String sql = "insert into Cart (CID) values ('"+CID+"')";
		try {
			new ConnectionSqlite().excuteSql(sql);
            return true;	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	
}
