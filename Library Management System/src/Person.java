import java.util.HashMap;

public abstract class Person {
    //VARIABLES
    protected String ID;
    protected String name;
    protected String phone;
    protected int maxItem;
    protected int overDue;
    protected int borrowedItem;
    protected int penalty;

    //CONSTRUCTOR
    Person(String ID, String name, String phone,int maxItem,int overDue,int borrowedItem,int penalty) {
        this.ID = ID;
        this.name = name;
        this.phone = phone;
        this.maxItem = maxItem;
        this.overDue = overDue;
        this.borrowedItem = borrowedItem;
        this.penalty = penalty;
    }

    //GETTER
    public String getID() {return ID;}
    public String getName() {return name;}
    public String getPhone() {return phone;}
    public int getMaxItem() {return maxItem;}
    public int getOverDue() {return overDue;}
    public int getBorrowedItem() {return borrowedItem;}
    public int getPenalty() {return penalty;}

    //SETTER
    public void setID(String ID) {this.ID = ID;}
    public void setName(String name) {this.name = name;}
    public void setPhone(String phone) {this.phone = phone;}
    public void setMaxItem(int maxItem) {this.maxItem = maxItem;}
    public void setOverDue(int overDue) {this.overDue = overDue;}
    public void setBorrowedItem() {this.borrowedItem++;}
    public void setPenalty() {this.penalty += 2;}
}
