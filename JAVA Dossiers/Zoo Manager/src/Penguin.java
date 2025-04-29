public class Penguin extends Animal{
    /**
     * Constructs penguin instances
     * @param name      penguin name
     * @param age       penguin age
     */
    Penguin(String name, int age) {
        super(name,age,new String[]{"fish"});
        setMealChange(0.04);    //meal size change in accordance with age
        setFirstMeal(2.88);     //meal size for age 1
        setMealSize(chooseMealSize(age));
        setCleanSentence("Replenishing ice and scrubbing walls.");
        System.out.println("Added new Penguin with name " + name + " aged " + age + ".");
    }
}