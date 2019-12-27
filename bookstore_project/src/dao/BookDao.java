package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Book;
import models.ConnectionSqlite;

public class BookDao {
	public static ArrayList<Book> listBooks = new ArrayList<>();
	
	public ArrayList<Book> sameAuthor(String author){
		 String sql = "Select * From Book where Bauthor='"+author+"' ORDER BY RANDOM() LIMIT 15";
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
				}rs.close();
			} catch ( SQLException se ) {
	            System.out.println("SQL sameAuthor Exception:" + se.getMessage() );
	         }
	         catch ( Exception e ) {
	             System.out.println("Exception:" + e.getMessage() );
	          }
		
		return listBooks;
	}
	
	public ArrayList<Book> sameCategory(String category){
		 String sql = "Select Book.BID, Btitle, Bauthor, Bprice, Image, Quantity From Book, CategoryBook where Book.BID=CategoryBook.BID AND CategoryBook.CTID='"+category+"' LIMIT 15";
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
				}rs.close();
			} catch ( SQLException se ) {
	            System.out.println("SQL sameCategory Exception:" + se.getMessage() );
	         }
	         catch ( Exception e ) {
	             System.out.println("Exception:" + e.getMessage() );
	          }
		
		return listBooks;
	}
	
	public ArrayList<Book> selectBookAfterPay(){
		 String sql = "Select Book.BID, Book.Quantity, UserCartBook.Quantity From Book, UserCartBook where Book.BID=UserCartBook.BID";
		 listBooks = new ArrayList<>();
			try {
				ResultSet rs = new ConnectionSqlite().choseData(sql);
				 
				while(rs.next()){
					Book book = new Book();
					book.setBID(rs.getString(1));
					book.setQuantity(rs.getInt(2));
					book.setQuantityOrder(rs.getInt(3));
					listBooks.add(book);
				}rs.close();
			} catch ( SQLException se ) {
	            System.out.println("SQL selectBookAfterPay Exception:" + se.getMessage() );
	         }
	         catch ( Exception e ) {
	             System.out.println("Exception:" + e.getMessage() );
	          }
		
		return listBooks;
	}
	
	public void updateQuanAfterPay(int Quan, String BID){
		String sql ="Update Book Set Quantity ="+Quan+" Where BID ='"+BID+"'";
		try {
			new ConnectionSqlite().update(sql);
		} catch ( SQLException se ) {
            System.out.println("SQL updateQuanAfterPay Exception:" + se.getMessage() );
         }
         catch ( Exception e ) {
             System.out.println("Exception:" + e.getMessage() );
          }
		
	}
	
	public ArrayList<Book> showBooks_children(){
		 String sql = "Select Book.BID, Btitle, Bauthor, Bprice, Image, Quantity, Sale From Book, CategoryBook where Book.BID = CategoryBook.BID AND CTID ='CHILDREN'";
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
					book.setSaleOffPercent(rs.getInt(7));
					book.setSaleOffPrice(book.getBprice()-((book.getBprice()*book.getSaleOffPercent())/100));
					listBooks.add(book);
				}rs.close();
			} catch ( SQLException se ) {
	            System.out.println("SQL showBooks_children Exception:" + se.getMessage() );
	         }
	         catch ( Exception e ) {
	             System.out.println("Exception:" + e.getMessage() );
	          }
		
		return listBooks;
	}
	
	public ArrayList<Book> showBooks_newRelease(){
		 String sql = "select * from Book order by BID desc;";
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
					book.setSaleOffPercent(rs.getInt(7));
					book.setSaleOffPrice(book.getBprice()-((book.getBprice()*book.getSaleOffPercent())/100));
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
	
	public ArrayList<Book> showBooks_bestSeller(){
		 String sql = "Select BID, Btitle, Bauthor, Bprice, Image, Quantity, Sale From Book ORDER BY RANDOM()";
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
					book.setSaleOffPercent(rs.getInt(7));
					book.setSaleOffPrice(book.getBprice()-((book.getBprice()*book.getSaleOffPercent())/100));
					listBooks.add(book);
				}rs.close();
			} catch ( SQLException se ) {
	            System.out.println("SQL showBooks_bestSeller Exception:" + se.getMessage() );
	         }
	         catch ( Exception e ) {
	             System.out.println("Exception:" + e.getMessage() );
	          }
		
		return listBooks;
	}
	
	public ArrayList<Book> showBooks_novel(){
		 String sql = "Select Book.BID, Btitle, Bauthor, Bprice, Image, Quantity, Sale From Book, CategoryBook where Book.BID = CategoryBook.BID AND CTID ='NOVEL'";
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
					book.setSaleOffPercent(rs.getInt(7));
					book.setSaleOffPrice(book.getBprice()-((book.getBprice()*book.getSaleOffPercent())/100));
					listBooks.add(book);
				}rs.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		
		return listBooks;
	}
	
	public ArrayList<Book> showBooks_art(){
		 String sql = "Select Book.BID, Btitle, Bauthor, Bprice, Image, Quantity, Sale From Book, CategoryBook where Book.BID = CategoryBook.BID AND CTID ='ART'";
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
					book.setSaleOffPercent(rs.getInt(7));
					book.setSaleOffPrice(book.getBprice()-((book.getBprice()*book.getSaleOffPercent())/100));
					listBooks.add(book);
				}rs.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		
		return listBooks;
	}
	
	public ArrayList<Book> showBooks_life(){
		 String sql = "Select Book.BID, Btitle, Bauthor, Bprice, Image, Quantity, Sale From Book, CategoryBook where Book.BID = CategoryBook.BID AND CTID ='SELFHELP'";
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
					book.setSaleOffPercent(rs.getInt(7));
					book.setSaleOffPrice(book.getBprice()-((book.getBprice()*book.getSaleOffPercent())/100));
					listBooks.add(book);
				}rs.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		
		return listBooks;
	}
	
	public ArrayList<Book> showBooks_study(){
		 String sql = "Select Book.BID, Btitle, Bauthor, Bprice, Image, Quantity, Sale From Book, CategoryBook where Book.BID = CategoryBook.BID AND CTID ='STUDY'";
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
					book.setSaleOffPercent(rs.getInt(7));
					book.setSaleOffPrice(book.getBprice()-((book.getBprice()*book.getSaleOffPercent())/100));
					listBooks.add(book);
				}rs.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		
		return listBooks;
	}
	
}
