import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
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

    /**
     * Provides the information whether the person or the animal exists
     * @param personID      personnel or visitor id
     * @param animalName    animal name
     * @return              boolean
     * @throws AnimalNotFound   there is no such an animal
     * @throws PersonNotFound   there is no such a person
     */
    public static boolean isNull(String personID ,String animalName) throws AnimalNotFound, PersonNotFound {
        People person = People.getMapPeople().get(personID);
        Animal animal = Animal.getMapAnimal().get(animalName);
        if (person != null) {
            if (animal != null) {
                return false;
            }
            else{
                throw new AnimalNotFound("There are no animals with the name " + animalName + ".");
            }
        }
        else{
            throw new PersonNotFound("There are no visitors or personnel with the id " + personID);
        }
    }

    public static void main(String[] args) throws AnimalNotFound, PersonNotFound, IOException {
        //OUTPUT
        String myOutput = args[4];
        PrintStream fileOut = new PrintStream(Files.newOutputStream(Paths.get(myOutput)), true, "UTF-8");
        System.setOut(fileOut);  //Do not write to the terminal,write to file.

        //ANIMALS

        String animalsTXT = args[0];
        //String animalsTXT = "animals3.txt";
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

        String peopleTXT = args[1];
        //String peopleTXT = "persons3.txt";
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

        String foodsTXT = args[2];
        //String foodsTXT = "foods3.txt";
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

        //COMMANDS

        String commandTXT = args[3];
        //String commandTXT = "commands3.txt";
        ArrayList<String[]> commandData = readTxtAsObject(commandTXT);
        //Determining which command is this
        //Using iteration,determining which command will be executed.
        for (int i = 0; i < commandData.size(); i++) {
            String[] commandInfo = commandData.get(i);

            String personID;
            String animalName;
            People person;
            Animal animal;

            System.out.println("***********************************");
            System.out.println("***Processing new Command***");

            switch (commandInfo[0]){
                case "List Food Stock":
                    myFoods.listFood();
                    break;
                case "Animal Visitation":
                    personID = commandInfo[1];
                    animalName = commandInfo[2];
                    person = People.getMapPeople().get(personID);

                    if (person instanceof Personnel){
                        System.out.println(person.getName() + " attempts to clean " + animalName + "'s habitat.");
                    }
                    else {
                        System.out.println(person.getName() + " tried to register for a visit to " + animalName + ".");
                    }

                    try{
                        if(!isNull(personID,animalName)){
                            person.visit(personID,animalName);
                        }
                    }
                    catch (AnimalNotFound e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    catch (PersonNotFound e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case "Feed Animal":
                    personID = commandInfo[1];
                    animalName = commandInfo[2];
                    person = People.getMapPeople().get(personID);
                    animal = Animal.getMapAnimal().get(animalName);

                    try{
                        double amount = Double.parseDouble(commandInfo[3]);
                        try{
                            if (!isNull(personID,animalName)){
                                if (person instanceof Personnel){
                                    System.out.println(person.getName() + " attempts to feed " + animalName + ".");
                                }
                                else {
                                    System.out.println(person.getName() + " tried to feed " + animalName + ".");
                                }

                                boolean isSuitable = false;
                                String errorMessage = "";

                                String[] mealList = animal.getMeal();
                                boolean shouldBreak = false;

                                for (String meal : mealList) {
                                    if(shouldBreak) break;
                                    switch (meal){
                                        case "meat":
                                            try{
                                                if (amount * animal.getMealSize() > myFoods.getMeat()) {
                                                    throw new NotEnoughFood("Not enough Meat");
                                                }
                                                else{
                                                    isSuitable = true;
                                                }
                                            }
                                            catch (NotEnoughFood e) {
                                                errorMessage = e.getMessage();
                                                shouldBreak = true;
                                            }
                                            break;
                                        case "plants":
                                            try{
                                                if (amount * animal.getMealSize() > myFoods.getPlants()) {
                                                    throw new NotEnoughFood("Not enough Plants");
                                                }
                                                else{
                                                    isSuitable = true;
                                                }
                                            }
                                            catch (NotEnoughFood e) {
                                                errorMessage = e.getMessage();
                                                shouldBreak = true;
                                            }
                                            break;
                                        case "fish":
                                            try{
                                                if (amount * animal.getMealSize() > myFoods.getFish()) {
                                                    throw new NotEnoughFood("Not enough Fish");
                                                }
                                                else{
                                                    isSuitable = true;
                                                }
                                            }
                                            catch (NotEnoughFood e) {
                                                errorMessage = e.getMessage();
                                                shouldBreak = true;
                                            }
                                            break;
                                    }
                                }
                                if (isSuitable) {
                                    if(person instanceof Personnel){
                                        ((Personnel) person).feed(personID,animalName,amount,myFoods);
                                    }
                                    else{
                                        System.out.println("Error: Visitors do not have the authority to feed animals.");
                                    }
                                }
                                else{
                                    System.out.println("Error: " + errorMessage);
                                }
                            }
                        }
                        catch (AnimalNotFound e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        catch (PersonNotFound e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }
                    catch (NumberFormatException e) {
                        System.out.println("Error processing command: " + commandInfo[0] + "," + commandInfo[1] + "," + commandInfo[2] + "," + commandInfo[3]);
                        System.out.println("Error: For input string: \"" + commandInfo[3] + "\"");
                    }
                    break;
                default:
                    System.out.println("Invalid command");
            }
        }
    }
}