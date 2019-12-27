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
import models.Customer;;

@WebServlet(urlPatterns ="/profile_user_edit")
public class profile_user_edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public profile_user_edit() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userProfile = request.getParameter("profile_user_name");
        String userProfileEdit = request.getParameter("profile_user_name_edit");
        String emailProfileEdit = request.getParameter("profile_email_edit");
        String passProfileEdit = request.getParameter("profile_pass_edit");
        
            
            if(passProfileEdit.length()>=8) {
            	Customer cus = new Customer(userProfileEdit, emailProfileEdit, passProfileEdit);
            	if(new CustomerDao().EditUser(cus, userProfile)){
            		HttpSession session = request.getSession();
            		session.setAttribute("user", cus);
            		JOptionPane.showMessageDialog(null, "<html>"
								                       + " <body>"
								                       + "  <div>"
								                       + "   <p style=\"font-size:15px; font-family:serif;\">Success change.</p>"
								                       + "  </div>"
								                       + " </body>"
								                       + "</html>");
		            response.sendRedirect("view/profile_user.jsp");
	            }
	          }
            else {
            	JOptionPane.showMessageDialog(null,"Password must be at least 8 charaters.");
	            response.sendRedirect("view/profile_user_edit.jsp");
            }   
	}

}
