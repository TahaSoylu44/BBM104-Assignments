import java.util.HashMap;

public class Elephant extends Animal {
    private static HashMap<String, Animal> mapElephants = new HashMap<>();
    /**
     * Constructs elephant instances
     * @param name      elephant name
     * @param age       elephant age
     */
    Elephant(String name, int age) {
        super(name,age);
        setMealChange(0.015);
        setFirstMeal(9.715);
        setMealSize(chooseMealSize(age));
    }

    //GETTERS
    public static HashMap<String, Animal> getMapElephants() {return mapElephants;}

    //SETTERS
    public static void  setMapElephants(String key,Elephant value) {mapElephants.put(key,value);}
}
