public class Chimpanzee extends Animal {
    /**
     * Constructs chimpanzee instances
     * @param name      chimpanzee name
     * @param age       chimpanzee age
     */
    Chimpanzee(String name, int age) {
        super(name,age,new String[]{"meat","plants"},3);
        setMealChange(0.025);       //meal size change in accordance with age
        setDefaultAge(10);
        setMealSize(chooseMealSize(age));
        setCleanSentence("Sweeping the enclosure and replacing branches.");
        System.out.println("Added new Chimpanzee with name " + name + " aged " + age + ".");
    }
}