public class Elephant extends Animal {
    /**
     * Constructs elephant instances
     * @param name      elephant name
     * @param age       elephant age
     */
    Elephant(String name, int age) {
        super(name,age,new String[]{"plants"});
        setMealChange(0.015);       //meal size change in accordance with age
        setFirstMeal(9.715);        //meal size for age 1
        setMealSize(chooseMealSize(age));
        setCleanSentence("Washing the water area.");
        System.out.println("Added new Elephant with name " + name + " aged " + age + ".");
    }
}