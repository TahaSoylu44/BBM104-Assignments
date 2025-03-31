import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * This class is "Main" class of my project.
 * It reads input files and writes output file.
 * Contains general methods like reading input files,writing output files and borrowing operations.
 * The program should be run with these parameters:
 * args[0]: The file which contains items (items.txt)
 * args[1]: The file which contains users (users.txt)
 * args[2]: The file which contains commands (commands.txt)
 * args[3]: The output file
 * @author Taha Soylu
 */
public class Main {
    // Function to read a text file
    /**
     * Reads the input files line by line and returns an ArrayList which includes the lines.
     * @param input        Takes my arguments as String input.
     * @return             Returns ArrayList which includes the lines as String list seperated by comma.
     *                     Example: ["B","1001","The Great Gatsby","F. Scott Fitzgerald","Classic Fiction","normal"]
     */
    public static ArrayList<String[]> readTxtAsObject(String input) {
        ArrayList<String[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(Files.newInputStream(Paths.get(input)), StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(","); // Split the line by comma
                data.add(parts);
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
        return data;
    }

    /**
     * The main method which reads the files,executes the commands.
     * @param args         Arguments written in terminal
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        //OUTPUT
        String myOutput = args[3];
        PrintStream fileOut = new PrintStream(Files.newOutputStream(Paths.get(myOutput)), true, "UTF-8");
        System.setOut(fileOut);  //Do not write to the terminal,write to file.

        //ITEMS
        String itemsTXT = args[0];
        ArrayList<String[]> itemsData = readTxtAsObject(itemsTXT);  //Keeps the "items.txt"

        //Determining which item is this.
        for (int i = 0; i < itemsData.size(); i++) {
            String[] itemInfo = itemsData.get(i);

            //Determined in accordance with first letters.
            switch (itemInfo[0]) {
                case "B":
                    Books book = new Books(itemInfo[1], itemInfo[2], itemInfo[3], itemInfo[4], itemInfo[5]);
                    Books.setMyBooks(book);
                    break;
                case "M":
                    Magazine magazine = new Magazine(itemInfo[1], itemInfo[2], itemInfo[3], itemInfo[4], itemInfo[5]);
                    Magazine.setMyMagazine(magazine);
                    break;
                case "D":
                    DVD dvd = new DVD(itemInfo[1], itemInfo[2], itemInfo[3], itemInfo[4], itemInfo[5], itemInfo[6]);
                    DVD.setMyDVDs(dvd);
                    break;
                default:
                    System.out.println("Unknown item detected!");
                    break;
            }
        }

        //USERS
        String usersTXT = args[1];
        ArrayList<String[]> usersData = readTxtAsObject(usersTXT);  //Keeps the "users.txt"

        //Determining which user is this.
        for (int i = 0; i < usersData.size(); i++) {
            String[] usersInfo = usersData.get(i);

            //Determined in accordance with first letters.
            switch (usersInfo[0]) {
                case "S":
                    Student student = new Student(usersInfo[1], usersInfo[2], usersInfo[3], usersInfo[4], usersInfo[5], usersInfo[6]);
                    Student.setMyStudents(student);

                    break;
                case "A":
                    Academic academic = new Academic(usersInfo[1], usersInfo[2], usersInfo[3], usersInfo[4], usersInfo[5], usersInfo[6]);
                    Academic.setMyAcademic(academic);
                    break;
                case "G":
                    Guest guest = new Guest(usersInfo[1], usersInfo[2], usersInfo[3], usersInfo[4]);
                    Guest.setMyGuest(guest);
                    break;
                default:
                    System.out.println("Unknown user detected!");
                    break;
            }
        }

        /**
        *In here,I used the hashmap since I could not reach the object I want while it is in a ArrayList.
        *When I put my objects into a hashmap,I reach them whenever I want "O(1) complexity".That's why,I used it.
        *I created my HashMaps as (key: String (ID),value: Object(Person/Items))
        */
        //for items
        for (Books book : Books.getMyBooks()) {Books.setMapBooks(book.ID, book);}
        for (Magazine magazine : Magazine.getMyMagazine()) {Magazine.setMapMagazine(magazine.ID, magazine);}
        for (DVD dvd : DVD.getMyDVDs()) {DVD.setMapDVDs(dvd.ID, dvd);}
        //for users
        for (Student student : Student.getMyStudents()) {Student.setMapStudent(student.ID, student);}
        for (Academic academic : Academic.getMyAcademic()) {Academic.setMapAcademic(academic.ID, academic);}
        for (Guest guest : Guest.getMyGuest()) {Guest.setMapGuest(guest.ID, guest);}

        //COMMANDS
        String commandsTXT = args[2];
        ArrayList<String[]> commandInfo = readTxtAsObject(commandsTXT);  //Keeps the "commands.txt"

        for (String[] command : commandInfo) {
            switch (command[0]) {   //CommandName
                case "borrow":
                    borrow(command[1], command[2], command[3]);
                    break;
                case "return":
                    Person.returning(command[1], command[2]);
                    break;
                case "pay":
                    Person.pay(command[1]);
                    break;
                case "displayUsers":
                    System.out.println();
                    Person.displayUsers();
                    System.out.println();
                    break;
                case "displayItems":
                    Items.displayItems();
                    break;
                default:
                    System.out.println("Unknown command");
                    break;
            }
        }
    }

    /**
     * Borrow method manages borrowing operations.
     * When the program reads "borrow" from command text,calls this method and determine if borrow operation is successful or not.
     * 1.Detect users and items based on their IDs.
     * 2.User has to pay the penalty?
     * 3.The limit exceeded or not
     * 4.Can user borrow this item in accordance with item rarity.
     * 5.Item already has an owner or doesn't?
     * 6.If all are OK,borrow it!
     * @param userID     The user who wants to borrow an item
     * @param itemID     Wanted item
     * @param date       Operation date
     */
    public static void borrow(String userID, String itemID, String date) {
        LocalDate borrowDate = LocalDate.parse(Items.StringToLocalDate(date));    //I used LocalDate for date issues.
        Person myuser = null;
        Items myitem = null;
        String[] notBorrow = new String[2];  //There are some items which cannot be borrowed.

        switch (userID.charAt(0)) {   //I need to know which user is this.
            case '1':
                myuser = (Person) Student.getMapStudent().get(userID);
                notBorrow[0] = "reference";
                break;
            case '2':
                myuser = (Person) Academic.getMapAcademic().get(userID);
                break;
            case '3':
                myuser = (Person) Guest.getMapGuest().get(userID);
                notBorrow[0] = "rare";
                notBorrow[1] = "limited";
                break;
            default:
                System.out.println("Unknown user detected!");
                break;
        }

        switch (itemID.charAt(0)) {     //I need to know what item is this.
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
                break;
        }

        assert myuser != null;

        //Calculating Penalty
        ArrayList<Items> MyBorrowedItemList = myuser.getBorrowedItems();
        ArrayList<Items> beDeleted = new ArrayList<>(); //I will delete them because,if dueDate is reached,the item will be returned.
        for (int i = 0; i < MyBorrowedItemList.size(); i++) {
            if (MyBorrowedItemList.get(i) != null) {
                Items item = MyBorrowedItemList.get(i);
                long betweenDays = ChronoUnit.DAYS.between(MyBorrowedItemList.get(i).getBorrowDate(), LocalDate.now()) + 1;

                if (betweenDays > myuser.getOverDue()) {
                    beDeleted.add(item);
                    myuser.setPenaltyPlus();   //Penalty +2$
                    item.setOwner(null);       //Returned
                    item.setBorrowDate(null);  //Returned
                }
            }
        }

        if (!beDeleted.isEmpty()) {  //Is there any item which will be returned?
            for (Items item : beDeleted) {          //The items are returned, and they left the borrowed list.
                myuser.setBorrowedItemsRemove(item);
            }
        }
        //The item might have been borrowed.Need to check if it should be returned.
        assert myitem != null;
        if(myitem.getOwner() != null) {
            long isAvailable = ChronoUnit.DAYS.between(myitem.getBorrowDate(), LocalDate.now()) + 1;

            if(isAvailable > myitem.getOverDue()) {
                boolean isFound = false;            //Time to find the person who borrowed the item.He or she gets penalty.
                for(Student student : Student.getMyStudents()) {
                    if(student.getName().equals(myitem.getOwner())) {
                        student.setPenaltyPlus();
                        isFound = true;
                        break;
                    }
                }
                if(!isFound) {
                    for(Academic academic : Academic.getMyAcademic()) {
                        if(academic.getName().equals(myitem.getOwner())) {
                            academic.setPenaltyPlus();
                            isFound = true;
                            break;
                        }
                    }
                }
                if(!isFound) {
                    for(Guest guest : Guest.getMyGuest()) {
                        if(guest.getName().equals(myitem.getOwner())) {
                            guest.setPenaltyPlus();
                            guest.setBorrowedItemsRemove(myitem);
                            isFound = true;
                            break;
                        }
                    }
                }
                myitem.setOwner(null);     //After penalty,this object does not have an owner.
            }
        }

        //Time to learn if borrowing operation is valid or not.Checked some conditions.
        if (myuser.getPenalty() < 6) {  //If you have a penalty,you cannot borrow anything.
            if (myuser.getBorrowedItems().size() < myuser.getMaxItem()) {    //There is a limit for borrowing.
                if (myitem.getType().equals(notBorrow[0])) { //This person cannot borrow this item due to its rarity.
                    System.out.println(myuser.getName() + " cannot borrow " + notBorrow[0] + " item!");
                } else if (myitem.getType().equals(notBorrow[1])) {   //This person cannot borrow this item due to its rarity.
                    System.out.println(myuser.getName() + " cannot borrow " + notBorrow[1] + " item!");
                } else {
                    if(myitem.getOwner() == null) {         //If an item had been borrowed,of course we cannot borrow it.
                        System.out.println(myuser.getName() + " successfully borrowed! " + myitem.getTitle());
                        myuser.setBorrowedItemsAdd(myitem);
                        myitem.setOwner(myuser.getName());
                        myitem.setBorrowDate(borrowDate);
                        myitem.setOverDue(myuser.getOverDue());
                    }
                    else{    //this item has an owner,we cannot borrow it.
                        System.out.println(myuser.getName() + " cannot borrow " + myitem.getTitle() + ", it is not available!");
                    }
                }
            } else {
                System.out.println(myuser.getName() + " cannot borrow " + myitem.getTitle() + ", since the borrow limit has been reached!");
            }
        } else {
            System.out.println(myuser.getName() + " cannot borrow " + myitem.getTitle() + ", you must first pay the penalty amount! " + myuser.getPenalty() + "$");
        }
    }
}