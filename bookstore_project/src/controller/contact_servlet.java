package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

@WebServlet(urlPatterns = "/contact_servlet")
public class contact_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public contact_servlet() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             String fullname= request.getParameter("fullname");
             String email= request.getParameter("email");
             String postcode= request.getParameter("postcode");
             String option= request.getParameter("contact_form");
             String moreInfo= request.getParameter("contactMessage");
             
             String from= "custservice643@gmail.com";
             String pass ="giangnhat";
             
             String to= "bookstoreforyou.project@gmail.com";
             
             
             Properties properties = System.getProperties();
             properties.put("mail.smtp.host", "smtp.gmail.com");
             properties.put("mail.smtp.port", "587");
             properties.put("mail.smtp.starttls.enable", "true");
             properties.put("mail.smtp.auth", "true");
             
             Authenticator pa = new Authenticator() {

                 public PasswordAuthentication getPasswordAuthentication() {
                     return new PasswordAuthentication(from, pass);
                 }
             };
             
             Session session = Session.getInstance(properties,pa);
             response.setContentType("text/html");
             
             try {
            	 MimeMessage message = new MimeMessage(session);
            	 message.setFrom(new InternetAddress(from));
            	 message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
            	 message.setSubject("Customer opinion");
            	 message.setContent("<h1>Customer opinion</h1><br>"
            	 		+ "<span style=\"font-size:15px;\"><b>Name</b></span>: <span>"+fullname+"</span><br><br>"
            	 		+ "<span style=\"font-size:15px;\"><b>Email</b></span>: <span>"+email+"</span><br><br>"
            	 		+ "<span style=\"font-size:15px;\"><b>Postcode/zip</b></span>: <span>"+postcode+"</span><br><br>"
            	 		+ "<span style=\"font-size:15px;\"><b>Option</b></span>: <span>"+option+"</span><br><br>"
            	 		+ "<span style=\"font-size:15px;\"><b>More information</b></span>: <span>"+moreInfo+"</span><br>", "text/html" );
            	 Transport.send(message);
            	 
                 JOptionPane.showMessageDialog(null, "<html>"
                 		                            + " <body>"
                 		                            + "  <div>"
                 		                            + "   <p style=\"font-size:15px; font-family:Arial;\">Send success</p>"
                 		                            + "  </div>"
                 		                            + " </body>"
                 		                            + "</html>");
                 response.sendRedirect(request.getHeader("referer"));
             }
             catch (MessagingException mex) {
                 mex.printStackTrace();
              }
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
