import java.util.ArrayList;
import java.util.HashMap;

/**
 * Magazine class contains specific information about magazines.
 * Keep magazines data's.
 * Child class of Items class.
 */
public class Magazine extends Items {
    //VARIABLES
    private final String publisher;
    private final String category;
    private static ArrayList<Magazine> myMagazine = new ArrayList<>();       //It should keep the datas about the magazines.
    private static HashMap<String, Object> mapMagazine = new HashMap<>();           //I will use the "HashMap" to deal with datas."ID" is my key and objects are my values.

    //CONSTRUCTOR
    /**
     * Constructs a new Magazine object with the given details.
     * @param ID          Magazine ID
     * @param title       Magazine Title
     * @param publisher   Publisher of Magazine
     * @param category    Magazine Category
     * @param type        Magazine Type
     */
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
    public static ArrayList<Magazine> getMyMagazine() {return myMagazine;}
    public static HashMap<String, Object> getMapMagazine() {return mapMagazine;}

    //SETTERS
    public static void setMyMagazine(Magazine magazine) {myMagazine.add(magazine);}
    public static void setMapMagazine(String key, Object value) {mapMagazine.put(key, value);}
}
