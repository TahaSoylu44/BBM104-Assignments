import java.util.HashMap;

public class Chimpanzee extends Animal {
    private static HashMap<String, Animal> mapChimpanzees = new HashMap<>();
    /**
     * Constructs chimpanzee instances
     * @param name      chimpanzee name
     * @param age       chimpanzee age
     */
    Chimpanzee(String name, int age) {
        super(name,age);
        setMealChange(0.025);
        setFirstMeal(2.775);
        setMealSize(chooseMealSize(age));
    }

    //GETTERS
    public static HashMap<String, Animal> getMapChimpanzees() {return mapChimpanzees;}

    //SETTERS
    public static void  setMapChimpanzees(String key,Chimpanzee value) {mapChimpanzees.put(key,value);}
}
