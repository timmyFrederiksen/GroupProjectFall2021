package csi3471.edu.baylor.ecs.BaylorBurgers;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import csi3471.edu.baylor.ecs.BaylorBurgers.Business.Cart;
import csi3471.edu.baylor.ecs.BaylorBurgers.Business.CartItem;
import csi3471.edu.baylor.ecs.BaylorBurgers.Business.FoodDescription;


public class CartTester {
	
	protected Cart c = null;
	protected FoodDescription fd = new FoodDescription("Name", "testCategory", 12.00, "none");
	protected CartItem testItem = new CartItem(fd, 1, "no notes", 12.00);
	
	@Test
	public void testCreate() {
		c = new Cart();
		assertTrue(c != null);
	}
	
	@Test
	public void testCartAdd() {
		c = new Cart();
		c.addItem(testItem);
		assertTrue(c.getItems().contains(testItem));
	}
	
	@Test
	public void testPrice() {
		c= new Cart();
		c.addItem(testItem);
		assertTrue(c.getTotalPrice() == 12.0);
	}
	
	@Test
	public void testDiscount() {
		c = new Cart();
		c.addItem(testItem);
		c.addDiscount(100.0);
		assertTrue(c.getTotalPrice() == 0.0);
	}
	
}

