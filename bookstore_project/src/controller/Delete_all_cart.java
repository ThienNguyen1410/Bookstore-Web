package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartDao;


@WebServlet(urlPatterns ="/Delete_all_cart")
public class Delete_all_cart extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Delete_all_cart() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String CID = request.getParameter("Cid");
      new CartDao().deleteAllCart(CID);
      response.sendRedirect(request.getHeader("referer")); 
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
