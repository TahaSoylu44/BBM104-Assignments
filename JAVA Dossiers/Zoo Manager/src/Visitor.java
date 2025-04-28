import java.util.HashMap;

public class Visitor extends People {
    private static HashMap<String, People> mapVisitors = new HashMap<>();
    /**
     * Constructs visitor instances
     * @param name      visitor name
     * @param id        visitor id
     */
    Visitor(String name,String id) {
        super(name, id);
    }

    public void visit() {
        //
    }

    //GETTER
    public static HashMap<String, People> getMapVisitors() {return mapVisitors;}

    //SETTERS
    public static void  setMapVisitors(String key,Visitor value) {mapVisitors.put(key,value);}
}
