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
                //System.out.println("Line: " + line); // Print the read line
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
        return data;
    }

    public static void main(String[] args) {
        String fileName = "items.txt"; // The name of the TXT file (should be in the same folder as Main.java)
        //readTxt(fileName); // Call the function to read the file
        ArrayList<String[]> bookData = readTxt(fileName);
        ArrayList<Books> mybooks = new ArrayList<>();

        for(int i = 0; i < bookData.size(); i++) {
            for (int j = 0; j < 6; j++){
                String[] bookInfo = bookData.get(i);
                Books book = new Books(bookInfo[0], bookInfo[1], bookInfo[2], bookInfo[3], bookInfo[4],bookInfo[5]);
                mybooks.add(book);
            }
        }
        for (Books book : mybooks) {
            System.out.println(book);
        }
    }
}
