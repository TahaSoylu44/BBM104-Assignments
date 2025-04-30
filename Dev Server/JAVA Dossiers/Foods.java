public class Foods {
    //VARIABLES
    private double meat;
    private double plants;
    private double fish;

    Foods(double meat, double plants, double fish) {
        this.meat = meat;
        this.plants = plants;
        this.fish = fish;
        System.out.println("There are " + meat + " kg of Meat in stock");
        System.out.println("There are " + fish + " kg of Fish in stock");
        System.out.println("There are " + plants + " kg of Plant in stock");
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
        System.out.println("Plant: " + getPlants() + " kgs");
        System.out.println("Fish: " + getFish() + " kgs");
        System.out.println("Meat: " + getMeat() + " kgs");
    }
}