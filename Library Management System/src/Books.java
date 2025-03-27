import java.util.ArrayList;
import java.util.HashMap;

public class Books extends Items {
    //VARIABLES
    private final String author;
    private final String category;
    private static ArrayList<Books> myBooks = new ArrayList<>();    //It should keep the datas about the books.
    private static HashMap<String, Object> mapBook = new HashMap<>();      //I will use the "HashMap" to deal with datas."ID" is my key and objects are my values.

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
    public static ArrayList<Books> getMyBooks() {return myBooks;}
    public static HashMap<String, Object> getMapBooks() {return mapBook;}

    //SETTERS
    public static void setMyBooks(Books book) {myBooks.add(book);}
    public static void setMapBooks(String key, Object value) {mapBook.put(key, value);}
}
