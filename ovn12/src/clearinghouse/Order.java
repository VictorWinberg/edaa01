package clearinghouse;

public class Order {
	private double price;
	private Customer customer;
	
	/** Skapar en köp- eller s√§ljorder för en aktiepost med priset price och köpare/s√§ljare customer. */
	public Order(double price, Customer customer) {
		this.price = price;
		this.customer = customer;
	}
	
	/** Returnerar köp/s√§ljpris för aktieposten. */
	public double getPrice() {
		return price;
	}
	
	public String toString() {
		return String.valueOf(price);
	}
}
