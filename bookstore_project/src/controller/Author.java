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

@WebServlet(urlPatterns ="/Author")
public class Author extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Author() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Bauthor = request.getParameter("Bauthor");	
		Connection c = null;
        Statement ps1 = null;
        ResultSet rs = null;
        
        try {
        	c = ConnectionSqlite.CreateMySqlConnection();
        	ps1 = c.createStatement();
        	String sql = "select  Bauthor from Book where Bauthor ='"+ Bauthor +"'";
        	rs = ps1.executeQuery(sql);
        	
        	if(rs.next()) {
        		
        		String Bauthort = rs.getString("Bauthor");
        		
        		HttpSession session = request.getSession();
        		
        		session.setAttribute("Bauthort", Bauthort);
        		
                response.sendRedirect("view/author.jsp");
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


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
