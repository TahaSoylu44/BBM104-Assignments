public class Personnel extends People implements Feed{
    /**
     * Constructs personnel instances
     * @param name      personnel name
     * @param id        personnel id
     */
    Personnel(String name,String id){
        super(name,id);
        System.out.println("Added new Personnel with id " + id + " and name " + name + ".");
    }

    /**
     * Provides feeding operations for personnels.
     * @param id        Personnel id
     * @param name      animal name
     * @param amount    food amount
     * @param myFoods   Food object
     */
    @Override
    public void feed(String id, String name, double amount,Foods myFoods){
        String animalName = name;
        Animal myAnimal = Animal.getMapAnimal().get(animalName);
        double foodAmount = amount * myAnimal.getMealSize();
        String[] animalFoodList = myAnimal.getMeal();

        if (animalFoodList.length > 1){
            System.out.println(animalName + " has been given " + foodAmount + " kgs of " + animalFoodList[0] + " and " + foodAmount + " kgs of " + animalFoodList[1]);
        }
        else {
            System.out.println(animalName + " has been given " + foodAmount + " kgs of " + animalFoodList[0]);
        }

        for (String food : animalFoodList) {
            switch (food){
                case "meat":
                    myFoods.setMeat(foodAmount);
                    break;
                case "plants":
                    myFoods.setPlants(foodAmount);
                    break;
                case "fish":
                    myFoods.setFish(foodAmount);
                    break;
            }
        }
    }

    /**
     * provides visiting operations for personnels.
     * @param id        personnel id
     * @param name      animal name
     */
    @Override
    public void visit(String id, String name) {
        String personName = People.getMapPeople().get(id).getName();
        String animalName = name;
        System.out.println(personName + " started cleaning " + animalName + "'s habitat.");
        System.out.print("Cleaning " + animalName + "'s habitat: ");
        System.out.println(Animal.getMapAnimal().get(animalName).getCleanSentence());
    }
}