package csi3471.edu.baylor.ecs.BaylorBurgers.Business;

import java.util.ArrayList;
import java.util.List;

/**
 * This object holds CartItem objects as they are added by the user.
 */
public final class Cart {

	protected static List<CartItem> items = new ArrayList<CartItem>();
	protected static double discount = 0.0;

	/**
	 * Gets items in the cart
	 * @return List of items in the cart
	 */
	public List<CartItem> getItems() {
		return items;
	}

	/**
	 * Sets the cart with a list of items.
	 * @param items The list of items to set as the active cart items.
	 */
	public void setItems(List<CartItem> items) {
		Cart.items = items;
	}
	
	/**
	 * Adds a CartItem to the cart.
	 * @param item CartItem to be added to the cart
	 */
	public void addItem(CartItem item) {
		if(!items.contains(item)){
			Cart.items.add(item);
		}
	}
	
	/**
	 * Removes a CartItem from the cart.
	 * @param item The item to be removed from the cart.
	 */
	public static void removeItem(CartItem item) {
			Cart.items.remove(item);
	}
	
	/**
	 * Calculates the total price of the items in the cart.
	 * @return Price of all items in the cart
	 */
	public Double getTotalPrice() {
		Double total = 0.0d;
		
		for (int i = 0; i < items.size(); i++) {
			total += items.get(i).getTotal();
		}
		
		total *= ((100.0 - discount) / 100.0);
		
		return total;
	}
	
	/**
	 * Adds a discount to the cart.
	 * @param discountGot The percent off for the cart
	 */
	public void addDiscount(Double discountGot) {
		discount = discountGot;
	}
	
}
