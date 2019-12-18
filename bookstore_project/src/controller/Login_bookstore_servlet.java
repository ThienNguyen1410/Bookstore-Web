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

import dao.CustomerDao;
import models.Customer;

/**
 * Servlet implementation class Login_bookstore_servlet
 */
@WebServlet(urlPatterns ="/Login_bookstore_servlet")
public class Login_bookstore_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login_bookstore_servlet() {
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
	    response.setContentType("text/html;charset=UTF-8");
		String email = request.getParameter("log_form_user");
        String pass = request.getParameter("log_form_pass");
        Customer cus = new CustomerDao().infoTake(email, pass);
        if(new CustomerDao().SignIn(email, pass)) {
           HttpSession session = request.getSession();
           
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
		   JOptionPane.showMessageDialog(null,"Welcome back!!! ");
		   response.sendRedirect("view/bookstore_home_user.jsp");
        }
       else {
    	   JOptionPane.showMessageDialog(null,"You email or password is wrong!!");
		   response.sendRedirect("view/login_signin.jsp");
       }
	}

}
