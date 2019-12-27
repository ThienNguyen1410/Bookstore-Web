package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.sqlite.connect.RandomString;

import dao.BookDao;
import dao.CartDao;
import dao.emailDao;
import models.Book;
import models.ConnectionSqlite;
import models.GetDate;
import models.Order;

@WebServlet(urlPatterns ="/Cart_payment")
public class Cart_payment extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Cart_payment() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String CID = request.getParameter("Cid");
        String address = request.getParameter("form_address");
        String method = request.getParameter("method");
        String uName = request.getParameter("uName");
        
        String UID = request.getParameter("Uid");
        int UIDint = Integer.parseInt(UID);
        
        String Bill = request.getParameter("totalPrice");
        int Billint = Integer.parseInt(Bill);
        
        GetDate Gdate = new GetDate();
        String date = Gdate.setToday();
        int Dateint = Integer.parseInt(date);
        
        LocalTime time = java.time.LocalTime.now();  
    	String timeNow = time.toString();
        
        RandomString ran = new RandomString();
        String PID = ran.randomAlphaNumeric(4);
        
        String cartName = request.getParameter("nameCard");
		String cartMM = request.getParameter("monthCard");
		String cartYY = request.getParameter("yearCard");
		String cartNumber = request.getParameter("numberCard");
		
		String mail_receive = request.getParameter("enter_email") ;
		String from= "bookstoreforyou.project@gmail.com";
        String pass ="giangnhat";
		
        Connection c = null;
        Statement st = null;
        ResultSet rs = null;
        
		try {
			String sql = "Select OID From 'Order' Where OID ='"+CID+"'";
			c = ConnectionSqlite.CreateMySqlConnection();
			st = c.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()) {
				rs.close();
				st.close();
					
					if(new CartDao().insertPayment(PID, method, Billint, cartName, cartMM+"/"+cartYY, cartNumber, CID)) {
                        if(new CartDao().insertPaymentOrder(PID,CID)) {
                        	CartDao cart = new CartDao();
            				for(Order order : cart.selectFromUserCart(UIDint,CID)) {
            					new CartDao().insertUserOrder(order.getUID(), order.getOID(), order.getBID(), order.getQuantity(), timeNow, Dateint, address);
            				}
            				BookDao bd = new BookDao();
        					for(Book book : bd.selectBookAfterPay()) {
            					new BookDao().updateQuanAfterPay(book.getQuantity()-book.getQuantityOrder(), book.getBID());;
            				}
            				if(new CartDao().deleteCartAfterPayment(CID, UIDint)) {
            					new emailDao().sendEmailOrder(from, mail_receive, pass, uName, PID, date, timeNow, address, Bill, method, cartName, cartMM, cartYY, cartNumber);
            					JOptionPane.showMessageDialog(null, "<html>"
							     		                            + " <body>"
							     		                            + "  <div>"
							     		                            + "   <p style=\"font-size:10px; font-family:serif;\">Thank for support us</p>"
							     		                            + "  </div>"
							     		                            + " </body>"
							     		                            + "</html>");
            					response.sendRedirect("view/bookstore_home_user.jsp");
            				}
						}
					}
			}
			else {
				rs.close();
				st.close();
				if(new CartDao().insertOrder(CID)) {
						if(new CartDao().insertPayment(PID, method, Billint, cartName, cartMM+"/"+cartYY, cartNumber, CID)) {
	                        if(new CartDao().insertPaymentOrder(PID,CID)) {
	                        	CartDao cart = new CartDao();
	            				for(Order order : cart.selectFromUserCart(UIDint, CID)) {
	            					new CartDao().insertUserOrder(order.getUID(), order.getOID(), order.getBID(), order.getQuantity(), timeNow, Dateint, address);
	            				}
	            				
	            				BookDao bd = new BookDao();
            					for(Book book : bd.selectBookAfterPay()) {
                					new BookDao().updateQuanAfterPay(book.getQuantity()-book.getQuantityOrder(), book.getBID());;
                				}
            					
	            				if(new CartDao().deleteCartAfterPayment(CID, UIDint)) {
	            					new emailDao().sendEmailOrder(from, mail_receive, pass, uName, PID, date, timeNow, address, Bill, method, cartName, cartMM, cartYY, cartNumber);
	            					JOptionPane.showMessageDialog(null, "<html>"
								     		                            + " <body>"
								     		                            + "  <div>"
								     		                            + "   <p style=\"font-size:10px; font-family:serif;\">Thank for support us</p>"
								     		                            + "  </div>"
								     		                            + " </body>"
								     		                            + "</html>");
	            					response.sendRedirect("view/bookstore_home_user.jsp");
	            				}
							}
					}

				}
			}
		} catch ( SQLException se ) {
            System.out.println("SQL Exception:" + se.getMessage() );
         }
         catch ( Exception e ) {
             System.out.println("Exception:" + e.getMessage() );
          }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
