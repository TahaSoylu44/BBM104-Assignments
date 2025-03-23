public class DVD extends Items{
    //VARIABLES
    private final String director;
    private final String category;
    private final String runTime;

    //CONSTRUCTOR
    DVD(String ID, String title, String director, String category,String runTime, String type) {
        super(ID, title, type);    //Inherited from "Items" class
        this.director = director;
        this.category = category;
        this.runTime = runTime;
    }

    //GETTERS
    public String getID() {
        return ID;
    }
    public String getDirector() {
        return director;
    }
    public String getCategory() {
        return category;
    }
    public String getRunTime() {
        return runTime;
    }

    //SETTERS
    //No need to implement setter for DVD Class.
}
