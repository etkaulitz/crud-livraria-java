package Livraria;

public class Order {
	Book book;
	ShippingInfo shippingInfo;
	BillingInfo billingInfo;
	User user;
	int id;
	
	public int getId() {
		return id;
	}
	
	public void setid(int id) {
		this.id = id;
	}
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	
	public ShippingInfo getShippingInfo() {
		return shippingInfo;
	}
	public void setShippingInfo(ShippingInfo shippingInfo) {
		this.shippingInfo = shippingInfo;
	}
	
	public BillingInfo getBillingInfo() {
		return billingInfo;
	}
	public void setBillingInfo(BillingInfo billingInfo) {
		this.billingInfo = billingInfo;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	boolean isFullFilled() {
		if(book != null && shippingInfo != null && user != null) {
			return true;
		}
		return false;
	}
	
}
