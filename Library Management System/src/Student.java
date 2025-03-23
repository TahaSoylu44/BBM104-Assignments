import java.util.ArrayList;

public class Student extends Person {
    //VARIABLES
    private final String faculty;
    private final String department;
    private final String grade;

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

    //SETTER
    //No need to implement setter for Student Class.
}
