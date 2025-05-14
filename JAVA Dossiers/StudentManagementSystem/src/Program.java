import java.util.ArrayList;

public class Program extends AcademicEntity{
    private final String description;
    private final Departments department;
    private final String degreeLevel;
    private final int totalCredits;
    private ArrayList<Course> courseCatalog = new ArrayList<>();

    Program(String code, String name, String description, Departments department, String degreeLevel, int totalCredits) {
        super(code, name);
        this.description = description;
        this.department = department;
        this.degreeLevel = degreeLevel;
        this.totalCredits = totalCredits;
    }

    //GETTER
    public String getDescription() {return description;}
    public Departments getDepartment() {return department;}
    public String getDegreeLevel() {return degreeLevel;}
    public int getTotalCredits() {return totalCredits;}
    public ArrayList<Course> getCourseCatalog() {return courseCatalog;}

    //SETTER
    public void setCourseCatalog(Course course) {courseCatalog.add(course);}
}
