import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

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

    public static void main(String[] args) {
        //ANIMALS

        //String animalsTXT = args[0];
        String animalsTXT = "animals1.txt";
        ArrayList<String[]> animalsData = readTxtAsObject(animalsTXT);

        System.out.println("***********************************");
        //Determining which animal is this
        System.out.println("***Initializing Animal information***");

        //Using iteration,animals are assigned to an object and kept in a HashMap
        for (int i = 0; i < animalsData.size(); i++) {
            String[] animalInfo = animalsData.get(i);

            switch (animalInfo[0]){
                case "Lion":
                    Lion lion = new Lion(animalInfo[1],Integer.parseInt(animalInfo[2]));
                    Animal.setMapAnimal(animalInfo[1],lion);
                    break;
                case "Elephant":
                    Elephant elephant = new Elephant(animalInfo[1],Integer.parseInt(animalInfo[2]));
                    Animal.setMapAnimal(animalInfo[1],elephant);
                    break;
                case "Penguin":
                    Penguin penguin = new Penguin(animalInfo[1],Integer.parseInt(animalInfo[2]));
                    Animal.setMapAnimal(animalInfo[1],penguin);
                    break;
                case "Chimpanzee":
                    Chimpanzee chimpanzee = new Chimpanzee(animalInfo[1],Integer.parseInt(animalInfo[2]));
                    Animal.setMapAnimal(animalInfo[1], chimpanzee);
                    break;
                default:
                    System.out.println("Invalid animal");
            }
        }

        //PEOPLE

        //String peopleTXT = args[1];
        String peopleTXT = "persons1.txt";
        ArrayList<String[]> peopleData = readTxtAsObject(peopleTXT);

        System.out.println("***********************************");
        //Determining which person is this
        System.out.println("***Initializing Visitor and Personnel information***");

        //Using iteration,people are assigned to an object and kept in a HashMap
        for (int i = 0; i < peopleData.size(); i++) {
            String[] peopleInfo = peopleData.get(i);

            switch (peopleInfo[0]){
                case "Personnel":
                    Personnel personnel = new Personnel(peopleInfo[1],peopleInfo[2]);
                    People.setMapPeople(peopleInfo[2],personnel);
                    break;
                case "Visitor":
                    Visitor visitor = new Visitor(peopleInfo[1],peopleInfo[2]);
                    People.setMapPeople(peopleInfo[2],visitor);
                    break;
                default:
                    System.out.println("Invalid person");
            }
        }

        //FOODS

        //String foodsTXT = args[2];
        String foodsTXT = "foods1.txt";
        ArrayList<String[]> foodsData = readTxtAsObject(foodsTXT);

        System.out.println("***********************************");
        //Determining which food is this
        System.out.println("***Initializing Food Stock***");
        Double[] foodStock = new Double[3];

        //Using iteration,a food object is created
        for (int i = 0; i < foodsData.size(); i++) {
            String[] foodsInfo = foodsData.get(i);

            switch (foodsInfo[0]){
                case "Meat":
                    foodStock[0] = Double.parseDouble(foodsInfo[1]);
                    break;
                case "Fish":
                   foodStock[1] = Double.parseDouble(foodsInfo[1]);
                    break;
                case "Plant":
                    foodStock[2] = Double.parseDouble(foodsInfo[1]);
                    break;
                default:
                    System.out.println("Invalid food");
            }
        }
        Foods myFoods = new Foods(foodStock[0],foodStock[2],foodStock[1]);   //Food object to use
    }
}