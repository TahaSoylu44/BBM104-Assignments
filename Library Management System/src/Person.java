public abstract class Person {
    //VARIABLES
    protected String ID;
    protected String name;
    protected String phone;
    protected int maxItem;
    protected int overDue;

    //CONSTRUCTOR
    Person(String ID, String name, String phone,int maxItem,int overDue) {
        this.ID = ID;
        this.name = name;
        this.phone = phone;
        this.maxItem = maxItem;
        this.overDue = overDue;
    }

    //GETTER
    public String getID() {return ID;}
    public String getName() {return name;}
    public String getPhone() {return phone;}
    public int getMaxItem() {return maxItem;}

    //SETTER
    public void setID(String ID) {this.ID = ID;}
    public void setName(String name) {this.name = name;}
    public void setPhone(String phone) {this.phone = phone;}
}
