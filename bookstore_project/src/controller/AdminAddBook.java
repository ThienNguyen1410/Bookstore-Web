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

@WebServlet(urlPatterns ="/AdminAddBook")
public class AdminAddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdminAddBook() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String BID = request.getParameter("addID");
		String Image = request.getParameter("addImage");
		String Btitle = request.getParameter("addName");
		String Bauthor = request.getParameter("addAuthor");
		String Quantity = request.getParameter("addQuantity");
		int QuanInt = Integer.parseInt(Quantity);
		String Bprice = request.getParameter("addPrice");
		int PriceInt = Integer.parseInt(Bprice);
		
		String Adname = request.getParameter("Adname");
		String ADD = request.getParameter("ADD");
		
		GetDate Gdate = new GetDate();
        String date = Gdate.setToday();
        int Dateint = Integer.parseInt(date);
        
        LocalTime time = java.time.LocalTime.now();  
    	String timeNow = time.toString();
		
		PrintWriter out = response.getWriter();

				if(new AdminDao().selectIfExist(BID, Btitle, Bauthor)) {
			    	 out.print("Book in DB");
			     }
			     else {
			    	 
			    	 if(new AdminDao().insertIfNotExist(BID, Btitle, Bauthor, PriceInt, Image, QuanInt)) {
			    		 if(new AdminDao().InsertadminBook(Adname, BID, ADD, timeNow, Dateint)) {
			    			 out.print("Item added");
			    		 }
			    		 else {
								out.print("Can not sign to Admin control table");
							}
			    	 }
			    	 else {
			    		 out.print("Something wrong");
			    	 }
			    	 
			     }
			}
		


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
