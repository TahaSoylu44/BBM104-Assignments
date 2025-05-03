/**
 * This class contains food information.
 */
public class Foods {
    //VARIABLES
    private double meat;
    private double plants;
    private double fish;

    Foods(double meat, double plants, double fish) {
        this.meat = meat;
        this.plants = plants;
        this.fish = fish;
        System.out.printf("There are %.3f kg of Meat in stock\n",meat);
        System.out.printf("There are %.3f kg of Fish in stock\n",fish);
        System.out.printf("There are %.3f kg of Plant in stock\n",plants);
    }

    //GETTERS
    public double getMeat() {return meat;}
    public double getPlants() {return plants;}
    public double getFish() {return fish;}

    //SETTERS
    public void setMeat(double amount) {meat -= amount;}
    public void setPlants(double amount) {plants -= amount;}
    public void setFish(double amount) {fish -= amount;}

    //Listing foods
    public void listFood(){
        System.out.println("Listing available Food Stock:");
        System.out.printf("Plant: %.3f kgs\n", getPlants());
        System.out.printf("Fish: %.3f kgs\n", getFish());
        System.out.printf("Meat: %.3f kgs\n", getMeat());
    }
}