import java.util.ArrayList;

public class Course extends AcademicEntity{
    private final Departments department;
    private final int credit;
    private final String semester;
    private final Program program;
    private AcademicMember instructor;
    private ArrayList<Student> students = new ArrayList<>();

    Course(String code, String name, Departments department, int credit, String semester, Program program) {
        super(code, name);
        this.department = department;
        this.credit = credit;
        this.semester = semester;
        this.program = program;
    }

    //GETTER
    public Departments getDepartment() {return department;}
    public int getCredit() {return credit;}
    public String getSemester() {return semester;}
    public Program getProgram() {return program;}
    public AcademicMember getInstructor() {return instructor;}
    public ArrayList<Student> getStudents() {return students;}

    //SETTER
    public void setInstructor(AcademicMember instructor) {this.instructor = instructor;}
    public void setStudents(Student student) {students.add(student);}

    public static double avGrade(Course course){
        int numOfStudents = course.getStudents().size();
        double result = 0;

        for (Student student : course.getStudents()){
            result = result + StudentManagementSystem.convertToDouble(student.getLectureGrades().get(course));
        }
        return result / numOfStudents;
    }
}
