package dao;

import java.util.ArrayList;


import java.sql.ResultSet;

import models.Book;
import models.ConnectionSqlite;
public class CategoryDao {
	public static ArrayList<Book> listBooks = new ArrayList<>();
    	
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
					book.setBprice(rs.getInt(4));
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
					book.setBprice(rs.getInt(4));
					book.setImage(rs.getString(5));
					listBooks.add(book);
				}rs.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		
		return listBooks;
	}	
	
	public ArrayList<Book> showBooks_study(){
		String sql = "Select CategoryBook.BID, Btitle, Bauthor, Bprice, Image From Book, CategoryBook Where Book.BID = CategoryBook.BID AND CTID = 'STUDY'";
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
					listBooks.add(book);
				}rs.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		
		return listBooks;
	}	
	
	
	public ArrayList<Book> showBooks_life(){
		String sql = "Select CategoryBook.BID, Btitle, Bauthor, Bprice, Image From Book, CategoryBook Where Book.BID = CategoryBook.BID AND CTID = 'SELFHELP'";
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
					listBooks.add(book);
				}rs.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		
		return listBooks;
	} 
	
	public ArrayList<Book> showBooks_bestSeller(){
		 String sql = "Select * From Book ORDER BY RANDOM()";
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
					book.setBprice(rs.getInt(4));
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
					book.setBprice(rs.getInt(4));
					book.setImage(rs.getString(5));
					listBooks.add(book);
				}rs.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		
		return listBooks;
	}
	
	
	
}
