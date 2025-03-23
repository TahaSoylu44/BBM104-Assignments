public class Magazine extends Items {
    //VARIABLES
    private final String publisher;
    private final String category;

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
    public String getPublisher() {
        return publisher;
    }
    public String getCategory() {
        return category;
    }

    //SETTERS
    //No need to implement setter for Magazine Class.
}
