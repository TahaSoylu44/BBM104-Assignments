import java.util.ArrayList;
import java.util.HashMap;

public class Magazine extends Items {
    //VARIABLES
    private final String publisher;
    private final String category;
    private static ArrayList<Magazine> myMagazine = new ArrayList<>();       //It should keep the datas about the magazines.
    private HashMap<String, Object> mapMagazine = new HashMap<>();           //I will use the "HashMap" to deal with datas."ID" is my key and objects are my values.

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
    public ArrayList<Magazine> getMyMagazine() {return myMagazine;}
    public HashMap<String, Object> getMapMagazine() {return mapMagazine;}

    //SETTERS
    public void setMyMagazine(Magazine magazine) {myMagazine.add(magazine);}
    public void setMapMagazine(String key, Object value) {mapMagazine.put(key, value);}
}
