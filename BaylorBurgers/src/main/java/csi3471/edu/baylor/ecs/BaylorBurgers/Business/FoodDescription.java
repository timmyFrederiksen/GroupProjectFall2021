package csi3471.edu.baylor.ecs.BaylorBurgers.Business;

import java.time.LocalTime;

public class FoodDescription {
	
	public String name;
	public Float price;
	public String details;
	public LocalTime startTime;
	public LocalTime endTime;

	public FoodDescription(String name){
		this.name = name;
		price = 0.0f;
		details = "No Details";
		startTime = LocalTime.now();
		endTime = LocalTime.now();
	}
	
	
	public FoodDescription(String name, Float price, String details,
			LocalTime startTime, LocalTime endTime) {
		this.name = name;
		this.price = price;
		this.details = details;
		this.startTime = startTime;
		this.endTime = endTime;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Float getPrice() {
		return price;
	}


	public void setPrice(Float price) {
		this.price = price;
	}


	public String getDetails() {
		return details;
	}


	public void setDetails(String details) {
		this.details = details;
	}


	public LocalTime getStartTime() {
		return startTime;
	}


	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}


	public LocalTime getEndTime() {
		return endTime;
	}


	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}
}
