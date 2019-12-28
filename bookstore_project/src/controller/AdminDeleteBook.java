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

@WebServlet(urlPatterns ="/AdminDeleteBook")
public class AdminDeleteBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdminDeleteBook() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Btitle = request.getParameter("deleteName");
		String Bauthor = request.getParameter("deleteAuthor");
		String BID = request.getParameter("deleteID");
		
		String Adname = request.getParameter("Adname");
		String DELETE = request.getParameter("DELETE");
		
		GetDate Gdate = new GetDate();
        String date = Gdate.setToday();
        int Dateint = Integer.parseInt(date);
        
        LocalTime time = java.time.LocalTime.now();  
    	String timeNow = time.toString();
        
		PrintWriter out = response.getWriter();
		
		if(new AdminDao().selectIfExist(BID, Btitle, Bauthor)) {
			if(new AdminDao().DeleteExist(BID, Btitle, Bauthor)) {
				if(new AdminDao().InsertadminBook(Adname, BID, DELETE, timeNow, Dateint)) {
					out.print("Success Delete");
				}
				else {
					out.print("Can not sign to Admin control table");
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
