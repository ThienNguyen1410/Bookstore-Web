package models;

public class Customer {
	int UID;
    String userName;
    String email;
    String password;
	public Customer(String userName, String email, String password) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
	}
	
	public Customer(int UID,String userName, String email, String password) {
		super();
		this.UID=UID;
		this.userName = userName;
		this.email = email;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPass() {
		return password;
	}
	public void setPass(String pass) {
		this.password = pass;
	}
	
	
	public int getUID() {
		return UID;
	}

	public void setUID(int uID) {
		UID = uID;
	}

	@Override
	public String toString() {
		return "Customer [userName=" + userName + ", email=" + email + ", pass=" + password + "]";
	}
    
}
