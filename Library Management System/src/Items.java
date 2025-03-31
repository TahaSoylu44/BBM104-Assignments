import java.time.LocalDate;

/**
 * This abstract class is a super class for Books,Magazine and DVD.
 * Contains necessary variables and methods for items.
 * @author Taha Soylu
 */
public abstract class Items {
    //VARIABLES
    protected String ID;
    protected String title;
    protected String type;
    protected LocalDate borrowDate;
    protected String owner = null;
    protected int overDue;

    //CONSTRUCTOR
    /**
     * Constructs a new Item object with the given details.
     * @param Id        Item ID
     * @param title     Item title
     * @param type      Item type
     */
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

    //I need a date converter to use LocalDate.I need my date in this form "Y-M-D"
    /**
     * Returns String date to LocalDate String.
     * Example: 03/05/2025 -> 2025-05-03
     * @param date  String date
     * @return year-month-day
     */
    public static String StringToLocalDate(String date) {
        String[] dateInfo = date.split("/");
        String day = dateInfo[0];
        String month = dateInfo[1];
        String year = dateInfo[2];
        return year + "-" + month + "-" + day;
    }

    //I need a date converter to implement the "borrow date" to "output.txt".To do that,I need the String one.
    /**
     * Returns LocalDate to String date.Vice versa of "StringToLocalDate" method.
     * Example: 2025-05-03 -> 03/05/2025
     * @param localDate   LocalDate date
     * @return  day/month/year
     */
    public static String LocalDateToString(LocalDate localDate) {
        String dateString = localDate.toString();
        String[] dateInfo = dateString.split("-");
        String day = dateInfo[2];
        String month = dateInfo[1];
        String year = dateInfo[0];
        return day + "/" + month + "/" + year;
    }

    //I utilized a method which prints the common parts of displayItems."Do not Repeat Yourself."
    /**
     * Prints the common parts of displaying items.
     * Provides "Do Not Repeat Yourself" principle.
     * @param item  the item which will be printed.
     */
    public static void printItem(Items item){
        System.out.print("\n------ ");
        System.out.print("Item Information for " + item.getID());
        System.out.print(" ------");
        System.out.print("\nID: " + item.getID());
        System.out.print(" Name: " + item.getTitle());

        if(item.getOwner() != null) {
            System.out.print(" Status: Borrowed");
            System.out.print(" Borrowed Date: " + Items.LocalDateToString(item.getBorrowDate()));
            System.out.print(" Borrowed by: " + item.getOwner() + "\n");
        }
        else {
            System.out.print(" Status: Available" + "\n");
        }
    }

    //displaying Items
    /**
     * displays items information.
     * Iterates through all Books, Magazines, and DVDs to display their details.
     * Uses the printItem method for common fields and adds type-specific information.
     */
    public static void displayItems() {
        if (!Books.getMyBooks().isEmpty()) {
            for (Books book : Books.getMyBooks()) {
                printItem(book);
                System.out.print("Author: " + book.getAuthor());
                System.out.print(" Genre: " + book.getCategory());
                System.out.println();
            }
        }
        if (!Magazine.getMyMagazine().isEmpty()) {
            for (Magazine magazine : Magazine.getMyMagazine()) {
                printItem(magazine);
                System.out.print("Publisher: " + magazine.getPublisher());
                System.out.print(" Category: " + magazine.getCategory());
                System.out.println();
            }
        }
        if (!DVD.getMyDVDs().isEmpty()) {
            for (DVD dvd : DVD.getMyDVDs()) {
                printItem(dvd);
                System.out.print("Director: " + dvd.getDirector());
                System.out.print(" Category: " + dvd.getCategory());
                System.out.print(" Runtime: " + dvd.getRunTime());
                System.out.println();
            }
        }
    }
}