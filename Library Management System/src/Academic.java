import java.util.ArrayList;
import java.util.HashMap;

/**
 * Academic class contains specific information about academic members.
 * Keeps academic members data's.
 * Child class of Person class.
 * @author Taha Soylu
 */
public class Academic extends Person {
    //VARIABLES
    private final String faculty;
    private final String department;
    private final String title;
    private static ArrayList<Academic> myAcademic = new ArrayList<>();       //It should keep the datas about the academic members.
    private static HashMap<String, Object> mapAcademic = new HashMap<>();           //I will use the "HashMap" to deal with datas."ID" is my key and objects are my values.


    //CONSTRUCTOR
    /**
     * Constructs a new Academic object with the given details.
     * @param name        Academic member name
     * @param ID          Academic unique identifier
     * @param phone       Academic member phone
     * @param department  Academic member department
     * @param faculty     Academic member faculty
     * @param title       What title he/she has
     */
    Academic(String name, String ID, String phone, String department, String faculty, String title) {
        super(ID, name, phone,3,15,0, new ArrayList<>());
        this.faculty = faculty;
        this.department = department;
        this.title = title;
    }

    //GETTER
    public String getFaculty() {return faculty;}
    public String getDepartment() {return department;}
    public String getTitle() {return title;}
    public static ArrayList<Academic> getMyAcademic() {return myAcademic;}
    public static HashMap<String, Object> getMapAcademic() {return mapAcademic;}

    //SETTER
    public static void setMyAcademic(Academic academic) {myAcademic.add(academic);}
    public static void setMapAcademic(String key, Object value) {mapAcademic.put(key, value);}
}
