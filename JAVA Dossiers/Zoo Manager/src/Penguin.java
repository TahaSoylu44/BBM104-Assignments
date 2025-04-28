import java.util.HashMap;

public class Penguin extends Animal{
    private static HashMap<String, Animal> mapPenguins = new HashMap<>();
    /**
     * Constructs penguin instances
     * @param name      penguin name
     * @param age       penguin age
     */
    Penguin(String name, int age) {
        super(name,age);
        setMealChange(0.04);
        setFirstMeal(2.88);
        setMealSize(chooseMealSize(age));
    }

    //GETTERS
    public static HashMap<String, Animal> getMapPenguins() {return mapPenguins;}

    //SETTERS
    public static void  setMapPenguins(String key,Penguin value) {mapPenguins.put(key,value);}
}
