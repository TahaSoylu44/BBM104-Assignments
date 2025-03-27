import java.util.ArrayList;
import java.util.HashMap;

public class Academic extends Person {
    //VARIABLES
    private final String faculty;
    private final String department;
    private final String title;
    private static ArrayList<Academic> myAcademic = new ArrayList<>();       //It should keep the datas about the academic members.
    private HashMap<String, Object> mapAcademic = new HashMap<>();           //I will use the "HashMap" to deal with datas."ID" is my key and objects are my values.


    //CONSTRUCTOR
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
    public ArrayList<Academic> getMyAcademic() {return myAcademic;}
    public HashMap<String, Object> getMapAcademic() {return mapAcademic;}

    //SETTER
    public void setMyAcademic(Academic academic) {myAcademic.add(academic);}
    public void setMapAcademic(String key, Object value) {mapAcademic.put(key, value);}
}
