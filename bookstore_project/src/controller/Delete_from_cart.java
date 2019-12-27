package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartDao;

@WebServlet(urlPatterns ="/Delete_from_cart")
public class Delete_from_cart extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Delete_from_cart() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       String itemID = request.getParameter("itemID");
	       String cId = request.getParameter("Cid");
	       
	    	   new CartDao().quantityZero(itemID, cId);
	    	   response.sendRedirect(request.getHeader("referer"));
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
