package controller;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
		String from= "bookstoreforyou.project@gmail.com";
        String pass ="giangnhat";
             
            if (new CustomerDao().mailReceive(mail_receive)) {
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
                Session sess = Session.getInstance(properties,pa);
            	try {
            		 MimeMessage message = new MimeMessage(sess);
	               	 message.setFrom(new InternetAddress(from));
	               	 message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail_receive, false));
	               	 message.setSubject("This email is from BookForYou support");
	               	 message.setContent("<div style=\"height:50px; background-color:lightcoral; padding-left:50%;\"><h1 style=\"color:white;\">BookForYou</h1></div><br>"
               	 		+ "<span style=\"font-size:12px;\">We have received a reset password request from you. Please click the link below to reset passwork</span><br>"
               	 		+ "<a style=\"font-size:12px; color: red;\" href=\"http://localhost:8081/bookstore_project/view/Pass%20change.jsp?mail_re="+mail_receive+"\">Chang password.</a><br>", "text/html" );
               	 Transport.send(message);
            	 JOptionPane.showMessageDialog(null, "<html>"
							                         + " <body>"
							                         + "  <div>"
							                         + "   <p style=\"font-size:15px; font-family:serif;\">Please check your email.</p>"
							                         + "  </div>"
							                         + " </body>"
							                         + "</html>");      
            	 response.sendRedirect(request.getHeader("referer"));
			   }
            	catch (MessagingException mex) {
                    mex.printStackTrace();
                 }
            }
            
            else {
            	JOptionPane.showMessageDialog(null, "<html>"
							                         + " <body>"
							                         + "  <div>"
							                         + "   <p style=\"font-size:15px; font-family:serif;\">Unknow email.</p>"
							                         + "  </div>"
							                         + " </body>"
							                         + "</html>");
     		   response.sendRedirect("view/forget_pass.jsp");
            }
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
