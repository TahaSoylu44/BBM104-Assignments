import java.util.HashMap;

/**
 * This abstract class is a super class for Lion,Elephant,Penguin and Chimpanzee.
 * Contains necessary variables and methods for items.
 * @author Taha Soylu
 */
public abstract class Animal {
    //VARIABLES
    private final String name;          //Animal name
    private final int age;              //Animal age
    private double mealSize;            //How much meal can animal eat once
    private double mealChange;          //meal change for ages based on PDF
    private int defaultAge;             //The default age in PDF
    private static HashMap<String,Animal> mapAnimal =new HashMap<>();           //The data structure which is used to access animal data's.
    private String cleanSentence;       //The sentence for cleaning operation
    private final String[] meal;        //What animal eat
    private final double defaultSizeMeal;//The default meal size based on PDF

    /**
     * Constructs animal instances
     * @param name      animal name
     * @param age       animal age
     */
    Animal(String name, int age,String[] meal,double defaultSizeMeal) {
        this.name = name;
        this.age = age;
        this.meal = meal;
        this.defaultSizeMeal = defaultSizeMeal;
    }

    /**
     * Returns meal size of an animal based on its age.
     * @param age       animal's age
     * @return          meal size
     */
    public double chooseMealSize(int age){return (age - defaultAge) * mealChange + defaultSizeMeal;}
    //public double chooseMealSize(int age){return (mealChange * (age - 1) + firstMeal) * defaultSizeMeal;}

    //GETTERS
    public String getName() {return name;}
    public int getAge() {return age;}
    public double getMealSize() {return mealSize;}
    public int getDefaultAge() {return defaultAge;}
    public double getMealChange() {return mealChange;}
    public static HashMap<String, Animal> getMapAnimal() {return mapAnimal;}
    public String getCleanSentence() {return cleanSentence;}
    public String[] getMeal() {return meal;}

    //SETTERS
    public void setMealSize(double mealSize) {this.mealSize = mealSize;}
    public void setDefaultAge(int defaultAge) {this.defaultAge = defaultAge;}
    public void setMealChange(double mealChange) {this.mealChange = mealChange;}
    public static void setMapAnimal(String key, Animal value) {mapAnimal.put(key,value);}
    public void setCleanSentence(String cleanSentence){this.cleanSentence = cleanSentence;}
}
