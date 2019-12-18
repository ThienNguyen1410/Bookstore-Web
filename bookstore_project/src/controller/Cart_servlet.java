package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sqlite.connect.RandomString;

import dao.CartDao;
import models.Book;
import models.Cart;
import models.ConnectionSqlite;
import models.Customer;
import models.GetDate;
import models.Order;


@WebServlet(urlPatterns ="/Cart_servlet")
public class Cart_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public Cart_servlet() {
        super();

    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String BID = request.getParameter("BID");
		String UID = request.getParameter("UID");
		
		int UIDint = Integer.parseInt(UID);
		GetDate gDate = new GetDate();
		
		if(new CartDao().createCIDforDB()) {
			String sql = "Select CID from Cart";
			try {
				ResultSet rSet = new ConnectionSqlite().choseData(sql);
				if(rSet.next()) {
					String CID = rSet.getString("CID");
					String sql1 = "Insert into UserCartBook (UID, CID, BID) values ("+UIDint+",'"+CID+"','"+BID+"')";
					new ConnectionSqlite().excuteSql(sql1);
					response.sendRedirect("view/cart_user.jsp");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e.getMessage());
			}
			
		}
		
         
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
