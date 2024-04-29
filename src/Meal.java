import java.util.ArrayList;

/**
 * A class that contains information about a meal to be tracked.
 * @author saksham shrestha
 *
 */
public class Meal {

    /**
     * Instance string variable for name of meal.
     */
    public String name;

    /**
     *  Instance boolean variable for availability of meal.
     */
    public boolean available = true;

    /**
     *  Instance array list of Food for list of food items
     *  in the meal.
     */
    public ArrayList<Food> foodList;

    /**
     * Constructor method for a Meal.
     * @param name The name of the meal.
     * @param food The list of food items.
     */
    public Meal(String name, ArrayList<Food> food) {
        this.name = name;
        this.foodList = food;
        for (int i = 0; i < foodList.size();i++) {
            if (foodList.get(i).available == false) {
                available = false;
            }
        }
    }


    /**
     * Method returns total calories of the meal.
     * @return the meal's calorie count as an integer.
     */
    public int getCal() {
        int sum = 0;
        for (int i = 0; i < foodList.size();i++) {
            sum += foodList.get(i).getCalories();
        }
        return sum; 
    }

    /**
     * Method to add a food item to a meal.
     * @param i the food item to add.
     */
    public void addIngredient(Food i) {
        foodList.add(i);
    }

    /**
     * Method that prints all the information of the meal.
     * The name is printed first,
     * followed by it's availability
     * followed by the ingredients.
     */
    public void printInfo() {
        System.out.println("Name: " + getName());
        if (available == false) {
            System.out.println("Warning, 1 or more food itemsnot available");
        }
        System.out.println("Ingredients: ");
        for (int i = 0; i < foodList.size();i++) {
            System.out.printf("[%d] %s, calories: %d\n",i + 1,
                    foodList.get(i).name, foodList.get(i).getCalories());
        }
    }

    /**
     * Getter method to get name of Meal.
     * @return the String containing the name of the meal;
     */
    public String getName() {
        return this.name;
    }

    /**
     * Method to set name of the meal.
     * @param s the string to be set as meal's name.
     */
    public void setName(String s) {
        this.name = s;
    }

    /**
     * Method that returns availability of meal.
     * @return the availability of the meal as a boolean.
     */
    public boolean getAvailability() {
        return available;
    }

    /**
     * Method to set the availability of meal.
     * @param b the availability.
     */
    public void setAvailability(boolean b) {
        this.available = b;
    }
}
