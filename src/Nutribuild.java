import java.util.ArrayList;
import java.util.Scanner;

/**
 * A simple program to track of total calories eaten in a day.
 * @author saksham shresths
 *
 */
public class Nutribuild {

    /**
     * Instance variable for array list of Meal objects for the day.
     */
    public static ArrayList<Meal> mealList = new ArrayList<>();

    /**
     * Instance variable for person's age and weight as an array list of 
     * two integers.
     */
    private static int[] dets;

    /**
     * Instance variable for user's fitness goal as an integer.
     * Key:
     * 1: Gain Weight
     * 2: Lose Weight
     * 3: Maintain Weight
     */
    public static int goal;

    /**
     * Instance variable for user's name.
     */
    protected static String name;

    /**
     * Instance variable for boolean of app's state.
     * Main method is looped as long as state is true.
     */
    public static boolean state = true;

    /**
     * Instance variable for total calories consumed in the day,
     * stored as an integer.
     */
    public static int calSum;

    /**
     * Instance variable for index of mealList
     * that contains the highest calorie meal.
     */
    public static int biggie;


    public static void main(String[] args) {
        while (state) {
            try {
                detGatherer();
                goalGatherer();
                mealListBuilder();
                appInterface();
            } catch (Exception e) {
                //the program is rerun if error occurs
                System.out.println("something went wrong please try again... ");
                continue;
            }
            state = false;

            //ending message
            System.out.println("\nThank you, hope to see you tomorrow !");
        }
    } //main method end.

    /**
     * Method collects user's name age and weight.
     * 
     */
    public static void detGatherer() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter name: ");
        name = in.next();

        System.out.printf("Hi %s, ", name);
        System.out.println("welcome to the calorie tracker v1.0 ! ");
        System.out.println("To begin, enter your age:  ");


        int age = in.nextInt();

        System.out.println("Great, now enter your current"
                + " weight as a whole number (Kgs): ");
        int weight = in.nextInt();

        dets =  new int[] {age, weight};
    }

    /**
     * Method collects user's fitness goal.
     */
    public static void goalGatherer() {
        System.out.println("Now let's talk about your fitness goals... ");
        System.out.println("What would you like to do? ");
        System.out.println("[1] Gain Weight");
        System.out.println("[2] Lose Weight");
        System.out.println("[3] Maintain Weight");
        System.out.println(": ");

        Scanner in = new Scanner(System.in);
        goal = in.nextInt();
        System.out.printf("Got it, we'd be happy to help ! \n\n\n");
        System.out.println("Let's get tracking.. ");
    }

    /**
     * Method collects information about the day's meals and
     * stores them in mealList.
     */
    public static void mealListBuilder() {
        System.out.println("How many meals did you have today? ");
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();


        for (int i = 1; i <= num; i++) {
            mealList.add(mealBuilder(i));
        }

    }

    /**
     * Helper method that collects information and returns
     * a Meal object using it.
     * @param a the nth number of meal for the day.
     * @return a Meal object 
     */
    public static Meal mealBuilder(int a) {
        System.out.printf("What's the name of MEAL number %d ?\n",a);
        Scanner in = new Scanner(System.in);
        String mealName = in.next();
        System.out.println("How many food items did it have?");
        int foodAmt = in.nextInt();

        ArrayList<Food> foodList = new ArrayList<>();

        for (int i = 1; i <= foodAmt; i++) {
            foodList.add(foodBuilder(i));  
        }

        Meal temp = new Meal(mealName, foodList);

        return temp;

    }

    /**
     * A helper method that collects information and returns
     *  a food object using it.
     * @param a the nth number of food in the meal.
     * @return a Food Object.
     */
    public static Food foodBuilder(int a) {


        System.out.printf("What's the name of food number %d ?\n",a);
        Scanner in = new Scanner(System.in);
        String foodName = in.next();
        System.out.printf("What's the amt of calories in %d ?\n",a);
        int foodCal = in.nextInt();

        Food temp = new Food(foodName, foodCal);

        return temp;

    }

    /**
     *  Method calculates and show information about 
     *  the day's calorie consumption.
     */
    public static void appInterface() {
        System.out.println("Great! Now that we've colleted data, ");
        System.out.println("let's do some analysing ! ");

        kowalskiAnalysis();
        System.out.println("Overall Calories Consumed Today: " + calSum);
        System.out.println("Heaviest meal: meal number " + (biggie + 1));
        System.out.println("Info of biggest meal: ");
        mealList.get(biggie).printInfo();
    }

    /**
     * Helper method to process calorie information.
     * Method sets instance variables caclSum and biggie.
     */
    public static void kowalskiAnalysis() {
        calSum = 0;
        int max = 0;

        for (int i = 0; i < mealList.size(); i++) {
            calSum += mealList.get(i).getCal();
            if (mealList.get(i).getCal() > max) {
                max = mealList.get(i).getCal();
                biggie = i;
            }
        }


    }


}

