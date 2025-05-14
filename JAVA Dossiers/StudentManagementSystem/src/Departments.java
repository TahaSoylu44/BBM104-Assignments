public class Departments extends AcademicEntity{
    private final String description;
    private final AcademicMember head;

    Departments(String code, String name, String description, AcademicMember head) {
        super(code, name);
        this.description = description;
        this.head = head;
    }

    //GETTER
    public String getDescription() {return description;}
    public AcademicMember getHead() {return head;}
}
