public abstract class Animal {
    private final String name;
    private final int age;
    private double mealSize;
    private double mealChange;
    private double firstMeal;

    /**
     * Constructs animal instances
     * @param name      animal name
     * @param age       animal age
     */
    Animal(String name, int age) {
        this.name = name;
        this.age = age;
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

    //SETTERS
    public void setMealSize(double mealSize) {this.mealSize = mealSize;}
    public void setFirstMeal(double firstMeal) {this.firstMeal = firstMeal;}
    public void setMealChange(double mealChange) {this.mealChange = mealChange;}
}
