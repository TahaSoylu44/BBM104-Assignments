public class Magazine extends Items {
    //VARIABLES
    private String publisher;
    private String category;

    //CONSTRUCTOR
    Magazine(String ID, String title, String publisher, String category, String type) {
        super(ID,title,type);   //Inherited from "Items" class
        this.publisher = publisher;
        this.category = category;
    }

    //GETTERS
    public String getID() {
        return ID;
    }
    public String getTitle() {
        return title;
    }
    public String getPublisher() {
        return publisher;
    }
    public String getCategory() {
        return category;
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
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setType(String type) {
        this.type = type;
    }
}
