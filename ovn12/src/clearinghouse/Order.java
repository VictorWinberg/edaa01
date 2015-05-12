package clearinghouse;

public class Order {
	private double price;
	private Customer customer;
	
	/** Skapar en k�p- eller säljorder f�r en aktiepost med priset price och k�pare/säljare customer. */
	public Order(double price, Customer customer) {
		this.price = price;
		this.customer = customer;
	}
	
	/** Returnerar k�p/säljpris f�r aktieposten. */
	public double getPrice() {
		return price;
	}
	
	public String toString() {
		return String.valueOf(price);
	}
}
