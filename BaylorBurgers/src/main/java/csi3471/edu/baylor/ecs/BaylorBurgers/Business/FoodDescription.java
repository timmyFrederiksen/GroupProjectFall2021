package csi3471.edu.baylor.ecs.BaylorBurgers.Business;

import java.time.LocalTime;

/**
 * FoodDescription describe an item to be ordered, contains name, category,
 * price, and details.
 */
public class FoodDescription {

	public Long id;
	public String name;
	public String category;
	public Double price;
	public String details;

	/**
	 * Constructs a FoodDescription object with specified name.
	 * @param name Name of the FoodDescription
	 */
	public FoodDescription(String name){
		this.name = name;
		price = 0.0d;
		details = "No Details";
	}

	/**
	 * Constructs a FoodDescription object with specified attributes.
	 * @param name Name of the FoodDescription
	 * @param category Category of the FoodDescription
	 * @param price Price of the FoodDescription
	 * @param details Details regarding the FoodDescription
	 */
	public FoodDescription(String name, String category, Double price, String details) {
		this.name = name;
		this.category = category;
		this.price = price;
		this.details = details;
		id = null;
	}

	/**
	 * Getter for name
	 * @return Name of FoodDescription
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter for name
	 * @param name Name of the FoodDescription
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Getter for price
	 * @return Price of FoodDescription
	 */
	public Double getPrice() {
		return price;
	}

	/**
	 * Setter for price
	 * @param price Price of the FoodDescription
	 */
	public void setPrice(Double price) {
		this.price = price;
	}

	/**
	 * Getter for details
	 * @return Details of FoodDescription
	 */
	public String getDetails() {
		return details;
	}

	/**
	 * Getter for ID
	 * return ID of the FoodDescription
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Setter for id
	 * @param id ID of the FoodDescription
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Getter for category
	 * @return category of FoodDescription
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Setter for category
	 * @param category Category of the FoodDescription
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * Setter for details
	 * @param details Details of the FoodDescription
	 */
	public void setDetails(String details) {
		this.details = details;
	}



}
