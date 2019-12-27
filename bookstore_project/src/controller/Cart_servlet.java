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

import dao.CartDao;
import models.ConnectionSqlite;




@WebServlet(urlPatterns ="/Cart_servlet")
public class Cart_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Cart_servlet() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String BID = request.getParameter("BID");
		String UID = request.getParameter("UID");
		String UserName = request.getParameter("UserName");
		int UIDint = Integer.parseInt(UID);
		
		Connection c = null;
        Statement ps1 = null;
        Statement ps = null;
        ResultSet rs = null;
        ResultSet rs1 = null;
        try {
        	c = ConnectionSqlite.CreateMySqlConnection();
        	
        	
        	ps1 = c.createStatement();
        	String sql = "Select CID from Cart Where CID = '"+UserName+"';";
        	rs=ps1.executeQuery(sql);
        	if(rs.next()) {
				if(rs.getString("CID").equals(UserName)) {
					rs.close();
					ps1.close();
					ps = c.createStatement();
					String sqlString = "Select BID from UserCartBook where BID ='"+BID+"' AND CID ='"+UserName+"' AND UID ="+UIDint+""; 
					rs1 = ps.executeQuery(sqlString);
					if(rs1.next()) {
						rs1.close();
						ps.close();	
						JOptionPane.showMessageDialog(null, "<html>"
							                            + " <body>"
							                            + "  <div>"
							                            + "   <p style=\"font-size:15px; font-family:serif;\">Item's already added. You can change it quantity in your cart.</p>"
							                            + "  </div>"
							                            + " </body>"
							                            + "</html>");
						response.sendRedirect("view/cart_user.jsp");
					}
					else {
						rs1.close();
						ps.close();
						rs.close();
						ps1.close();
						new CartDao().insertCart(UIDint, UserName, BID);
						response.sendRedirect("view/cart_user.jsp");
					}
				}
			}
			else {
				rs.close();
				ps1.close();
				new CartDao().createCIDforDB(UserName);
				new CartDao().insertCart(UIDint, UserName, BID);
				response.sendRedirect("view/cart_user.jsp");
			}
 
            c.close();
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
