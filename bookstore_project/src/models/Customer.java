package models;

public class Customer {
	int UID;
    String userName;
    String email;
    String password;
    String fullName;
    String address;
    
	public Customer(String userName, String email, String password) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
	}
	
	public Customer(int UID,String fullName, String address, String userName, String email, String password) {
		super();
		this.UID=UID;
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.fullName =fullName;
		this.address=address;
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
    
	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [userName=" + userName + ", email=" + email + ", pass=" + password + "]";
	}
    
}
