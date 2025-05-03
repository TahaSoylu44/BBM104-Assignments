public class Lion extends Animal {
    /**
     * Constructs lion instances
     * @param name      lion name
     * @param age       lion age
     */
    Lion(String name, int age) {
        super(name, age, new String[]{"meat"},5);
        setMealChange(0.05);        //meal size change in accordance with age
        setDefaultAge(5);           //Based on PDF
        setMealSize(chooseMealSize(age));
        setCleanSentence("Removing bones and refreshing sand.");
        System.out.println("Added new Lion with name " + name + " aged " + age + ".");
    }
}