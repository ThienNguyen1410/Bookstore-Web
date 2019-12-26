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
	public int saleOffBook(String BID,int saleOffPercents) {
		String sql ="Select Bprice from Book Where BID ='"+BID+"' ";
		
		int saleOffPrice = 0 ;
		try {
			ResultSet rs = new ConnectionSqlite().choseData(sql);
			while(rs.next()) {
				Book bookSale = new Book();
				saleOffPrice = bookSale.getBprice() - ((bookSale.getBprice() * saleOffPercents)/100);
				}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return saleOffPrice;
		
		

		
	}

}
