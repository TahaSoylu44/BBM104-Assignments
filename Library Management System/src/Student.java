import java.util.ArrayList;
import java.util.HashMap;

public class Student extends Person {
    //VARIABLES
    private final String faculty;
    private final String department;
    private final String grade;
    private static ArrayList<Student> myStudents = new ArrayList<>();    //It should keep the datas about the students.
    private HashMap<String, Object> mapStudent = new HashMap<>();        //I will use the "HashMap" to deal with datas."ID" is my key and objects are my values.

    //CONSTRUCTOR
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
    public ArrayList<Student> getMyStudents() {return myStudents;}
    public HashMap<String, Object> getMapStudent() {return mapStudent;}

    //SETTER
    public void setMyStudents(Student student) {myStudents.add(student);}
    public void setMapStudent(String key, Object value) {mapStudent.put(key, value);}
}
