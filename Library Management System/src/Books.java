public class Books extends Items {
    //VARIABLES
    private String author;
    private String category;

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
    public void setAuthor(String author){
        this.author = author;
    }
    public void setCategory(String category){
        this.category = category;
    }
}
