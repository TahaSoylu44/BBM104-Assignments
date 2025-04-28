import java.util.ArrayList;
import java.util.HashMap;

public class Lion extends Animal {
    private static HashMap<String, Animal> mapLions = new HashMap<>();
    /**
     * Constructs lion instances
     * @param name      lion name
     * @param age       lion age
     */
    Lion(String name, int age) {
        super(name, age);
        setMealChange(0.05);
        setFirstMeal(4.8);
        setMealSize(chooseMealSize(age));
    }

    //GETTERS
    public static HashMap<String, Animal> getLionMap() {return mapLions;}

    //SETTERS
    public static void  setMapLions(String key,Lion value) {mapLions.put(key,value);}
}
