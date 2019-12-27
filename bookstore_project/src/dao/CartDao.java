 package dao;

import java.util.ArrayList;


import java.sql.ResultSet;
import java.sql.SQLException;

import models.Book;
import models.ConnectionSqlite;
import models.HistoryGet;
import models.Order;

public class CartDao {
    public static ArrayList<Book> listBooks = new ArrayList<>();
    public static ArrayList<Book> cartBooks = new ArrayList<>();
    public static ArrayList<Order> listOrder = new ArrayList<Order>();
    public static ArrayList<HistoryGet> listHistory = new ArrayList<HistoryGet>();
    
    
    
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
					book.setBprice(rs.getInt(4));
					book.setImage(rs.getString(5));
					book.setQuantity(rs.getInt(6));
					listBooks.add(book);
				}rs.close();
			} catch ( SQLException se ) {
				se.printStackTrace();
	            System.out.println("SQL CartDao Exception:" + se.getMessage() );
	         }
	         catch ( Exception e ) {
	             System.out.println("Exception:" + e.getMessage() );
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
		 String sql = "Select BID, Btitle, Bauthor, Bprice, Image, Quantity, Sale From Book ORDER BY RANDOM() LIMIT 15";
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
	
	public ArrayList<Book> showBooks_best2019(){
		String sql = "Select BID, Btitle, Bauthor, Bprice, Image, Quantity, Sale From Book ORDER BY RANDOM() LIMIT 15";
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
	            System.out.println("SQL showBooks_best2019 Exception:" + se.getMessage() );
	         }
	         catch ( Exception e ) {
	             System.out.println("Exception:" + e.getMessage() );
	          }
		
		return listBooks;
	}
	
	public ArrayList<Book> showBooks_newRelease(){
		 String sql = "Select BID, Btitle, Bauthor, Bprice, Image, Quantity, Sale from Book order by BID desc LIMIT 15;";
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
	
	public ArrayList<Book> showBooks_children(){
		 String sql = "Select Book.BID, Btitle, Bauthor, Bprice, Image, Quantity, Sale From Book, CategoryBook where Book.BID = CategoryBook.BID AND CTID ='CHILDREN' LIMIT 15";
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
	
	public void createCIDforDB(String UserName) {
		
		String sql = "insert into Cart (CID) values ('"+UserName+"')";
		try {
			new ConnectionSqlite().excuteSql(sql);
		} catch ( SQLException se ) {
            System.out.println("SQL createCIDforDB Exception:" + se.getMessage() );
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
            System.out.println("SQL insertCart Exception:" + se.getMessage() );
         }
         catch ( Exception e ) {
             System.out.println("Exception:" + e.getMessage() );
          }
	}
	
	public boolean insertOrder (String OID) {
		String sql = "Insert into 'Order' (OID) values ('"+OID+"')";
		try {
			new ConnectionSqlite().excuteSql(sql);
			return true;
		} catch ( SQLException se ) {
            System.out.println("SQL insertOrder Exception:" + se.getMessage() );
         }
         catch ( Exception e ) {
             System.out.println("Exception:" + e.getMessage() );
          }
		return false;
	}
	
	public ArrayList<Order> selectFromUserCart(int UIDint, String CID){
		 String sql = "Select UID, CID, BID, Quantity From UserCartBook Where UID="+UIDint+" AND CID='"+CID+"'";
		 listOrder = new ArrayList<Order>();
			try {
				ResultSet rs = new ConnectionSqlite().choseData(sql);
				 
				while(rs.next()){
					Order order =new Order();
    				order.setUID(rs.getInt(1));
    				order.setOID(rs.getString(2));
    				order.setBID(rs.getString(3));
    				order.setQuantity(rs.getInt(4));
    				listOrder.add(order);
				}rs.close();
			} catch ( SQLException se ) {
	            System.out.println("SQL selectFromUserCart Exception:" + se.getMessage() );
	         }
	         catch ( Exception e ) {
	             System.out.println("Exception:" + e.getMessage() );
	          }
		
		return listOrder;
	}
	
	public boolean insertUserOrder (int UID, String OID, String BID, int Quantity,String time, int Date, String Address) {
		String sql = "Insert into UserOrderBook (UID, OID, BID, Quantity, Time, Dates, Address) values ("+UID+",'"+OID+"','"+BID+"',"+Quantity+",'"+time+"',"+Date+",'"+Address+"')";
		try {
			new ConnectionSqlite().excuteSql(sql);
			return true;
		} catch ( SQLException se ) {
            System.out.println("SQL insertUserOrder Exception:" + se.getMessage() );
         }
         catch ( Exception e ) {
             System.out.println("Exception:" + e.getMessage() );
          }
		return false;
	}
    
	public boolean insertPayment (String PID, String Method, int OTotalBill, String NameCart, String CartDate, String CartNumber, String UserName) {
		String sql = "Insert into Payment (PID, Method, OTotalBill, NameCart, CartDate, CartNumber, UserName) values ('"+PID+"','"+Method+"',"+OTotalBill+",'"+NameCart+"','"+CartDate+"','"+CartNumber+"','"+UserName+"')";
		try {
			new ConnectionSqlite().excuteSql(sql);
			return true;
		} catch ( SQLException se ) {
            System.out.println("SQL insertPayment Exception:" + se.getMessage() );
         }
         catch ( Exception e ) {
             System.out.println("Exception:" + e.getMessage() );
          }
		return false;
	}

	
	public boolean insertPaymentOrder (String PID, String OID) {
		String sql = "Insert into PaymentOrder (PID, OID) values ('"+PID+"','"+OID+"')";
		try {
			new ConnectionSqlite().excuteSql(sql);
			return true;
		} catch ( SQLException se ) {
			se.printStackTrace();
            System.out.println("SQL insertPaymentOrder Exception:" + se.getMessage() );
         }
         catch ( Exception e ) {
             System.out.println("Exception:" + e.getMessage() );
          }
		return false;
	}
	
	public boolean deleteCartAfterPayment (String CID, int UID) {
		String sql = "DELETE FROM UserCartBook Where CID='"+CID+"' AND UID="+UID+"";
		try {
			new ConnectionSqlite().update(sql);
			return true;
		} catch ( SQLException se ) {
            System.out.println("SQL deleteCartAfterPayment Exception:" + se.getMessage() );
         }
         catch ( Exception e ) {
             System.out.println("Exception:" + e.getMessage() );
          }	
		return false;
	}
	
	public ArrayList<Book> cartShow(String UserName){
		 String sql = "Select Book.Image, Book.Btitle, Book.Bprice, UserCartBook.Quantity, Book.BID, Sale From Book, Cart, UserCartBook Where Book.BID = UserCartBook.BID AND Cart.CID='"+UserName+"' AND Cart.CID = UserCartBook.CID ";
		 listBooks = new ArrayList<>();
			try {
				ResultSet rs = new ConnectionSqlite().choseData(sql);
				 
				while(rs.next()){
					Book book = new Book();
					book.setImage(rs.getString(1));
					book.setBtitle(rs.getString(2));
					book.setBprice((rs.getInt(3)-((rs.getInt(3)*rs.getInt(6))/100))*rs.getInt(4));
					book.setQuantity(rs.getInt(4));
					book.setBID(rs.getString(5));
					book.setSaleOffPercent(rs.getInt(6));
					listBooks.add(book);	
				}
				rs.close();
			} catch ( SQLException se ) {
	            System.out.println("SQL cartShow Exception:" + se.getMessage() );
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
            System.out.println("SQL updateQuan Exception:" + se.getMessage() );
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
            System.out.println("SQL quantityZero Exception:" + se.getMessage() );
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
            System.out.println("SQL deleteAllCart Exception:" + se.getMessage() );
         }
         catch ( Exception e ) {
             System.out.println("Exception:" + e.getMessage() );
          }
	}
	
	public ArrayList<HistoryGet> showHistory(String uName){
		 String sql = "Select Payment.PID, Payment.Method, Payment.OTotalBill From Payment, PaymentOrder Where PaymentOrder.OID ='"+uName+"' AND PaymentOrder.PID=Payment.PID";
		 listHistory = new ArrayList<>();
			try {
				ResultSet rs = new ConnectionSqlite().choseData(sql);
				 
				while(rs.next()){
					HistoryGet his = new HistoryGet();
					his.setpID(rs.getString(1));
					his.setpType(rs.getString(2));
					his.setTotalPrice(rs.getInt(3));
					listHistory.add(his);
				}rs.close();
			} catch ( SQLException se ) {
	            System.out.println("SQL showHistory Exception:" + se.getMessage() );
	         }
	         catch ( Exception e ) {
	             System.out.println("Exception:" + e.getMessage() );
	          }
		
		return listHistory;
	}
	
}
