package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import dao.CustomerDao;

@WebServlet(urlPatterns ="/Mail_receive")
public class Forget_pass_Mail_receive extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Forget_pass_Mail_receive() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		String mail_receive = request.getParameter("enter_email") ;
        PrintWriter out = response.getWriter();
            if (new CustomerDao().mailReceive(mail_receive)) {
            	JOptionPane.showMessageDialog(null,"Please check your email.");
            	out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Email receive</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Email form Bookforyou.com </h1>");
                out.println("<form action =\"view/Pass change.jsp\">");
                out.println("To <input type=\"text\" name=\"mail_re\" style=\"border: white; background: white; width:800px; \" value=\""+mail_receive+"\" readonly>");
                out.println("<p>In order to change password. Please, click <input type=\"submit\" style =\"border: white; background: white; cursor: pointer; color: red;\"  value=\"'Change password'\">  </p>");
                out.println("</form>");
                out.println("</body>");
                out.println("</html>");       
			}
            
            else {
               JOptionPane.showMessageDialog(null,"Wrong email.");
     		   response.sendRedirect("view/forget_pass.jsp");
            }
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
