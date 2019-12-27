package models;
public class Book {
     private String BID;
     private String Btitle;
     private String Bauthor;
     private int Bprice;
     private String Image;
     private int Quantity;
     private int QuantityOrder;
     private int SaleOffPercent;
     private int SaleOffPrice;


	public Book(String bID, String btitle, String bauthor, int bprice, String image, int Quantity) {
		super();
		BID = bID;
		Btitle = btitle;
		Bauthor = bauthor;
		Bprice = bprice;
		Image = image;
		this.Quantity = Quantity;
	}

	public Book() {
		
	}

	public String getBID() {
		return BID;
	}

	public void setBID(String bID) {
		BID = bID;
	}

	public String getBtitle() {
		return Btitle;
	}

	public void setBtitle(String btitle) {
		Btitle = btitle;
	}

	public String getBauthor() {
		return Bauthor;
	}

	public void setBauthor(String bauthor) {
		Bauthor = bauthor;
	}

	public int getBprice() {
		return Bprice;
	}

	public void setBprice(int bprice) {
		Bprice = bprice;
	}

	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		Image = image;
	}

    
	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	
	

	public int getQuantityOrder() {
		return QuantityOrder;
	}

	public void setQuantityOrder(int quantityOrder) {
		QuantityOrder = quantityOrder;
	}

	
	
	
	public int getSaleOffPercent() {
		return SaleOffPercent;
	}

	public void setSaleOffPercent(int saleOffPercent) {
		SaleOffPercent = saleOffPercent;
	}

	public int getSaleOffPrice() {
		return SaleOffPrice;
	}

	public void setSaleOffPrice(int saleOffPrice) {
		SaleOffPrice = saleOffPrice;
	}

	@Override
	public String toString() {
		return "Book [BID=" + BID + ", Btitle=" + Btitle + ", Bauthor=" + Bauthor + ", Bprice=" + Bprice + ", Image=" + Image + ", Quanity=" + Quantity + "]";
	}

	
      
       
}
