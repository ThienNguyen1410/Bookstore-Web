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

@WebServlet(urlPatterns = "/GoogleAccCheck")
public class GoogleAccCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GoogleAccCheck() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html;charset=UTF-8");
         String Uemail =(String) request.getAttribute("email");
         HttpSession session = request.getSession();

	        if(new CustomerDao().SignInGoogle(Uemail)) {
	        	JOptionPane.showMessageDialog(null, "<html>"
						                        + " <body>"
						                        + "  <div>"
						                        + "   <p style=\"font-size:15px; font-family:serif;\">Account existed! <br>Please, go to login.</p>"
						                        + "  </div>"
						                        + " </body>"
						                        + "</html>");
			   response.sendRedirect("view/login_signin.jsp");
	        }
	       else {
               session.setAttribute("Uemail", Uemail);
			   response.sendRedirect("view/newGoogleUser.jsp");
	       }
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
