package models;

public class Cart {
    private String CID;
    private int totalBill;
    
	public String getCID() {
		return CID;
	}
	public void setCID(String cID) {
		CID = cID;
	}
	public int getTotalBill() {
		return totalBill;
	}
	public void setTotalBill(int totalBill) {
		this.totalBill = totalBill;
	}
    
    
}
