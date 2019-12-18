package models;

import java.util.Date;
import java.text.SimpleDateFormat;

public class GetDate {

public void setToday() {
	String today;
	SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");
	Date date= new Date();
	today = formatter.format(date);
	System.out.println(today);
}

public static void main(String[] args) {
	GetDate gDate = new GetDate();
	gDate.setToday();
}
   
}
