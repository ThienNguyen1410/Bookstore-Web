package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import dao.CustomerDao;


@WebServlet(urlPatterns ="/Pass_change")
public class Forget_pass_Pass_change extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public Forget_pass_Pass_change() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String email_re = request.getParameter("enter_email_");
        String pass_re = request.getParameter("enter_new_pass");              
           if(pass_re.length() >= 8) {
              if(new CustomerDao().updatePass(email_re, pass_re)) {
            	  JOptionPane.showMessageDialog(null, "<html>"
						                         + " <body>"
						                         + "  <div>"
						                         + "   <p style=\"font-size:10px; font-family:serif;\">Success change</p>"
						                         + "  </div>"
						                         + " </body>"
						                         + "</html>");
		           response.sendRedirect("view/login_signin.jsp");
             }   
              else {
            	  JOptionPane.showMessageDialog(null, "<html>"
						                         + " <body>"
						                         + "  <div>"
						                         + "   <p style=\"font-size:10px; font-family:serif;\">Something is wrong!</p>"
						                         + "  </div>"
						                         + " </body>"
						                         + "</html>");
            	  response.sendRedirect(request.getHeader("referer"));
              }
           }
           
           else {
        	   JOptionPane.showMessageDialog(null,"Password must be at least 8 charaters.");
        	   response.sendRedirect(request.getHeader("referer")); 
           }
           
	}

}
