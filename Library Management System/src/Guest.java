import java.util.ArrayList;
import java.util.HashMap;

public class Guest extends Person {
    //VARIABLES
    private final String occupation;
    private static ArrayList<Guest> myGuest = new ArrayList<>();        //It should keep the datas about the guests.
    private HashMap<String, Object> mapGuest = new HashMap<>();         //I will use the "HashMap" to deal with datas."ID" is my key and objects are my values.

    //CONSTRUCTOR
    Guest(String name, String ID, String phone, String occupation) {
        super(ID, name, phone,1,7,0, new ArrayList<>());
        this.occupation = occupation;
    }

    //GETTER
    public String getOccupation() {return occupation;}
    public ArrayList<Guest> getMyGuest() {return myGuest;}
    public HashMap<String, Object> getMapGuest() {return mapGuest;}

    //SETTER
    public void setMyGuest(Guest guest) {myGuest.add(guest);}
    public void setMapGuest(String key, Object value) {mapGuest.put(key, value);}
}
