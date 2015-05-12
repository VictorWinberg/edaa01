package clearinghouse;

import java.util.PriorityQueue;

public class OrderQueues {
	private String shareId;
	private PriorityQueue<Order> buyOrders;		// sorterad efter avtagande pris
	private PriorityQueue<Order> sellOrders;	// sorterad efter växande pris

	/** 
	 * Skapar ett objekt som hanterar en k� f�r k�pordrar och en k� f�r säljordrar 
	 * f�r aktien med id shareId. 
	 * @param shareId 
	 */
	public OrderQueues(String shareId) {
		// Fyll i egen kod
	}
	
	/**
	 * Lägger till en k�porder ifall matchande säljorder inte finns. 
	 * Om matchande säljorder finns tas säljordern bort och returneras.
	 * @param buyOrder k�porder
	 * @return matchande säljorder om s�dan finns, i annat fall null
	 */
	public Order addBuyOrder(Order buyOrder) {
		// Fyll i egen kod
		return null;
	}
	
	/**
	 * Lägger till en säljorder ifall matchande k�porder inte finns. 
	 * Om matchande k�porder finns tas k�pordern bort och returneras.
	 * @param buyOrder säljorder
	 * @return matchande k�porder om s�dan finns, i annat fall null
	 */
	public Order addSellOrder(Order sellOrder) {
		// Fyll i egen kod
		return null;
	}
	
	
	public String toString() {
		return "K�porder: " + buyOrders + " säljorder: " +sellOrders;
	}

}
