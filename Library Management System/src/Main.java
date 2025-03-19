import java.io.*;
import java.util.ArrayList;

public class Main {

    // Function to read a text file
    public static ArrayList<String[]> readTxt(String input) {
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
        String fileName = "items.txt"; // The name of the TXT file (should be in the same folder as Main.java)
        ArrayList<String[]> itemsData = readTxt(fileName);  //Keeps the "items.txt"
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

        //USERS
        ArrayList<String[]> usersData = readTxt("users.txt");  //Keeps the "users.txt"
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
    }
}


