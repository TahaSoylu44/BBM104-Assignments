import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Main {
    public static Main mainObj = new Main(); //I needed a main object to reach the hashmaps.

    public ArrayList<Student> mystudents = new ArrayList<>();       //It should keep the datas about the students.
    public ArrayList<Academic> myacademic = new ArrayList<>();//It should keep the datas about the academic members.
    public ArrayList<Guest> myguests = new ArrayList<>();          //It should keep the datas about the guests.

    public ArrayList<Books> mybooks = new ArrayList<>();       //It should keep the datas about the books.
    public ArrayList<Magazine> mymagazines = new ArrayList<>();//It should keep the datas about the magazines.
    public ArrayList<DVD> myDVDs = new ArrayList<>();          //It should keep the datas about the DVDs.

    private HashMap<String, Object> mapBook = new HashMap<>();
    private HashMap<String, Object> mapMagazine = new HashMap<>();
    private HashMap<String, Object> mapDVD = new HashMap<>();
    private HashMap<String, Object> mapStudent = new HashMap<>();
    private HashMap<String, Object> mapAcademic = new HashMap<>();
    private HashMap<String, Object> mapGuest = new HashMap<>();

    //Getter for hashmaps
    public HashMap<String, Object> getMapBook() {
        return mapBook;
    }

    public HashMap<String, Object> getMapMagazine() {
        return mapMagazine;
    }

    public HashMap<String, Object> getMapDVD() {
        return mapDVD;
    }

    public HashMap<String, Object> getMapStudent() {
        return mapStudent;
    }

    public HashMap<String, Object> getMapAcademic() {
        return mapAcademic;
    }

    public HashMap<String, Object> getMapGuest() {
        return mapGuest;
    }

    //Setter for hashmaps
    public void setMapBook(HashMap<String, Object> mapBook) {
        this.mapBook = mapBook;
    }

    public void setMapMagazine(HashMap<String, Object> mapMagazine) {
        this.mapMagazine = mapMagazine;
    }

    public void setMapDVD(HashMap<String, Object> mapDVD) {
        this.mapDVD = mapDVD;
    }

    public void setMapStudent(HashMap<String, Object> mapStudent) {
        this.mapStudent = mapStudent;
    }

    public void setMapAcademic(HashMap<String, Object> mapAcademic) {
        this.mapAcademic = mapAcademic;
    }

    public void setMapGuest(HashMap<String, Object> mapGuest) {
        this.mapGuest = mapGuest;
    }

    // Function to read a text file
    public static ArrayList<String[]> readTxtAsObject(String input) {
        ArrayList<String[]> data = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(input))) {
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

    public static void main(String[] args) {
        //ITEMS
        //String itemsTXT = args[0];
        ArrayList<String[]> itemsData = readTxtAsObject("items.txt");  //Keeps the "items.txt"

        for (int i = 0; i < itemsData.size(); i++) {
            String[] itemInfo = itemsData.get(i);

            switch (itemInfo[0]) {
                case "B":
                    Books book = new Books(itemInfo[1], itemInfo[2], itemInfo[3], itemInfo[4], itemInfo[5]);
                    mainObj.mybooks.add(book);
                    break;
                case "M":
                    Magazine magazine = new Magazine(itemInfo[1], itemInfo[2], itemInfo[3], itemInfo[4], itemInfo[5]);
                    mainObj.mymagazines.add(magazine);
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
        //String usersTXT = args[1];
        ArrayList<String[]> usersData = readTxtAsObject("users.txt");  //Keeps the "users.txt"

        for (int i = 0; i < usersData.size(); i++) {
            String[] usersInfo = usersData.get(i);

            switch (usersInfo[0]) {
                case "S":
                    Student student = new Student(usersInfo[1], usersInfo[2], usersInfo[3], usersInfo[4], usersInfo[5], usersInfo[6]);
                    mainObj.mystudents.add(student);
                    break;
                case "A":
                    Academic academic = new Academic(usersInfo[1], usersInfo[2], usersInfo[3], usersInfo[4], usersInfo[5], usersInfo[6]);
                    mainObj.myacademic.add(academic);
                    break;
                case "G":
                    Guest guest = new Guest(usersInfo[1], usersInfo[2], usersInfo[3], usersInfo[4]);
                    mainObj.myguests.add(guest);
                    break;
                default:
                    System.out.println("Unknown user detected!");
                    break;
            }
        }

        //////In here,I used the hashmap since I could not reach the object I want while it is in a ArrayList.//////
        //When I put my objects into a hashmap,I reach them whenever I want "O(1) complexity".That's why,I used it./

        for (Books book : mainObj.mybooks) {mainObj.getMapBook().put(book.ID, book);}
        for (Magazine magazine : mainObj.mymagazines) {mainObj.getMapMagazine().put(magazine.ID, magazine);}
        for (DVD dvd : mainObj.myDVDs) {mainObj.getMapDVD().put(dvd.ID, dvd);}
        for (Student student : mainObj.mystudents) {mainObj.getMapStudent().put(student.ID, student);}
        for (Academic academic : mainObj.myacademic) {mainObj.getMapAcademic().put(academic.ID, academic);}
        for (Guest guest : mainObj.myguests) {mainObj.getMapGuest().put(guest.ID, guest);}

        //COMMANDS
        //String commandsTXT = args[2];
        ArrayList<String[]> commandInfo = readTxtAsObject("commands7.txt");  //Keeps the "commands.txt"
        /*   //Is Hashmap correct?
        System.out.println("*************************");
        System.out.println(mainObj.getMapBook());
        System.out.println("*************************");
        System.out.println(mainObj.getMapMagazine());
        System.out.println("*************************");
        System.out.println(mainObj.getMapDVD());
        System.out.println("*************************");
        System.out.println(mainObj.getMapStudent());
        System.out.println("*************************");
        System.out.println(mainObj.getMapAcademic());
        System.out.println("*************************");
        System.out.println(mainObj.getMapGuest());
        System.out.println("*************************");
        */

        /*
        //What is the command?
        for (String[] command : commandInfo) {
            String commandName = command[0];
            if (commandName.equals("borrow")) {
                System.out.println(command[1] + " borrows " + command[2] + " on " + command[3]);
            } else if (commandName.equals("return")) {
                System.out.println(command[1] + " returns " + command[2]);
            } else if (commandName.equals("pay")) {
                System.out.println(command[1] + " pays his/her penalty.");
            } else if (commandName.equals("displayUsers")) {
                System.out.println("displaying users...");
            } else if (commandName.equals("displayItems")) {
                System.out.println("displaying items...");
            } else {
                System.out.println("Unknown command");
            }
        }
         */


        /* //Items and users are correct?
        System.out.println("############ITEMS####################");
        for (Books book : mybooks) {
            System.out.println(book.getID() + " " + book.getTitle() + " " + book.getAuthor() + " " + book.getCategory() + " " + book.getType());
        }
        System.out.println("*************************************");
        for (Magazine magazine : mymagazines) {
            System.out.println(magazine.getID() + " " + magazine.getTitle() + " " + magazine.getPublisher() + " " + magazine.getCategory() + " " + magazine.getType());
        }
        System.out.println("*************************************");
        for (DVD dvd : myDVDs) {
            System.out.println(dvd.getID() + " " + dvd.getTitle() + " " + dvd.getDirector() + " " + dvd.getCategory() + " " + dvd.getType());
        }

        System.out.println("################USERS################");
        System.out.println("*************************************");
        for (Student student : mystudents) {
            System.out.println(student.getID() + " " + student.getName() + " " + student.getPhone() + " " + student.getFaculty() + " " + student.getDepartment() + " " + student.getGrade());
        }
        System.out.println("*************************************");
        for (Academic academic : myacademic) {
            System.out.println(academic.getID() + " " + academic.getName() + " " + academic.getPhone() + " " + academic.getFaculty() + " " + academic.getDepartment() + " " + academic.getTitle());
        }
        System.out.println("*************************************");
        for (Guest guest : myguests) {
            System.out.println(guest.getID() + " " + guest.getName() + " " + guest.getPhone() + " " + guest.getOccupation());
        }
        System.out.println("*************************************");
         */

        /*
        Books anybook;
        anybook = (Books) mainObj.getMapBook().get("1001");

        Student anystudent;
        anystudent = (Student) mainObj.getMapStudent().get("1001");

        borrow("1001","1001","10/03/2025");
        System.out.println(anystudent.getBorrowedItems());
        System.out.println(anybook.getOwner());
        System.out.println(anybook.getBorrowDate());

         */

        displayItems();
    }

    public static void borrow(String userID, String itemID, String date) {  //It is my borrow method.
        LocalDate borrowDate = LocalDate.parse(dateConverter(date));    //I used LocalDate for date issues.
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
        assert myitem != null;
        myitem.setBorrowDate(borrowDate);

        assert myuser != null;

        //Calculating Penalty
        ArrayList<Items> MyBorrowedItemList = myuser.getBorrowedItems();
        ArrayList<Items> beDeleted = new ArrayList<>(); //I will delete them because,if dueDate is reached,the item will be returned.

        for (int i = 0; i < MyBorrowedItemList.size(); i++) {
            if (MyBorrowedItemList.get(i) != null) {
                Items item = MyBorrowedItemList.get(i);
                long betweenDays = ChronoUnit.DAYS.between(MyBorrowedItemList.get(i).getBorrowDate(), borrowDate);

                if (betweenDays > myuser.getMaxItem()) {
                    beDeleted.add(item);
                    myuser.setPenaltyPlus();
                    item.setOwner(null);
                    item.setBorrowDate(null);
                    System.out.println("MyBorrowedList " + MyBorrowedItemList);
                }
            }
        }

        for (Items item : beDeleted) {          //The items are returned and they left the borrowed list.
            MyBorrowedItemList.remove(item);
        }

        if (myuser.getPenalty() < 6) {  //If you have a penalty,you cannot borrow anything.
            if (myuser.getBorrowedItems().size() < myuser.getMaxItem()) {    //There is a limit for borrowing.
                if (myitem.getType().equals(notBorrow[0])) { //This person cannot borrow this item due to its rarity.
                    System.out.println(myuser.getName() + " cannot borrow " + notBorrow[0] + " item!");
                } else if (myitem.getType().equals(notBorrow[1])) {   //This person cannot borrow this item due to its rarity.
                    System.out.println(myuser.getName() + " cannot borrow " + notBorrow[1] + " item!");
                } else {
                    System.out.println(myuser.getName() + " successfully borrowed! " + myitem.getTitle());
                    myuser.setBorrowedItemsAdd(myitem);
                    myitem.setOwner(myuser.getName());
                    myitem.setBorrowDate(borrowDate);
                }
            } else {
                System.out.println(myuser.getName() + " cannot borrow the " + myitem.getTitle() + ", since the borrow limit has been reached!");
            }
        } else {
            System.out.println(myuser.getName() + " cannot borrow " + myitem.getTitle() + ", you must first pay the penalty amount! " + myuser.getPenalty() + "$");
        }
    }

    //I need a date converter to use LocalDate.I need my date in this form "Y-M-D"
    public static String dateConverter(String date) {
        String[] dateInfo = date.split("/");
        String day = dateInfo[0];
        String month = dateInfo[1];
        String year = dateInfo[2];
        return year + "-" + month + "-" + day;
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

    public static void pay(String userID) { //Paying penalty
        Person myuser = null;

        myuser = whichUser(userID, myuser);

        assert myuser != null;
        myuser.setPenaltyPaid();

        System.out.println(myuser.getName() + " has paid penalty.");
    }

    public static void displayUsers() {
        if (!mainObj.mystudents.isEmpty()) {
            for (Student user : mainObj.mystudents) {
                printUser(user);
                System.out.print("\nFaculty: " + user.getFaculty());
                System.out.print(" Department: " + user.getDepartment());
                System.out.print(" Grade: " + user.getGrade() + "th" + "\n");
                System.out.println();
            }
        }
        if (!mainObj.myacademic.isEmpty()) {
            for (Academic user : mainObj.myacademic) {
                printUser(user);
                System.out.print("\nFaculty: " + user.getFaculty());
                System.out.print(" Department: " + user.getDepartment() + "\n");
                System.out.println();
            }
        }
        if (!mainObj.myguests.isEmpty()) {
            for (Guest user : mainObj.myguests) {
                printUser(user);
                System.out.print("\nOccupation :" + user.getOccupation() + "\n");
                System.out.println();
            }
        }
    }

    public static void printUser(Person user){
        System.out.print("------ ");
        System.out.print("User Information for " + user.getID());
        System.out.print(" ------ ");
        System.out.print("\nName: " + user.getName());
        System.out.print(" Phone: " + user.getPhone());
    }

    public static void printItem(Items item){
        System.out.print("------ ");
        System.out.print("Item Information for " + item.getID());
        System.out.print(" ------ ");
        System.out.print("\nID: " + item.getID());
        System.out.print(" Name: " + item.getTitle());

        if(item.getOwner() != null) {
            System.out.print(" Status: Borrowed");
        }
        else {
            System.out.print(" Status: Available");
        }
    }

    public static void displayItems() {
        if (!mainObj.mybooks.isEmpty()) {
            for (Books book : mainObj.mybooks) {
                printItem(book);
                System.out.print("Author: " + book.getAuthor());
                System.out.print(" Genre: " + book.getCategory() + "\n");
                System.out.println();
            }
        }
        if (!mainObj.mymagazines.isEmpty()) {
            for (Magazine magazine : mainObj.mymagazines) {
                printItem(magazine);
                System.out.print("\nPublisher: " + magazine.getPublisher());
                System.out.print(" Category: " + magazine.getCategory() + "\n");
                System.out.println();
            }
        }
        if (!mainObj.myDVDs.isEmpty()) {
            for (DVD dvd : mainObj.myDVDs) {
                printItem(dvd);
                System.out.print("\nDirector: " + dvd.getDirector());
                System.out.print(" Category: " + dvd.getCategory());
                System.out.print(" Runtime: " + dvd.getRunTime() + "\n");
                System.out.println();
            }
        }
    }
}




