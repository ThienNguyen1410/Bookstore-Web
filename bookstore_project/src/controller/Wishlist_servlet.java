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
import javax.swing.JOptionPane;
import models.ConnectionSqlite;


@WebServlet(urlPatterns ="/Wishlist_servlet")
public class Wishlist_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Wishlist_servlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  String UserN= request.getParameter("UserN");
          String BID = request.getParameter("BID");
          
          Connection c = null;
          Statement ps1 = null;
          Statement ps = null;
          ResultSet rs = null;
          try {
        	  c = ConnectionSqlite.CreateMySqlConnection();
        	  ps = c.createStatement();
        	  String sql = "select BID from WishList where UserName ='"+UserN+"' AND BID ='"+BID+"'";
        	  rs = ps.executeQuery(sql);
        	  if(rs.next()) {
        		  rs.close();
        		  ps.close();
        		  JOptionPane.showMessageDialog(null, "<html>"
						                       + " <body>"
						                       + "  <div>"
						                       + "   <p style=\"font-size:10px; font-family:serif;\">Item existed in wishlist.</p>"
						                       + "  </div>"
						                       + " </body>"
						                       + "</html>");
            	  response.sendRedirect(request.getHeader("referer"));
        	  }
        	  
        	  else {
        		  rs.close();
        		  ps.close();
	        	  ps1 = c.createStatement();
	        	  String sql1 = "insert into WishList (UserName, BID) values ('"+UserN+"','"+BID+"')";
	        	  ps1.executeUpdate(sql1);
	        	  JOptionPane.showMessageDialog(null, "<html>"
	                       + " <body>"
	                       + "  <div>"
	                       + "   <p style=\"font-size:15px; font-family:serif;\">Add to wishlist success</p>"
	                       + "  </div>"
	                       + " </body>"
	                       + "</html>");
	            	  response.sendRedirect(request.getHeader("referer")); 
	              ps1.close();
        	  }  
              c.close();
          }
          
          catch ( SQLException se ) {
              System.out.println("SQL wishlist Exception:" + se.getMessage() );
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
