package csi3471.edu.baylor.ecs.BaylorBurgers;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import csi3471.edu.baylor.ecs.BaylorBurgers.Business.FoodDescription;

public class FoodDescriptionTester {

	protected FoodDescription fd = null;
	
	@Test
	public void testCreate() {
		fd = new FoodDescription("Test");
		assertTrue(fd.getCategory() == null);
		assertTrue(fd.getPrice() == 0.0);
		assertTrue(fd.getDetails() == "No Details");
		assertTrue(fd.getName() == "Test");
	}
	
	@Test
	public void testCreate2() {
		fd = new FoodDescription("Test2", "Category1", 5.00, "No onion");
		assertTrue(fd.getCategory() == "Category1");
		assertTrue(fd.getPrice() == 5.0);
		assertTrue(fd.getDetails() == "No onion");
		assertTrue(fd.getName() == "Test2");
	}
	
	@Test
	public void testHashCode() {
		fd = new FoodDescription("Test2", "Category1", 5.00, "No onion");
		FoodDescription fd2 = new FoodDescription("Test2", "Category1", 5.00, "No onion");
		int hash1 = fd.hashCode();
		int hash2 = fd2.hashCode();
		assertTrue(hash1 == hash2);
		assertTrue(fd.equals(fd2));
	}
}
