package csi3471.edu.baylor.ecs.BaylorBurgers.Business;

import java.util.HashSet;
import java.util.Set;

// NO LONGER USED AS THIS IS HANDLED IN OTHER PLACES RATHER THAN BEING EXTREMELY DISCONNECTED

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
