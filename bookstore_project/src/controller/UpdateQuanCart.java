package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import dao.CartDao;

@WebServlet(urlPatterns ="/UpdateQuanCart")
public class UpdateQuanCart extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdateQuanCart() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String changeQuan = request.getParameter("Quan");
       int Quan = Integer.parseInt(changeQuan);
       String itemID = request.getParameter("itemID");
       String cId = request.getParameter("Cid");
       
       if(Quan == 0) {
    	   new CartDao().quantityZero(itemID, cId);
    	   response.sendRedirect(request.getHeader("referer"));
       }
       
       else {
	       if(new CartDao().updateQuan(Quan, itemID, cId)) {
	    	   response.sendRedirect(request.getHeader("referer"));
	       }
	       else {
	    	   JOptionPane.showMessageDialog(null, "<html>"
                       + " <body>"
                       + "  <div>"
                       + "   <p style=\"font-size:15px; font-family:serif;\">Something is wrong</p>"
                       + "  </div>"
                       + " </body>"
                       + "</html>");
	     	  response.sendRedirect(request.getHeader("referer"));
	       }
       
       } 
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
