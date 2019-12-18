package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import dao.CustomerDao;
import models.ConnectionSqlite;
import models.Customer;

import java.sql.*;
/**
 * Servlet implementation class Register_bookstore_servlet
 */
@WebServlet(urlPatterns ="/Register_bookstore_servlet")
public class Register_bookstore_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register_bookstore_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String username = request.getParameter("reg_form_usern");
        String email = request.getParameter("reg_form_mail");
        String password = request.getParameter("reg_form_pass");
        String pass_confirm = request.getParameter("reg_form_ret_pass");
        
        Connection c = null;
        Statement ps1 = null;
        ResultSet rs = null;
        
        try{
           c = ConnectionSqlite.CreateMySqlConnection();
           ps1 = c.createStatement();
           String query = "select UserName, Email from User where UserName = '" + username +"' OR Email = '"+ email +"'";
           rs = ps1.executeQuery(query); 
           if(rs.next()){
             JOptionPane.showMessageDialog(null,"Sorry, User Name or Email has already been taken");
             response.sendRedirect("view/login_signin.jsp");
           }
           else{
        	 if(password.length() >= 8) {
	        	 if(password.equals(pass_confirm)) {
		        	 Customer cus = new Customer(username, email, password);
		        	 if(new CustomerDao().SignUp(cus)) {
			             JOptionPane.showMessageDialog(null,"Success! Please, login again.");
			             response.sendRedirect("view/login_signin.jsp");
		             }
		        	 else {
		        		 JOptionPane.showMessageDialog(null,"Something gone wrong.");
			             response.sendRedirect("view/login_signin.jsp");
		        	 }
             }
	        	 else {
	        		 Cookie user_reg = new Cookie("user_reg", username);
		      		 Cookie email_reg = new Cookie("email_reg", email);
		      		 user_reg.setMaxAge(2);
		      		 email_reg.setMaxAge(2);
		      		 response.addCookie(user_reg);
		      		 response.addCookie(email_reg);
	        		 JOptionPane.showMessageDialog(null,"Sorry! password do not match");
	                 response.sendRedirect("view/login_signin.jsp");
	        	 }
             
        	 }
        	 else {
        		 Cookie user_reg = new Cookie("user_reg", username);
	      		 Cookie email_reg = new Cookie("email_reg", email);
	      		 user_reg.setMaxAge(1);
	      		 email_reg.setMaxAge(1);
	      		 response.addCookie(user_reg);
	      		 response.addCookie(email_reg);
        		 JOptionPane.showMessageDialog(null,"Pass word must be at least 8 characters.");
                 response.sendRedirect("view/login_signin.jsp");
        	 }
            }
           rs.close();
           ps1.close();
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
