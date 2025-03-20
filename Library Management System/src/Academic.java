public class Academic extends Person {
    //VARIABLES
    private String faculty;
    private String department;
    private String title;

    //CONSTRUCTOR
    Academic(String name, String ID, String phone, String faculty, String department, String title) {
        super(ID, name, phone,3,15,0);
        this.faculty = faculty;
        this.department = department;
        this.title = title;
    }

    //GETTER
    public String getFaculty() {return faculty;}
    public String getDepartment() {return department;}
    public String getTitle() {return title;}

    //SETTER
    public void setFaculty(String faculty) {this.faculty = faculty;}
    public void setDepartment(String department) {this.department = department;}
    public void setTitle(String title) {this.title = title;}
}
