package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import models.Book;
import models.ConnectionSqlite;

public class SearchDao {
    private static ArrayList<Book> searchBooks;

	public static ArrayList<Book> getSearchBooks() {
		return searchBooks;
	}

	public static void setSearchBooks(ArrayList<Book> searchBooks) {
		SearchDao.searchBooks = searchBooks;
	}
    
	public ArrayList<Book> searchView(String Btitle){
		String sql = "Select BID, Btitle, Bauthor, Bprice, Image, Quantity, Sale from Book where Btitle Like '"+Btitle+"%'";
		searchBooks=new ArrayList<Book>();
		ResultSet rs = null;
        
        try { 
      	  rs = new ConnectionSqlite().choseData(sql); 
      	  while(rs.next()) {
      		  Book book = new Book();
      		  book.setBID(rs.getString(1));
      		  book.setBtitle(rs.getString(2));
      		  book.setBauthor(rs.getString(3));
      		  book.setBprice(rs.getInt(4));
      		  book.setImage(rs.getString(5));
      		  book.setQuantity(rs.getInt(6));
      		  book.setSaleOffPercent(rs.getInt(7));
			  book.setSaleOffPrice(book.getBprice()-((book.getBprice()*book.getSaleOffPercent())/100));
      		  searchBooks.add(book);
      	  }
      	  
        }
        
        catch ( SQLException se ) {
            System.out.println("SQL Exception:" + se.getMessage() );
         }
         catch ( Exception e ) {
             System.out.println("Exception:" + e.getMessage() );
          }
		
		return searchBooks;
	}
}
