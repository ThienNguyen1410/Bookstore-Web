package dao;


import java.sql.ResultSet;
import java.util.ArrayList;
import models.ConnectionSqlite;
import models.Book;

public class WishListDao {
    private static ArrayList<Book> wishBooks;

	public static ArrayList<Book> getWishBooks() {
		return wishBooks;
	}

	public static void setWishBooks(ArrayList<Book> wishBooks) {
		WishListDao.wishBooks = wishBooks;
	}
    
    public ArrayList<Book> viewWishList(String UserName){
    	String sql = "Select WishList.BID, Image, Btitle, Bprice, Quantity, Sale From WishList, Book Where UserName = '"+UserName+"' AND WishList.BID = Book.BID";
    	wishBooks = new ArrayList<>();
    	try {
			ResultSet rs = new ConnectionSqlite().choseData(sql);
			 
			while(rs.next()){
				Book book = new Book();
				book.setBID(rs.getString(1));
				book.setImage(rs.getString(2));
				book.setBtitle(rs.getString(3));
				book.setBprice(rs.getInt(4));
				book.setQuantity(rs.getInt(5));
				book.setSaleOffPercent(rs.getInt(6));
				book.setSaleOffPrice(book.getBprice()-((book.getBprice()*book.getSaleOffPercent())/100));
				wishBooks.add(book);
			}
		rs.close(); 
		}
    	catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
    	
	return wishBooks;
    }
}
