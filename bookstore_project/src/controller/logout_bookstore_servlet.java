package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

@WebServlet(urlPatterns ="/logout_bookstore_servlet")
public class logout_bookstore_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public logout_bookstore_servlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		 PrintWriter out = response.getWriter();
		 
		 try {
			 HttpSession session = request.getSession();
		    if (request.getParameter("logout") != null) {
		    	JOptionPane.showMessageDialog(null, "<html>"
						                       + " <body>"
						                       + "  <div>"
						                       + "   <p style=\"font-size:15px; font-family:serif;\">We'll miss you</p>"
						                       + "  </div>"
						                       + " </body>"
						                       + "</html>");
		    	 session.invalidate();
		         request.removeAttribute("email_log");
		         request.removeAttribute("pass_log");
		         response.sendRedirect("view/bookstore_home.jsp");
		         return;
		         
		     }
		 } finally {
		 out.close();
		 }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
