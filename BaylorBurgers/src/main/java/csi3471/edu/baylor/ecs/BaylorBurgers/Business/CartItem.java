package csi3471.edu.baylor.ecs.BaylorBurgers.Business;

import csi3471.edu.baylor.ecs.BaylorBurgers.Presentation.CartGUI;

/**
 * Represents an item to place in a cart.
 */
public class CartItem {
	
	protected FoodDescription itemType;
	protected Integer quantity;
	protected String orderNotes;
	protected Double price;

	/**
	 * Constructs a CartItem with the specified parameters.
	 * @param itemType The type of item (FoodDescription).
	 * @param quantity The number of this item to add to the cart
	 * @param orderNotes The custom notes for the item
	 * @param price The price of the item(s) [itemType.price * quantity]
	 */
	public CartItem(FoodDescription itemType, Integer quantity, String orderNotes, Double price) {
		this.itemType = itemType;
		this.quantity = quantity;
		this.orderNotes = orderNotes;
		this.price = price;
	}

	/**
	 * Gets the item type
	 * @return FoodDescription of the item
	 */
	public FoodDescription getItemType() {
		return itemType;
	}

	/**
	 * Sets the item type to specified FoodDescription
	 * @param itemType FoodDescription to be the new type of item
	 */
	public void setItemType(FoodDescription itemType) {
		this.itemType = itemType;
	}

	/**
	 * Gets the quantity
	 * @return Returns the quantity of the item(s)
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * Sets the quantity
	 * @param quantity New quantity for the item
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	/**
	 * Get the orderNotes for the item
	 * @return Returns the order notes for the item
	 */
	public String getOrderNotes() {
		return orderNotes;
	}

	/**
	 * Sets the order notes to be the specified String
	 * @param orderNotes The new order notes
	 */
	public void setOrderNotes(String orderNotes) {
		this.orderNotes = orderNotes;
	}
	
	/**
	 * Calculates the total for the item [quantity * price of 1]
	 * @return total cost
	 */
	public Double getTotal() {
		return this.quantity * itemType.getPrice();
	}
}
