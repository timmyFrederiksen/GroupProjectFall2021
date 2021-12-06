package csi3471.edu.baylor.ecs.BaylorBurgers.Business;

public class CartItem {
	
	protected FoodDescription itemType;
	protected Integer quantity;
	protected String orderNotes;
	protected Double price;
	
	public CartItem(FoodDescription itemType, Integer quantity, String orderNotes, Double price) {
		this.itemType = itemType;
		this.quantity = quantity;
		this.orderNotes = orderNotes;
		this.price = price;
	}

	public FoodDescription getItemType() {
		return itemType;
	}

	public void setItemType(FoodDescription itemType) {
		this.itemType = itemType;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getOrderNotes() {
		return orderNotes;
	}

	public void setOrderNotes(String orderNotes) {
		this.orderNotes = orderNotes;
	}
	
	public Double getTotal() {
		return this.quantity * itemType.getPrice();
	}
}
