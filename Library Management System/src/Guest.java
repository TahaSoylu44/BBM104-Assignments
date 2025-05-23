import java.util.ArrayList;
import java.util.HashMap;

/**
 * Guest class contains specific information about guests.
 * Keep guests data's.
 * Child class of Person class.
 * @author Taha Soylu
 */
public class Guest extends Person {
    //VARIABLES
    private final String occupation;
    private static ArrayList<Guest> myGuest = new ArrayList<>();        //It should keep the datas about the guests.
    private static HashMap<String, Object> mapGuest = new HashMap<>();         //I will use the "HashMap" to deal with datas."ID" is my key and objects are my values.

    //CONSTRUCTOR
    /**
     * Constructs a new Academic object with the given details.
     * @param name         Guest name
     * @param ID           Guest unique identifier
     * @param phone        Guest Phone
     * @param occupation   Guest occupation
     */
    Guest(String name, String ID, String phone, String occupation) {
        super(ID, name, phone,1,7,0, new ArrayList<>());
        this.occupation = occupation;
    }

    //GETTER
    public String getOccupation() {return occupation;}
    public static ArrayList<Guest> getMyGuest() {return myGuest;}
    public static HashMap<String, Object> getMapGuest() {return mapGuest;}

    //SETTER
    public static void setMyGuest(Guest guest) {myGuest.add(guest);}
    public static void setMapGuest(String key, Object value) {mapGuest.put(key, value);}
}
