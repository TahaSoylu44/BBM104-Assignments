import java.util.HashMap;

/**
 * This abstract class is a super class for Personnel and Visitor.
 * Contains necessary variables and methods for items.
 * @author Taha Soylu
 */
public abstract class People{
    //VARIABLES
    private final String name;
    private final String id;
    private static HashMap<String, People> mapPeople = new HashMap<>();

    /**
     * Constructs people instances
     * @param name      People name
     * @param id        People specific id
     */
    People(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public abstract void visit(String id, String name);   //Child classes will override this method

    //GETTERS
    public String getName() {return name;}
    public String getId() {return id;}
    public static HashMap<String, People> getMapPeople() {return mapPeople;}

    //SETTER
    public static void setMapPeople(String key, People value) {mapPeople.put(key,value);}
}
