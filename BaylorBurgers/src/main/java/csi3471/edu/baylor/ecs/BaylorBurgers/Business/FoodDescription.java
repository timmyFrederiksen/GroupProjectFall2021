package csi3471.edu.baylor.ecs.BaylorBurgers.Business;

import java.time.LocalTime;

public class FoodDescription {

	public Long id;
	public String name;
	public String category;
	public Double price;
	public String details;

	public FoodDescription(String name){
		this.name = name;
		price = 0.0d;
		details = "No Details";
	}


	public FoodDescription(String name, String category, Double price, String details) {
		this.name = name;
		this.category = category;
		this.price = price;
		this.details = details;
		id = (long) 0;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public String getDetails() {
		return details;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public void setDetails(String details) {
		this.details = details;
	}



}
