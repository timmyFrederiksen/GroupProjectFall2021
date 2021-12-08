package csi3471.edu.baylor.ecs.BaylorBurgers.Business;

import java.util.ArrayList;

/**
 * The category object defines a type for FoodDescription objects.
 */
public class Category {

    private String categoryName = "";
    private Integer numberOfItems = 0;
    private ArrayList<FoodDescription> foodInCategory;

    /**
     * Constructs a Category.
     * @param categoryName Name of the category
     */
    public Category(String categoryName){
        this.categoryName = categoryName;
        foodInCategory = new ArrayList<>();
    }

    /**
     * Adds item to the category.
     * @param fd The food item to be added to the category
     */
    public void addItemToCategory(FoodDescription fd){
        if(!foodInCategory.contains(fd)) {
            foodInCategory.add(fd);
            numberOfItems++;
        }
    }
    
    /**
     * Gets all FoodDescription objects associated with the category.
     * @return List of all FoodDescription objects associated with the 
     * category.
     */
    public ArrayList<FoodDescription> getFoodInCategory(){
        return foodInCategory;
    }
    
    /**
     * Removes a FoodDescription object from a category.
     * @param fd FoodDescription to be removed
     */
    public void removeItemToCategory(FoodDescription fd){
        foodInCategory.remove(fd);
        numberOfItems--;
    }

    /**
     * Gets the category name
     * @return Category name String
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * Sets the category name.
     * @param categoryName String to set as the name of the category.
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * Gets the number of items in a category
     * @return The number of items in a category.
     */
    public int getNumberOfItems() {
        return numberOfItems;
    }
}
