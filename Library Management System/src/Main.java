import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.time.LocalDate;

public class Main {
    public static Main mainObj = new Main(); //I needed a main object to reach the hashmaps.
    public static Person person;
    private HashMap<String, Object> mapBook = new HashMap<>();
    private HashMap<String, Object> mapMagazine = new HashMap<>();
    private HashMap<String, Object> mapDVD = new HashMap<>();
    private HashMap<String, Object> mapStudent = new HashMap<>();
    private HashMap<String, Object> mapAcademic = new HashMap<>();
    private HashMap<String, Object> mapGuest = new HashMap<>();

    //Getter for hashmaps
    public HashMap<String, Object> getMapBook() {return mapBook;}
    public HashMap<String, Object> getMapMagazine() {return mapMagazine;}
    public HashMap<String, Object> getMapDVD() {return mapDVD;}
    public HashMap<String, Object> getMapStudent() {return mapStudent;}
    public HashMap<String, Object> getMapAcademic() {return mapAcademic;}
    public HashMap<String, Object> getMapGuest() {return mapGuest;}

    //Setter for hashmaps
    public void setMapBook(HashMap<String, Object> mapBook) {this.mapBook = mapBook;}
    public void setMapMagazine(HashMap<String, Object> mapMagazine) {this.mapMagazine = mapMagazine;}
    public void setMapDVD(HashMap<String, Object> mapDVD) {this.mapDVD = mapDVD;}
    public void setMapStudent(HashMap<String, Object> mapStudent) {this.mapStudent = mapStudent;}
    public void setMapAcademic(HashMap<String, Object> mapAcademic) {this.mapAcademic = mapAcademic;}
    public void setMapGuest(HashMap<String, Object> mapGuest) {this.mapGuest = mapGuest;}

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
        ArrayList<String[]> itemsData = readTxtAsObject("items.txt");  //Keeps the "items.txt"
        ArrayList<Books> mybooks = new ArrayList<>();       //It should keep the datas about the books.
        ArrayList<Magazine> mymagazines = new ArrayList<>();//It should keep the datas about the magazines.
        ArrayList<DVD> myDVDs = new ArrayList<>();          //It should keep the datas about the DVDs.

        for(int i = 0; i < itemsData.size(); i++) {
            String[] itemInfo = itemsData.get(i);

            switch(itemInfo[0]){
                case "B":
                    Books book = new Books(itemInfo[1], itemInfo[2], itemInfo[3], itemInfo[4], itemInfo[5]);
                    mybooks.add(book);
                    break;
                case "M":
                    Magazine magazine = new Magazine(itemInfo[1], itemInfo[2], itemInfo[3], itemInfo[4], itemInfo[5]);
                    mymagazines.add(magazine);
                    break;
                case "D":
                    DVD dvd = new DVD(itemInfo[1], itemInfo[2], itemInfo[3], itemInfo[4], itemInfo[5], itemInfo[6]);
                    myDVDs.add(dvd);
                    break;
                default:
                    System.out.println("Unknown item detected!");
                    break;
        }
        }

        //USERS
        ArrayList<String[]> usersData = readTxtAsObject("users.txt");  //Keeps the "users.txt"
        ArrayList<Student> mystudents = new ArrayList<>();       //It should keep the datas about the students.
        ArrayList<Academic> myacademic = new ArrayList<>();//It should keep the datas about the academic members.
        ArrayList<Guest> myguests = new ArrayList<>();          //It should keep the datas about the guests.

        for(int i = 0; i < usersData.size(); i++) {
            String[] usersInfo = usersData.get(i);

            switch(usersInfo[0]){
                case "S":
                    Student student = new Student(usersInfo[1], usersInfo[2], usersInfo[3], usersInfo[4], usersInfo[5],usersInfo[6]);
                    mystudents.add(student);
                    break;
                case "A":
                    Academic academic = new Academic(usersInfo[1], usersInfo[2], usersInfo[3], usersInfo[4], usersInfo[5],usersInfo[6]);
                    myacademic.add(academic);
                    break;
                case "G":
                    Guest guest = new Guest(usersInfo[1], usersInfo[2], usersInfo[3], usersInfo[4]);
                    myguests.add(guest);
                    break;
                default:
                    System.out.println("Unknown user detected!");
                    break;
            }
        }

        //////In here,I used the hashmap since I could not reach the object I want while it is in a ArrayList.//////
        //When I put my objects into a hashmap,I reach them whenever I want "O(1) complexity".That's why,I used it./

        for(Books book : mybooks) {mainObj.getMapBook().put(book.ID, book);}
        for(Magazine magazine : mymagazines) {mainObj.getMapMagazine().put(magazine.ID, magazine);}
        for(DVD dvd : myDVDs) {mainObj.getMapDVD().put(dvd.ID, dvd);}
        for(Student student : mystudents) {mainObj.getMapStudent().put(student.ID, student);}
        for(Academic academic : myacademic) {mainObj.getMapAcademic().put(academic.ID, academic);}
        for(Guest guest : myguests) {mainObj.getMapGuest().put(guest.ID, guest);}

        //COMMANDS
        ArrayList<String[]> commandInfo = readTxtAsObject("commands.txt");  //Keeps the "commands.txt"
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

        /*  //What is the command?
        for (String[] command : commandInfo) {
            String commandName = command[0];
            if (commandName.equals("borrow")) {
                System.out.println(command[1] + " borrows " + command[2] + " on " + command[3]);
            }
            else if (commandName.equals("return")) {
                System.out.println(command[1] + " returns " + command[2]);
            }
            else if (commandName.equals("pay")) {
                System.out.println(command[1] + " pays his/her penalty.");
            }
            else if (commandName.equals("displayUsers")) {
                System.out.println("displaying users...");
            }
            else if (commandName.equals("displayItems")) {
                System.out.println("displaying items...");
            }
            else{
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


        borrow("3001","1001","09/02/2025");
        borrow("3001","1002","09/02/2025");
        borrow("3001","1003","09/02/2025");
        borrow("3001","1004","09/02/2025");
        borrow("3002","1003","12/03/2025");
        borrow("3001","1004","10/03/2025");
        borrow("3001","3005","13/03/2025");



    }



    public static void borrow(String userID, String itemID,String date) {  //It is my borrow method.
        LocalDate borrowDate = LocalDate.parse(dateConverter(date));    //I used LocalDate for date issues.
        Person myuser = null;
        Items myitem = null;
        String[] notBorrow = new String[2];  //There are some items which cannot be borrowed.

        switch(userID.charAt(0)){   //I need to know which user is this.
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

        switch(itemID.charAt(0)){     //I need to know what item is this.
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

        if(myuser.getPenalty() < 6){  //If your penalty is at least 6,you cannot borrow anything.
            if (myuser.getBorrowedItem() < myuser.getMaxItem()){    //There is a limit for borrowing.
                if(myitem.getType().equals(notBorrow[0])){ //This person cannot borrow this item due to its rarity.
                    System.out.println(myuser.getName() + " cannot borrow " + notBorrow[0] + " item!");
                }
                else if(myitem.getType().equals(notBorrow[1])){   //This person cannot borrow this item due to its rarity.
                    System.out.println(myuser.getName() + " cannot borrow " + notBorrow[1] + " item!");
                }
                else{
                    System.out.println(myuser.getName() + " successfully borrowed! " + myitem.getTitle());
                }
            }
            else{
                System.out.println(myuser.getName() + " cannot borrow the " + myitem.getTitle() + ", since the borrow limit has been reached!");
            }
        }
        else{
            System.out.println(myuser.getName() + " cannot borrow " + myitem.getTitle() + ", you must first pay the penalty amount! " + myuser.getPenalty() + "$");
        }
        myuser.setBorrowedItem();
    }
    //I need a date converter to use LocalDate.I need my date in this form "Y-M-D"
    public static String dateConverter(String date){
        String[] dateInfo = date.split("/");
        String day = dateInfo[0];
        String month = dateInfo[1];
        String year = dateInfo[2];
        return year + "-" + month + "-" + day;
    }
}