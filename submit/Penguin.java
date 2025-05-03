public class Penguin extends Animal{
    /**
     * Constructs penguin instances
     * @param name      penguin name
     * @param age       penguin age
     */
    Penguin(String name, int age) {
        super(name,age,new String[]{"fish"},3);
        setMealChange(0.04);    //meal size change in accordance with age
        setDefaultAge(4);
        setMealSize(chooseMealSize(age));
        setCleanSentence("Replenishing ice and scrubbing walls.");
        System.out.println("Added new Penguin with name " + name + " aged " + age + ".");
    }
}