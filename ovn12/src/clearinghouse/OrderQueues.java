package clearinghouse;

import java.util.PriorityQueue;

public class OrderQueues {
	private String shareId;
	private PriorityQueue<Order> buyOrders;		// sorterad efter avtagande pris
	private PriorityQueue<Order> sellOrders;	// sorterad efter v√§xande pris

	/** 
	 * Skapar ett objekt som hanterar en kö för köpordrar och en kö för s√§ljordrar 
	 * för aktien med id shareId. 
	 * @param shareId 
	 */
	public OrderQueues(String shareId) {
		// Fyll i egen kod
	}
	
	/**
	 * L√§gger till en köporder ifall matchande s√§ljorder inte finns. 
	 * Om matchande s√§ljorder finns tas s√§ljordern bort och returneras.
	 * @param buyOrder köporder
	 * @return matchande s√§ljorder om sådan finns, i annat fall null
	 */
	public Order addBuyOrder(Order buyOrder) {
		// Fyll i egen kod
		return null;
	}
	
	/**
	 * L√§gger till en s√§ljorder ifall matchande köporder inte finns. 
	 * Om matchande köporder finns tas köpordern bort och returneras.
	 * @param buyOrder s√§ljorder
	 * @return matchande köporder om sådan finns, i annat fall null
	 */
	public Order addSellOrder(Order sellOrder) {
		// Fyll i egen kod
		return null;
	}
	
	
	public String toString() {
		return "Köporder: " + buyOrders + " s√§ljorder: " +sellOrders;
	}

}
