import java.util.ArrayList;
import java.util.HashMap;

/**
 * DVD class contains specific information about DVDs.
 * Keep DVDs data's.
 * Child class of Items class.
 */
public class DVD extends Items{
    //VARIABLES
    private final String director;
    private final String category;
    private final String runTime;
    private static ArrayList<DVD> myDVDs = new ArrayList<>();         //It should keep the datas about the DVDs.
    private static final HashMap<String, Object> mapDVD = new HashMap<>();   //I will use the "HashMap" to deal with datas."ID" is my key and objects are my values.

    //CONSTRUCTOR
    /**
     * Constructs a new DVD object with the given details.
     * @param ID         DVD ID
     * @param title      DVD Title
     * @param director   Director of DVD
     * @param category   DVD Category
     * @param runTime    DVD Run Time
     * @param type       DVD Type
     */
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
    public static ArrayList<DVD> getMyDVDs() {return myDVDs;}
    public static HashMap<String, Object> getMapDVDs() {return mapDVD;}

    //SETTERS
    public static void setMyDVDs(DVD dvd) {myDVDs.add(dvd);}
    public static void setMapDVDs(String key, Object value) {mapDVD.put(key, value);}
}
