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

/**
 * Servlet implementation class logout_bookstore_servlet
 */
@WebServlet(urlPatterns ="/logout_bookstore_servlet")
public class logout_bookstore_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logout_bookstore_servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		 PrintWriter out = response.getWriter();
		 
		 try {
			 HttpSession session = request.getSession();
		    if (request.getParameter("logout") != null) {
		    	 JOptionPane.showMessageDialog(null,"You will now Log out from our website.");
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
