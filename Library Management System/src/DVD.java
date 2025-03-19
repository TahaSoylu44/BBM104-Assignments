public class DVD extends Items{
    //VARIABLES
    private String director;
    private String category;
    private String runTime;

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
    public String getTitle() {
        return title;
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
    public String getType() {
        return type;
    }

    //SETTERS
    public void setID(String ID) {
        this.ID = ID;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setRunTime(String runTime) {
        this.runTime = runTime;
    }
    public void setType(String type) {
        this.type = type;
    }
}
