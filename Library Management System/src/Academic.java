import java.util.ArrayList;

public class Academic extends Person {
    //VARIABLES
    private final String faculty;
    private final String department;
    private final String title;

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

    //SETTER
    //No need to implement setter for Academic Class.
}
