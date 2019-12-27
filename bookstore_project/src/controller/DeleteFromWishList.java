package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.ConnectionSqlite;

@WebServlet(urlPatterns ="/DeleteFromWishList")
public class DeleteFromWishList extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteFromWishList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String UserN = request.getParameter("UserName");
		String BookId = request.getParameter("itemID");
		
		try {
			String sql = "Delete From WishList where UserName='"+UserN+"' AND BID='"+BookId+"'";
			new ConnectionSqlite().excuteSql(sql);
          	    response.sendRedirect(request.getHeader("referer"));
		}
		catch ( SQLException se ) {
            System.out.println("SQL Exception:" + se.getMessage() );
         }
		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
}
