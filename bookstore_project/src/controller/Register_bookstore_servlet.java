package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import dao.CustomerDao;
import models.ConnectionSqlite;
import models.Customer;

import java.sql.*;

@WebServlet(urlPatterns ="/Register_bookstore_servlet")
public class Register_bookstore_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Register_bookstore_servlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String username = request.getParameter("reg_form_usern");
        String email = request.getParameter("reg_form_mail");
        String password = request.getParameter("reg_form_pass");
        
        Connection c = null;
        Statement ps1 = null;
        ResultSet rs = null;
        
        try{
        	HttpSession session = request.getSession();
        	session.removeAttribute("Uemail");
           c = ConnectionSqlite.CreateMySqlConnection();
           ps1 = c.createStatement();
           String query = "select UserName, Email from User where UserName = '" + username +"' OR Email = '"+ email +"'";
           rs = ps1.executeQuery(query); 
           if(rs.next()){
        	   rs.close();
        	  ps1.close();
        	  JOptionPane.showMessageDialog(null, "<html>"
						                      + " <body>"
						                      + "  <div>"
						                      + "   <p style=\"font-size:10px; font-family:serif;\">Sorry, Username or email existed.</p>"
						                      + "  </div>"
						                      + " </body>"
						                      + "</html>");
             response.sendRedirect("view/login_signin.jsp");
           }
           else{
        	  rs.close();
         	  ps1.close();
		        	 Customer cus = new Customer(username, email, password);
		        	 if(new CustomerDao().SignUp(cus)) {
		        		 JOptionPane.showMessageDialog(null, "<html>"
						                       + " <body>"
						                       + "  <div>"
						                       + "   <p style=\"font-size:15px; font-family:serif;\">Success!<br>Please, go to login.</p>"
						                       + "  </div>"
						                       + " </body>"
						                       + "</html>");
			             response.sendRedirect("view/login_signin.jsp");
		             }
		        	 else {
		        		 JOptionPane.showMessageDialog(null, "<html>"
						                       + " <body>"
						                       + "  <div>"
						                       + "   <p style=\"font-size:15px; font-family:serif;\">Something is wrong</p>"
						                       + "  </div>"
						                       + " </body>"
						                       + "</html>");
			             response.sendRedirect("view/login_signin.jsp");
		        	 }                  
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

}
