package csi3471.edu.baylor.ecs.BaylorBurgers.Business;

import java.util.HashSet;
import java.util.Set;

/**
 * This class is a Menu object and holds items on that menu.
 */
public class Menu {
	
	Set<FoodDescription> items;
	
	/**
	 * Constructs a Menu object
	 */
	public Menu() {
		items = new HashSet<FoodDescription>(); 
	}
	

}
