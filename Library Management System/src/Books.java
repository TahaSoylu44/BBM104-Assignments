public class Books extends Library {
    //VARIABLES
    private String classType;
    private String ID;
    private String title;
    private String author;
    private String category;
    private String type;

    //CONSTRUCTOR
    Books(String classType, String ID, String title, String author, String category, String type) {
        this.classType = classType;
        this.ID = ID;
        this.title = title;
        this.author = author;
        this.category = category;
        this.type = type;
    }

    @Override
    public String toString(){
        return classType + " " + ID + " " + title + " " + author + " " + category + " " + type;
    }
}
