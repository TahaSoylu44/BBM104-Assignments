import java.util.ArrayList;

public class Student extends Person {
    //VARIABLES
    private String faculty;
    private String department;
    private String grade;

    //CONSTRUCTOR
    Student(String name, String ID, String phone, String faculty, String department, String grade) {
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
    public void setFaculty(String faculty) {this.faculty = faculty;}
    public void setDepartment(String department) {this.department = department;}
    public void setGrade(String grade) {this.grade = grade;}
}
