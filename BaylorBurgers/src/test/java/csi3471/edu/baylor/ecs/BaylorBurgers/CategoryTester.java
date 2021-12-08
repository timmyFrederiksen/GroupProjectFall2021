package csi3471.edu.baylor.ecs.BaylorBurgers;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import csi3471.edu.baylor.ecs.BaylorBurgers.Business.Category;
import csi3471.edu.baylor.ecs.BaylorBurgers.Business.FoodDescription;

public class CategoryTester {
	
	protected Category c = null;
	
	@Test
	public void testCreate() {
		c = new Category("test");
		assertTrue(c != null);
	}
	
	@Test
	public void testCorrectName() {
		c = new Category("test");
		assertTrue(c.getCategoryName() == "test");
	}
	
	@Test
	public void testEmptyList() {
		c = new Category("test");
		assertTrue(c.getNumberOfItems() == 0);
	}
	
	@Test
	public void testAddItem() {
		FoodDescription fd = new FoodDescription("testfood");
		c = new Category("test");
		c.addItemToCategory(fd);
		assertTrue(c.getFoodInCategory().contains(fd));
	}
	
	@Test
	public void testAddDuplicate() {
		FoodDescription fd = new FoodDescription("testfood");
		c = new Category("test");
		c.addItemToCategory(fd);
		c.addItemToCategory(fd);
		assertTrue(c.getFoodInCategory().contains(fd));
		assertTrue(c.getNumberOfItems() == 1);
	}
	
}
