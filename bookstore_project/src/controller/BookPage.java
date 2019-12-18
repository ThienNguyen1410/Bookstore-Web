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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String BID = request.getParameter("itemID");	
		Connection c = null;
        Statement ps1 = null;
        ResultSet rs = null;
        
        try {
        	c = ConnectionSqlite.CreateMySqlConnection();
        	ps1 = c.createStatement();
        	String sql = "select BID, Btitle, Bauthor, Bprice, Image from Book where BID ='"+ BID +"'";
        	rs = ps1.executeQuery(sql);
        	
        	if(rs.next()) {
        		String BIDt = rs.getString("BID");
        		String Btitlet = rs.getString("Btitle");
        		String Bauthort = rs.getString("Bauthor");
        		String Bpricet = rs.getString("Bprice");
        		String Imaget = rs.getString("Image");
        		HttpSession session = request.getSession();
        		session.setAttribute("BIDt", BIDt);
        		session.setAttribute("Btitlet", Btitlet);
        		session.setAttribute("Bauthort", Bauthort);
        		session.setAttribute("Bpricet", Bpricet);
        		session.setAttribute("Imaget", Imaget);
        		
                response.sendRedirect("view/bookPage.jsp");
             }
        	ps1.close();
        	rs.close();
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
