public class Visitor extends People{
    /**
     * Constructs visitor instances
     * @param name      visitor name
     * @param id        visitor id
     */
    Visitor(String name,String id) {
        super(name, id);
        System.out.println("Added new Visitor with id " + id + " and name " + name + ".");
    }

    /**
     * provides visiting operations for visitors.
     * @param id        visitor id
     * @param name      animal name
     */
    @Override
    public void visit(String id, String name) {
        String personName = People.getMapPeople().get(id).getName();
        String animalName = name;
        System.out.println(personName + " successfully visited " + animalName + ".");
    }
}