package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import dao.AdminDao;
import dao.CustomerDao;
import models.Customer;

@WebServlet(urlPatterns ="/Login_bookstore_servlet")
public class Login_bookstore_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Login_bookstore_servlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html;charset=UTF-8");
		String email = request.getParameter("log_form_user");
        String pass = request.getParameter("log_form_pass");
        HttpSession session = request.getSession();
        
        if(new AdminDao().adminLogin(email, pass)){
        	session.setAttribute("Aname", email);
        	 response.sendRedirect("view/bookstore_home_admin.jsp");
        }
        else { 
	        Customer cus = new CustomerDao().infoTake(email, pass);
	        if(new CustomerDao().SignIn(email, pass)) {
	           
	           
	           session.setAttribute("user", cus);
	           
	           Cookie email_log = new Cookie("email_log", email);
			   Cookie pass_log = new Cookie("pass_log", pass);
			   if(request.getParameter("remem_pass") != null) {
				    email_log.setMaxAge(60 * 60 * 24);
			        pass_log.setMaxAge(60 * 60 * 24);
			        response.addCookie(email_log);
	    		    response.addCookie(pass_log);
			   }
			   else {
				    email_log.setMaxAge(0);
			        pass_log.setMaxAge(0); 
			   }
			   JOptionPane.showMessageDialog(null, "<html>"
						                       + " <body>"
						                       + "  <div>"
						                       + "   <p style=\"font-size:15px; font-family:serif;\">Welcome back, friend.</p>"
						                       + "  </div>"
						                       + " </body>"
						                       + "</html>");
			   response.sendRedirect("view/bookstore_home_user.jsp");
	        }
	       else {
	    	   JOptionPane.showMessageDialog(null, "<html>"
						                       + " <body>"
						                       + "  <div>"
						                       + "   <p style=\"font-size:15px; font-family:serif;\">Wrong information.</p>"
						                       + "  </div>"
						                       + " </body>"
						                       + "</html>");
			   response.sendRedirect("view/login_signin.jsp");
	       }
	  }  
	}

}
