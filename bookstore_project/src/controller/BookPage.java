package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.ConnectionSqlite;

@WebServlet(urlPatterns ="/BookPage")
public class BookPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BookPage() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String BID = request.getParameter("itemID");	
		Connection c = null;
        Statement ps1 = null;
        ResultSet rs = null;
        
        try {
        	c = ConnectionSqlite.CreateMySqlConnection();
        	ps1 = c.createStatement();
        	String sql = "select Book.BID, Btitle, Bauthor, Bprice, Image, Quantity, CategoryBook.CTID, Sale from Book, CategoryBook where Book.BID ='"+ BID +"' AND Book.BID=CategoryBook.BID";
        	rs = ps1.executeQuery(sql);
        	
        	if(rs.next()) {
        		String BIDt = rs.getString(1);
        		String Btitlet = rs.getString(2);
        		String Bauthort = rs.getString(3);
        		String Bpricet = rs.getString(4);
        		int price = Integer.parseInt(Bpricet);
        		String Imaget = rs.getString(5);
        		int QuanStore = rs.getInt(6);
        		String Cate = rs.getString(7);
        		int sale = rs.getInt(8);
        		int salePrice = price - ((price * sale)/100);
            	ps1.close();
            	rs.close();
        		HttpSession session = request.getSession();
        		session.setAttribute("BIDt", BIDt);
        		session.setAttribute("Btitlet", Btitlet);
        		session.setAttribute("Bauthort", Bauthort);
        		session.setAttribute("Bpricet", Bpricet);
        		session.setAttribute("Imaget", Imaget);
        		session.setAttribute("QuanStore", QuanStore);
        		session.setAttribute("Cate", Cate);
        		session.setAttribute("sale", sale);
        		session.setAttribute("salePrice", salePrice);
        		
                response.sendRedirect("view/bookPage.jsp");
             }

        }
        
        catch ( SQLException se ) {
            System.out.println("SQL Exception:" + se.getMessage() );
         }
         catch ( Exception e ) {
             System.out.println("Exception:" + e.getMessage() );
          }
         finally {
  			try {
  				if (c!=null) {
  					c.close();
  				}
  			} catch (SQLException se) {
  				System.out.println("Exception in closing connection "+ se.getMessage() );
  			}
  		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
