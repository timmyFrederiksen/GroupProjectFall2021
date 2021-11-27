package csi3471.edu.baylor.ecs.BaylorBurgers;

import java.util.ArrayList;

public class Category {

    private String categoryName = "";
    private Integer numberOfItems = 0;
    private ArrayList<FoodDescription> foodInCategory;

    Category(String categoryName){
        this.categoryName = categoryName;
        foodInCategory = new ArrayList<>();
    }

    public void addItemToCategory(FoodDescription fd){
        if(!foodInCategory.contains(fd)) {
            foodInCategory.add(fd);
            numberOfItems++;
        }
    }
    public ArrayList<FoodDescription> getFoodInCategory(){
        return foodInCategory;
    }
    public void removeItemToCategory(FoodDescription fd){
        foodInCategory.remove(fd);
        numberOfItems--;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }
}
