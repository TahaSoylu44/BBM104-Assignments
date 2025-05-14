import java.util.ArrayList;
import java.util.HashMap;

public abstract class Person {
    private final String ID;
    private final String name;
    private final String email;
    private final String department;
    private static HashMap<String, Person> mapPersons = new HashMap<>();
    private ArrayList<Course> lectures = new ArrayList<>();

    Person(String ID, String name, String email, String department) {
        this.ID = ID;
        this.name = name;
        this.email = email;
        this.department = department;
    }

    //GETTER
    public String getID() {return ID;}
    public String getName() {return name;}
    public String getEmail() {return email;}
    public String getDepartment() {return department;}
    public static HashMap<String, Person> getMapPersons() {return mapPersons;}
    public ArrayList<Course> getLectures() {return lectures;}

    //SETTER
    public static void setMapPersons(String ID, Person person) {mapPersons.put(ID, person);}
    public void setLectures(Course course) {lectures.add(course);}
}