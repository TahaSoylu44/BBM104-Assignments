import java.util.ArrayList;

/**
 * This abstract class is a super class for Student,Academic and Guest.
 * Contains necessary variables and methods for persons.
 * @author Taha Soylu
 */
public abstract class Person {
    //VARIABLES
    protected String ID;
    protected String name;
    protected String phone;
    protected int maxItem;
    protected int overDue;
    protected int penalty;
    protected ArrayList<Items> borrowedItems = new ArrayList<>();

    /**
     * Constructs a new Person object with the given details.
     * @param ID            Unique person ID
     * @param name          Person name
     * @param phone         Person phone
     * @param maxItem       The max value of the number of the items a person can borrow.
     * @param overDue       How many days can a item be borrowed?
     * @param penalty       If a person reaches the overdue,he/she has to pay penalty.
     * @param borrowedItems Arraylist which shows the borrowed items.
     */
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

    /**
     * Provides returning operation for a user.
     * @param userID   The user who will return his/her item.
     * @param itemID   The item will be returned.
     */
    public static void returning(String userID, String itemID) {
        Person myuser = null;
        Items myitem = null;

        myuser = whichUser(userID, myuser);  //Thanks to this method,we know the user we deal with.
        switch (itemID.charAt(0)) {
            case '1':
                myitem = (Items) Books.getMapBooks().get(itemID);
                break;
            case '2':
                myitem = (Items) Magazine.getMapMagazine().get(itemID);
                break;
            case '3':
                myitem = (Items) DVD.getMapDVDs().get(itemID);
                break;
            default:
                System.out.println("Unknown item detected!");
        }

        assert myitem != null;
        myitem.setOwner(null);
        myitem.setBorrowDate(null);

        assert myuser != null;
        myuser.setBorrowedItemsRemove(myitem);

        System.out.println(myuser.getName() + " successfully returned " + myitem.getTitle());
    }

    /**
     * Provides the information of the user we deal with.
     * @param userID  The user we want to know.
     * @param myuser  a null object which will be reassigned.
     * @return Person object
     */
    public static Person whichUser(String userID, Person myuser) {    //Which user are we dealing with?
        switch (userID.charAt(0)) {                                   //It returns a Person object in accordance with the ID.
            case '1':
                myuser = (Person) Student.getMapStudent().get(userID);
                break;
            case '2':
                myuser = (Person) Academic.getMapAcademic().get(userID);
                break;
            case '3':
                myuser = (Person) Guest.getMapGuest().get(userID);
                break;
            default:
                System.out.println("Unknown user detected!");
                break;
        }
        return myuser;
    }

    //Paying penalty

    /**
     * Provides paying penalty operation.
     * @param userID  The user who will pay his/her penalty.
     */
    public static void pay(String userID) {
        Person myuser = null;

        myuser = Person.whichUser(userID, myuser);

        assert myuser != null;
        myuser.setPenaltyPaid();    //Penalty has been paid.

        System.out.println(myuser.getName() + " has paid penalty");
    }
    //I utilized a method which prints the common parts of displayUsers."Do not Repeat Yourself."

    /**
     * Prints the common parts of displaying users.
     * Provides "Do Not Repeat Yourself" principle.
     * @param user  The user which will be printed.
     */
    public static void printUser(Person user){
        System.out.print("\n------ ");
        System.out.print("User Information for " + user.getID());
        System.out.print(" ------");
        System.out.print("\nName: " + user.getName());
        System.out.print(" Phone: " + user.getPhone());
    }
    //displaying Users

    /**
     * displays users information.
     * Iterates through all Students, Academic, and Guest to display their details.
     * Uses the printUser method for common fields and adds type-specific information.
     */
    public static void displayUsers() {
        if (!Student.getMyStudents().isEmpty()) {
            for (Student user : Student.getMyStudents()) {
                printUser(user);
                System.out.print("\nFaculty: " + user.getFaculty());
                System.out.print(" Department: " + user.getDepartment());
                System.out.print(" Grade: " + user.getGrade() + "th");
                if(user.getPenalty() != 0){
                    System.out.print("\nPenalty: " + user.getPenalty() + "$");
                }
                System.out.println();
            }
        }
        if (!Academic.getMyAcademic().isEmpty()) {
            for (Academic user : Academic.getMyAcademic()) {
                //I need to call the academic members with their titles.
                System.out.print("\n------ ");
                System.out.print("User Information for " + user.getID());
                System.out.print(" ------");
                System.out.print("\nName: " + user.getTitle() + " " + user.getName());
                System.out.print(" Phone: " + user.getPhone());
                System.out.print("\nFaculty: " + user.getFaculty());
                System.out.print(" Department: " + user.getDepartment());
                if(user.getPenalty() != 0){
                    System.out.print("\nPenalty: " + user.getPenalty() + "$");
                }
                System.out.println();
            }
        }
        if (!Guest.getMyGuest().isEmpty()) {
            for (Guest user : Guest.getMyGuest()) {
                printUser(user);
                System.out.print("\nOccupation: " + user.getOccupation());
                if(user.getPenalty() != 0){
                    System.out.print("\nPenalty: " + user.getPenalty() + "$");
                }
                System.out.println();
            }
        }
    }
}