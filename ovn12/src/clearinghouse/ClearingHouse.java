package clearinghouse;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.TreeMap;

public class ClearingHouse {
	private Map<String, OrderQueues> q;
		
	public ClearingHouse() {
		q = new TreeMap<String, OrderQueues>();
	}
	
	public boolean add(String shareId) {
		if (q.containsKey(shareId)) {
			return false;
		}
		q.put(shareId, new OrderQueues(shareId));
		return true;
	}
	
	/** 
	* L√•ter kunden customer l√§gga en köporder av aktieslaget shareId till 
	* budpriset price. Genomför köpet om matchande s√§ljorder finns, i annat 
	* fall lagras köpordern i motsvarande orderkö.
	* @param customer kunden
	* @param shareId aktieslag
	* @param price budpris
	* @throws NoSuchElementException om det inte finns n√•gon orderkö för 
	* aktieslaget shareId.
	*/
	public void buy(Customer customer, String shareId, double price) {
		// Fyll i egen kod
	}
	
	/** 
	* L√•ter kunden customer l√§gga en s√§ljorder av aktieslaget shareId till 
	* budpriset price. Genomför förs√§ljningen om matchande s√§ljorder finns, i annat 
	* fall lagras s√§ljordern i motsvarande orderkö.
	* @param customer kunden
	* @param shareId aktieslag
	* @param price budpris
	* @throws NoSuchElementException om det inte finns n√•gon orderkö för 
	* aktieslaget shareId.
	*/
	public void sell(Customer customer, String shareId, double price) {
		// Fyll i egen kod
	}

	/** Genomför aff√§ren med ordrarna buyOrder och sellOrder. */
	private void execute(Order buyOrder, Order sellOrder) {
		// Simulerar aktieaff√§r
		System.out.println("Köp: " + buyOrder.getPrice() + " " + " s√§lj: " + sellOrder.getPrice());	
	}
	
	public String toString() {
		return q.toString();
	}
	
}
