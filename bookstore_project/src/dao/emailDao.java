package dao;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class emailDao {
     public void sendEmailOrder(String from, String to, String pass,String uName,String pID, String date, String time, String address, String price, String cType, String cName, String cMM, String cYY, String cNum) {
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
           	 message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
           	 message.setSubject("Email from BookForYou");
           	 message.setContent("<div style=\"height:50px; background-color:lightcoral; padding-left:45%;\"><h1 style=\"color:white;\">BookForYou</h1></div><br>"
       	 		+ "<span style=\"font-size:20px;\">We have received your Payment ID("+pID+"), more information below:</span><br>"
       	 		+ "<span style=\"font-size:15px;\">-Customer name: "+uName+"</span><br>"
       	 		+ "<span style=\"font-size:15px;\">-Order date: "+date+"</span><br>"
       	 		+ "<span style=\"font-size:15px;\">-Order time: "+time+"</span><br>"
       	 		+ "<span style=\"font-size:15px;\">-Address: "+address+"</span><br>"
       	 		+ "<span style=\"font-size:15px;\">-Total price: "+price+" VND</span><br>"
       	 		+ "<span style=\"font-size:15px;\">-Card inrofmation:</span><br>"
       	 		+ "<span style=\"font-size:15px;\">   +Card type: "+cType+"</span><br>"
       	 		+ "<span style=\"font-size:15px;\">   +Name on card: "+cName+"</span><br>"
       	 		+ "<span style=\"font-size:15px;\">   +Creation/Expried date: "+cMM+"/"+cYY+"</span><br>"
       	 		+ "<span style=\"font-size:15px;\">   +Card number: "+cNum+"</span><br>", "text/html" );
       	     Transport.send(message);
         }
         catch (MessagingException mex) {
             mex.printStackTrace();
          }
     }
}
