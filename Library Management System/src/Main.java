import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Main {
    public static Main mainObj = new Main(); //I needed a main object to reach the hashmaps.

    public ArrayList<Student> myStudents = new ArrayList<>();       //It should keep the datas about the students.
    public ArrayList<Academic> myAcademic = new ArrayList<>();//It should keep the datas about the academic members.
    public ArrayList<Guest> myGuests = new ArrayList<>();          //It should keep the datas about the guests.

    public ArrayList<Books> myBooks = new ArrayList<>();       //It should keep the datas about the books.
    public ArrayList<Magazine> myMagazines = new ArrayList<>();//It should keep the datas about the magazines.
    public ArrayList<DVD> myDVDs = new ArrayList<>();          //It should keep the datas about the DVDs.

    private final HashMap<String, Object> mapBook = new HashMap<>();
    private final HashMap<String, Object> mapMagazine = new HashMap<>();
    private final HashMap<String, Object> mapDVD = new HashMap<>();       //I will use the "HashMap" to deal with datas."ID" is my key and objects are my values.
    private final HashMap<String, Object> mapStudent = new HashMap<>();
    private final HashMap<String, Object> mapAcademic = new HashMap<>();
    private final HashMap<String, Object> mapGuest = new HashMap<>();

    //Getter for hashmaps
    public HashMap<String, Object> getMapBook() {return mapBook;}
    public HashMap<String, Object> getMapMagazine() {return mapMagazine;}
    public HashMap<String, Object> getMapDVD() {return mapDVD;}
    public HashMap<String, Object> getMapStudent() {return mapStudent;}
    public HashMap<String, Object> getMapAcademic() {return mapAcademic;}
    public HashMap<String, Object> getMapGuest() {return mapGuest;}

    // Function to read a text file
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

    public static void main(String[] args) throws IOException {
        //OUTPUT
        String myOutput = args[3];
        PrintStream fileOut = new PrintStream(Files.newOutputStream(Paths.get(myOutput)), true, "UTF-8");
        System.setOut(fileOut);

        //ITEMS
        String itemsTXT = args[0];
        ArrayList<String[]> itemsData = readTxtAsObject(itemsTXT);  //Keeps the "items.txt"

        for (int i = 0; i < itemsData.size(); i++) {
            String[] itemInfo = itemsData.get(i);

            switch (itemInfo[0]) {
                case "B":
                    Books book = new Books(itemInfo[1], itemInfo[2], itemInfo[3], itemInfo[4], itemInfo[5]);
                    mainObj.myBooks.add(book);
                    break;
                case "M":
                    Magazine magazine = new Magazine(itemInfo[1], itemInfo[2], itemInfo[3], itemInfo[4], itemInfo[5]);
                    mainObj.myMagazines.add(magazine);
                    break;
                case "D":
                    DVD dvd = new DVD(itemInfo[1], itemInfo[2], itemInfo[3], itemInfo[4], itemInfo[5], itemInfo[6]);
                    mainObj.myDVDs.add(dvd);
                    break;
                default:
                    System.out.println("Unknown item detected!");
                    break;
            }
        }

        //USERS
        String usersTXT = args[1];
        ArrayList<String[]> usersData = readTxtAsObject(usersTXT);  //Keeps the "users.txt"

        for (int i = 0; i < usersData.size(); i++) {
            String[] usersInfo = usersData.get(i);

            switch (usersInfo[0]) {
                case "S":
                    Student student = new Student(usersInfo[1], usersInfo[2], usersInfo[3], usersInfo[4], usersInfo[5], usersInfo[6]);
                    mainObj.myStudents.add(student);
                    break;
                case "A":
                    Academic academic = new Academic(usersInfo[1], usersInfo[2], usersInfo[3], usersInfo[4], usersInfo[5], usersInfo[6]);
                    mainObj.myAcademic.add(academic);
                    break;
                case "G":
                    Guest guest = new Guest(usersInfo[1], usersInfo[2], usersInfo[3], usersInfo[4]);
                    mainObj.myGuests.add(guest);
                    break;
                default:
                    System.out.println("Unknown user detected!");
                    break;
            }
        }

        //////In here,I used the hashmap since I could not reach the object I want while it is in a ArrayList.//////
        //When I put my objects into a hashmap,I reach them whenever I want "O(1) complexity".That's why,I used it./

        for (Books book : mainObj.myBooks) {mainObj.getMapBook().put(book.ID, book);}
        for (Magazine magazine : mainObj.myMagazines) {mainObj.getMapMagazine().put(magazine.ID, magazine);}
        for (DVD dvd : mainObj.myDVDs) {mainObj.getMapDVD().put(dvd.ID, dvd);}
        for (Student student : mainObj.myStudents) {mainObj.getMapStudent().put(student.ID, student);}
        for (Academic academic : mainObj.myAcademic) {mainObj.getMapAcademic().put(academic.ID, academic);}
        for (Guest guest : mainObj.myGuests) {mainObj.getMapGuest().put(guest.ID, guest);}

        //COMMANDS
        String commandsTXT = args[2];
        ArrayList<String[]> commandInfo = readTxtAsObject(commandsTXT);  //Keeps the "commands.txt"

        for (String[] command : commandInfo) {
            switch (command[0]) {   //CommandName
                case "borrow":
                    borrow(command[1], command[2], command[3]);
                    break;
                case "return":
                    returning(command[1], command[2]);
                    break;
                case "pay":
                    pay(command[1]);
                    break;
                case "displayUsers":
                    System.out.println();
                    displayUsers();
                    System.out.println();
                    break;
                case "displayItems":
                    displayItems();
                    break;
                default:
                    System.out.println("Unknown command");
                    break;
            }
        }
    }


    public static void borrow(String userID, String itemID, String date) {  //It is my borrow method.
        LocalDate borrowDate = LocalDate.parse(StringToLocalDate(date));    //I used LocalDate for date issues.
        Person myuser = null;
        Items myitem = null;
        String[] notBorrow = new String[2];  //There are some items which cannot be borrowed.

        switch (userID.charAt(0)) {   //I need to know which user is this.
            case '1':
                myuser = (Person) mainObj.getMapStudent().get(userID);
                notBorrow[0] = "reference";
                break;
            case '2':
                myuser = (Person) mainObj.getMapAcademic().get(userID);
                break;
            case '3':
                myuser = (Person) mainObj.getMapGuest().get(userID);
                notBorrow[0] = "rare";
                notBorrow[1] = "limited";
                break;
            default:
                System.out.println("Unknown user detected!");
                break;
        }

        switch (itemID.charAt(0)) {     //I need to know what item is this.
            case '1':
                myitem = (Items) mainObj.getMapBook().get(itemID);
                break;
            case '2':
                myitem = (Items) mainObj.getMapMagazine().get(itemID);
                break;
            case '3':
                myitem = (Items) mainObj.getMapDVD().get(itemID);
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
                    item.setBorrowDate(null);
                }
            }
        }

        if (!beDeleted.isEmpty()) {  //Is there any item which will be returned?
            for (Items item : beDeleted) {          //The items are returned and they left the borrowed list.
                myuser.setBorrowedItemsRemove(item);
            }
        }
        //The item might have been borrowed.Need to check if it should be returned.
        assert myitem != null;
        if(myitem.getOwner() != null) {
            long isAvailable = ChronoUnit.DAYS.between(myitem.getBorrowDate(), LocalDate.now()) + 1;

            if(isAvailable > myitem.getOverDue()) {
                boolean isFound = false;            //Time to find the person who borrowed the item.He or she gets penalty.
                for(Student student : mainObj.myStudents) {
                    if(student.getName().equals(myitem.getOwner())) {
                        student.setPenaltyPlus();
                        isFound = true;
                        break;
                    }
                }
                if(!isFound) {
                    for(Academic academic : mainObj.myAcademic) {
                        if(academic.getName().equals(myitem.getOwner())) {
                            academic.setPenaltyPlus();
                            isFound = true;
                            break;
                        }
                    }
                }
                if(!isFound) {
                    for(Guest guest : mainObj.myGuests) {
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
                    else{    //this item does not have an owner,we can borrow it.
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

    //I need a date converter to use LocalDate.I need my date in this form "Y-M-D"
    public static String StringToLocalDate(String date) {
        String[] dateInfo = date.split("/");
        String day = dateInfo[0];
        String month = dateInfo[1];
        String year = dateInfo[2];
        return year + "-" + month + "-" + day;
    }

    //I need a date converter to implement the "borrow date" to "output.txt".To do that,I need the String one.
    public static String LocalDateToString(LocalDate localDate) {
        String dateString = localDate.toString();
        String[] dateInfo = dateString.split("-");
        String day = dateInfo[2];
        String month = dateInfo[1];
        String year = dateInfo[0];
        return day + "/" + month + "/" + year;
    }

    public static void returning(String userID, String itemID) {   //It is the method which provides returning actions.
        Person myuser = null;
        Items myitem = null;

        myuser = whichUser(userID, myuser);  //Thanks to this method,we know the user we deal with.
        switch (itemID.charAt(0)) {
            case '1':
                myitem = (Items) mainObj.getMapBook().get(itemID);
                break;
            case '2':
                myitem = (Items) mainObj.getMapMagazine().get(itemID);
                break;
            case '3':
                myitem = (Items) mainObj.getMapDVD().get(itemID);
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

    public static Person whichUser(String userID, Person myuser) {    //Which user are we dealing with?
        switch (userID.charAt(0)) {                                     //It returns a Person object in accordance with the ID.
            case '1':
                myuser = (Person) mainObj.getMapStudent().get(userID);
                break;
            case '2':
                myuser = (Person) mainObj.getMapAcademic().get(userID);
                break;
            case '3':
                myuser = (Person) mainObj.getMapGuest().get(userID);
                break;
            default:
                System.out.println("Unknown user detected!");
                break;
        }
        return myuser;
    }

    //Paying penalty
    public static void pay(String userID) {
        Person myuser = null;

        myuser = whichUser(userID, myuser);

        assert myuser != null;
        myuser.setPenaltyPaid();

        System.out.println(myuser.getName() + " has paid penalty");
    }

    //displaying Users
    public static void displayUsers() {
        if (!mainObj.myStudents.isEmpty()) {
            for (Student user : mainObj.myStudents) {
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
        if (!mainObj.myAcademic.isEmpty()) {
            for (Academic user : mainObj.myAcademic) {
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
        if (!mainObj.myGuests.isEmpty()) {
            for (Guest user : mainObj.myGuests) {
                printUser(user);
                System.out.print("\nOccupation: " + user.getOccupation());
                if(user.getPenalty() != 0){
                    System.out.print("\nPenalty: " + user.getPenalty() + "$");
                }
                System.out.println();
            }
        }
    }

    //I utilized a method which prints the common parts of displayUsers."Do not Repeat Yourself."
    public static void printUser(Person user){
        System.out.print("\n------ ");
        System.out.print("User Information for " + user.getID());
        System.out.print(" ------");
        System.out.print("\nName: " + user.getName());
        System.out.print(" Phone: " + user.getPhone());
    }

    //I utilized a method which prints the common parts of displayItems."Do not Repeat Yourself."

    public static void printItem(Items item){
        System.out.print("\n------ ");
        System.out.print("Item Information for " + item.getID());
        System.out.print(" ------");
        System.out.print("\nID: " + item.getID());
        System.out.print(" Name: " + item.getTitle());

        if(item.getOwner() != null) {
            System.out.print(" Status: Borrowed");
            System.out.print(" Borrowed Date: " + LocalDateToString(item.getBorrowDate()));
            System.out.print(" Borrowed by: " + item.getOwner() + "\n");
        }
        else {
            System.out.print(" Status: Available" + "\n");
        }
    }

    //displaying Items
    public static void displayItems() {
        if (!mainObj.myBooks.isEmpty()) {
            for (Books book : mainObj.myBooks) {
                printItem(book);
                System.out.print("Author: " + book.getAuthor());
                System.out.print(" Genre: " + book.getCategory());
                System.out.println();
            }
        }
        if (!mainObj.myMagazines.isEmpty()) {
            for (Magazine magazine : mainObj.myMagazines) {
                printItem(magazine);
                System.out.print("Publisher: " + magazine.getPublisher());
                System.out.print(" Category: " + magazine.getCategory());
                System.out.println();
            }
        }
        if (!mainObj.myDVDs.isEmpty()) {
            for (DVD dvd : mainObj.myDVDs) {
                printItem(dvd);
                System.out.print("Director: " + dvd.getDirector());
                System.out.print(" Category: " + dvd.getCategory());
                System.out.print(" Runtime: " + dvd.getRunTime());
                System.out.println();
            }
        }
    }
}