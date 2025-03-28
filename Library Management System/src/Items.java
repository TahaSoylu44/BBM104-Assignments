import java.time.LocalDate;

public abstract class Items {
    //VARIABLES
    protected String ID;
    protected String title;
    protected String type;
    protected LocalDate borrowDate;
    protected String owner = null;
    protected int overDue;

    //CONSTRUCTOR
    Items(String Id, String title, String type) {
        this.ID = Id;
        this.title = title;
        this.type = type;

    }

    //GETTER
    public String getID() {return ID;}
    public String getTitle() {return title;}
    public String getType() {return type;}
    public LocalDate getBorrowDate() {return borrowDate;}
    public String getOwner() {return owner;}
    public int getOverDue() {return overDue;}

    //SETTER
    public void setBorrowDate(LocalDate borrowDate) {this.borrowDate = borrowDate;}
    public void setOwner(String owner) {this.owner = owner;}
    public void setOverDue(int overDue) {this.overDue = overDue;}
}
