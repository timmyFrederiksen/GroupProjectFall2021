package csi3471.edu.baylor.ecs.BaylorBurgers.Business;

import java.util.ArrayList;
import java.util.List;

public class Cart {

	protected List<CartItem> items = new ArrayList<CartItem>();

	public List<CartItem> getItems() {
		return items;
	}

	public void setItems(List<CartItem> items) {
		this.items = items;
	}
	
	public void addItem(CartItem item) {
		this.items.add(item);
	}
	
	public Float getTotalPrice() {
		Float total = 0.0f;
		
		for (int i = 0; i < items.size(); i++) {
			total += items.get(i).getTotal();
		}
		
		return total;
	}
	
	public void addDiscount() {
		// FIXME: do this
	}
	
}
