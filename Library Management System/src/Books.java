public class Books extends Items {
    //VARIABLES
    private final String author;
    private final String category;

    //CONSTRUCTOR
    Books(String ID, String title, String author, String category, String type) {
        super(ID,title,type);  //Inherited from "Items" class
        this.category = category;
        this.author = author;
    }

    //GETTERS
    public String getAuthor(){
        return author;
    }
    public String getCategory(){
        return category;
    }

    //SETTERS
    //No need to implement setter for Books Class.
}
