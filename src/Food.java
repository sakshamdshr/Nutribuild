/**
 * A class that contains information of an individual food item 
 * for the nutrition builder application.
 * @author saksham shrestha
 *
 */
public class Food {

    /**
     * instance integer variable for calories of food item.
     */
    public int calories;
    
    /**
     * instance string variable for name of food item.
     */
    public String name;
    
    /**
     * instance string array variable for list of allergens.
     */
    public String[] allergens;
    
    /**
     *  instance boolean variable for availability of food item.
     */
    public boolean available = true;

    /**
     * Constructor for a food item.
     * @param n the name of the food item.
     * @param cal the calorie content of the food item.
     */
    public Food(String n, int cal) {
        this.calories = cal;
        this.name = n;
    }

    /**
     * Getter method for food item's name.
     * @return the String name of the food item.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Setter method for food item's name.
     * @param n the string to be set as food name.
     */
    public void setName(String n) {
        name = n;
    }

    /**
     * Getter method for food item's calories.
     * @return the integer calorie count of the food item.
     */
    public int getCalories() {
        return this.calories;
    }

    /**
     * The setter method for calories of food item.
     * @param c the food item's calorie count.
     */
    public void setCalories(int c) {
        calories = c;
    }

    /**
     * The setter method for allergen list of food item.
     * @param s the string array of allergens.
     */
    public void setAllergens(String[] s) {
        allergens = s;
    }

    /**
     * Getter method for food item's allergen list.
     * @return the string array of allergens.
     */
    public String[] getAllergens() {
        return allergens;
    }

    /**
     * The setter method for availability of food item.
     * @param b the boolean for the item's availability.
     */
    public void setAvailable(Boolean b) {
        available = b;
    }
}
