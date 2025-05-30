import java.util.ArrayList;
import java.util.HashMap;

/**
 * Student class contains specific information about students.
 * Keeps student data's.
 * Child class of Person class.
 * @author Taha Soylu
 */
public class Student extends Person {
    //VARIABLES
    private final String faculty;
    private final String department;
    private final String grade;
    private static ArrayList<Student> myStudents = new ArrayList<>();    //It should keep the datas about the students.
    private static HashMap<String, Object> mapStudent = new HashMap<>();        //I will use the "HashMap" to deal with datas."ID" is my key and objects are my values.

    //CONSTRUCTOR
    /**
     * Constructs a new Students object with the given details.
     * @param name          Student name
     * @param ID            Student unique identifier.
     * @param phone         Student phone
     * @param department    What a student studies?
     * @param faculty       Faculty of a student
     * @param grade         Which grade is he/she?
     */
    Student(String name, String ID, String phone, String department, String faculty, String grade) {
        super(ID, name, phone,5,30,0, new ArrayList<>());
        this.faculty = faculty;
        this.department = department;
        this.grade = grade;
    }

    //GETTER
    public String getFaculty() {return faculty;}
    public String getDepartment() {return department;}
    public String getGrade() {return grade;}
    public static ArrayList<Student> getMyStudents() {return myStudents;}
    public static HashMap<String, Object> getMapStudent() {return mapStudent;}

    //SETTER
    public static void setMyStudents(Student student) {myStudents.add(student);}
    public static void setMapStudent(String key, Object value) {mapStudent.put(key, value);}
}
