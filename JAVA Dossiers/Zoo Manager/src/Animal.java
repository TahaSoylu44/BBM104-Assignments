import java.util.HashMap;

public abstract class Animal {
    //VARIABLES
    private final String name;
    private final int age;
    private double mealSize;
    private double mealChange;
    private double firstMeal;
    private static HashMap<String,Animal> mapAnimal =new HashMap<>();
    private String cleanSentence;
    private String[] meal;

    /**
     * Constructs animal instances
     * @param name      animal name
     * @param age       animal age
     */
    Animal(String name, int age,String[] meal) {
        this.name = name;
        this.age = age;
        this.meal = meal;
    }

    /**
     * Returns meal size of an animal
     * @param age       animal's age
     * @return          meal size
     */
    public double chooseMealSize(int age){return mealChange * (age - 1) + firstMeal;}

    //GETTERS
    public String getName() {return name;}
    public int getAge() {return age;}
    public double getMealSize() {return mealSize;}
    public double getFirstMeal() {return firstMeal;}
    public double getMealChange() {return mealChange;}
    public static HashMap<String, Animal> getMapAnimal() {return mapAnimal;}
    public String getCleanSentence() {return cleanSentence;}
    public String[] getMeal() {return meal;}

    //SETTERS
    public void setMealSize(double mealSize) {this.mealSize = mealSize;}
    public void setFirstMeal(double firstMeal) {this.firstMeal = firstMeal;}
    public void setMealChange(double mealChange) {this.mealChange = mealChange;}
    public static void setMapAnimal(String key, Animal value) {mapAnimal.put(key,value);}
    public void setCleanSentence(String cleanSentence){this.cleanSentence = cleanSentence;}
}
