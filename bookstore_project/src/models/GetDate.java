package models;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalTime;

public class GetDate {

public String setToday() {
	String today;
	SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");
	Date date= new Date();
	today = formatter.format(date);
	return today;
}

public static void main(String[] args) {
	GetDate gDate = new GetDate();
	String date = gDate.setToday();
	System.out.println(date);
	LocalTime time = java.time.LocalTime.now();  
	String timeNow = time.toString();
	System.out.println(timeNow);
}
   
}
