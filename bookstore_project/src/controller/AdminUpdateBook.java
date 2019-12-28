package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDao;
import models.GetDate;

@WebServlet(urlPatterns ="/AdminUpdateBook")
public class AdminUpdateBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdminUpdateBook() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String BID = request.getParameter("updateID");

		String Quantity = request.getParameter("updateQuantity");
		int QuanInt = Integer.parseInt(Quantity);
		
		String Adname = request.getParameter("Adname");
		String UPDATE_QUAN = request.getParameter("UPDATE_QUAN");
		
		GetDate Gdate = new GetDate();
        String date = Gdate.setToday();
        int Dateint = Integer.parseInt(date);
        
        LocalTime time = java.time.LocalTime.now();  
    	String timeNow = time.toString();
		
		PrintWriter out = response.getWriter();
              if(new AdminDao().selectIfExistForUpdate(BID)) {
				if(new AdminDao().UpdateExist(BID, QuanInt)) {
					if(new AdminDao().InsertadminBook(Adname, BID, UPDATE_QUAN, timeNow, Dateint)) {
						out.print("Success Update");
					}
				}
				else {
					out.print("Something wrong");
				}

              }
              else {
            	  out.print("Book not in DB");
              }
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
