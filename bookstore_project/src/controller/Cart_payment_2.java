package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns ="/Cart_payment_2")
public class Cart_payment_2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Cart_payment_2() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String addr = request.getParameter("form_addresss");
		String uName = request.getParameter("form_fullname");
		HttpSession session = request.getSession();
        session.setAttribute("addr", addr);
        session.setAttribute("usName", uName);
        response.sendRedirect("view/Cart_bill_user_payment.jsp");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
