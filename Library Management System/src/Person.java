import java.util.ArrayList;

public abstract class Person {
    //VARIABLES
    protected String ID;
    protected String name;
    protected String phone;
    protected int maxItem;
    protected int overDue;
    protected int penalty;
    protected ArrayList<Items> borrowedItems = new ArrayList<>();

    //CONSTRUCTOR
    Person(String ID, String name, String phone,int maxItem,int overDue,int penalty,ArrayList<Items> borrowedItems) {
        this.ID = ID;
        this.name = name;
        this.phone = phone;
        this.maxItem = maxItem;
        this.overDue = overDue;
        this.penalty = penalty;
        this.borrowedItems = borrowedItems;
    }

    //GETTER
    public String getID() {return ID;}
    public String getName() {return name;}
    public String getPhone() {return phone;}
    public int getMaxItem() {return maxItem;}
    public int getOverDue() {return overDue;}
    public int getPenalty() {return penalty;}
    public ArrayList<Items> getBorrowedItems() {return borrowedItems;}

    //SETTER
    public void setPenaltyPlus() {this.penalty += 2;}
    public void setPenaltyPaid() {this.penalty = 0;}
    public void setBorrowedItemsAdd(Items item){this.borrowedItems.add(item);}
    public void setBorrowedItemsRemove(Items item){this.borrowedItems.remove(item);}
}
