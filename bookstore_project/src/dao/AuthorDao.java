package dao;

import java.util.ArrayList;

import java.sql.ResultSet;

import models.Book;
import models.ConnectionSqlite;

public class AuthorDao {
    public static ArrayList<Book> authorBooks = new ArrayList<>();

        public ArrayList<Book> showBooks_author( String Bauthor){
		 String sql = "Select * From Book WHERE Bauthor ='"+Bauthor+"'";
		 authorBooks = new ArrayList<>();
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
					authorBooks.add(book);
				}rs.close();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
		
		return authorBooks;
	}
}