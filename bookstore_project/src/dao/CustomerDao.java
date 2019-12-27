package dao;

import java.sql.ResultSet;

import models.ConnectionSqlite;
import models.Customer;

public class CustomerDao implements ObjectDao{

	@Override
	public boolean SignUp(Object obj) {
        Customer cus = (Customer) obj;
        String query = "insert into User (Email, UserName, UPass) values ('"+ cus.getEmail() + "','" + cus.getUserName() + "','" + cus.getPass() + "')";
        try {
			new ConnectionSqlite().excuteSql(query);
            return true;	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Customer infoTake(String email, String password) {
		String query = "select * from User where Email ='"+ email +"' AND UPass = '"+ password +"'";
		try {
			ResultSet rs = new ConnectionSqlite().choseData(query);
			while(rs.next()){ 
				int UIDtake = rs.getInt(1);
				String fullNameTake = rs.getString(2);
				String addressTake = rs.getString(3);
				String emailTake = rs.getString(4);
				String userNameTake = rs.getString(5);				
				String passTake = rs.getString(6);
				return new Customer(UIDtake,fullNameTake,addressTake,userNameTake,emailTake,passTake);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	@Override
	public boolean SignIn(String email, String password) {
		String query = "select UID, Email, UPass from User where Email ='"+ email +"' AND UPass = '"+ password +"'";
		try {
			ResultSet rs = new ConnectionSqlite().choseData(query);
			while(rs.next()){
				if(rs.getString("Email").equals(email) && rs.getString("UPass").equals(password)) {
					return true;
				}
			}rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public boolean SignInGoogle(String email) {
		String query = "select Email from User where Email ='"+ email +"'";
		try {
			ResultSet rs = new ConnectionSqlite().choseData(query);
			while(rs.next()){
				if(rs.getString("Email").equals(email)) {
					return true;
				}
			}rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public boolean mailReceive(String email) {
		String sql= "select Email from User where Email = '" + email +"'";
		try {
			ResultSet rs = new ConnectionSqlite().choseData(sql);
			while(rs.next()){
				if(rs.getString("Email").equals(email)) {
					return true;
				}
			}rs.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return false;
	}

   public boolean updatePass(String mail, String pass) {
	   String sql = "UPDATE User set UPass ='"+pass+"'where Email ='"+mail+"'";
	   try {
			new ConnectionSqlite().update(sql);
           return true;	
		} catch (Exception e) {
			e.printStackTrace();
		}
	   return false;
   }

@Override
public boolean EditUser(Object obj, String username) {
	Customer cus = (Customer) obj;
    String query = "Update User set UserName ='"+cus.getUserName()+"', Email ='"+cus.getEmail()+"', UPass ='"+cus.getPass()+"' where UserName ='"+username+"'";
    try {
		new ConnectionSqlite().excuteSql(query);
        return true;	
	} catch (Exception e) {
		e.printStackTrace();
	}
	return false;
}

}
