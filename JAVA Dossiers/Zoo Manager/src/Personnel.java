import java.util.HashMap;

public class Personnel extends People{
    private static HashMap<String, People> mapPersonnels = new HashMap<>();
    /**
     * Constructs personnel instances
     * @param name      personnel name
     * @param id        personnel id
     */
    Personnel(String name,String id){
        super(name,id);
    }

    public void feed(){
        //
    }
    public void clean(){
        //
    }

    //GETTER
    public static HashMap<String, People> getMapPersonnels() {return mapPersonnels;}

    //SETTERS
    public static void  setMapPersonnels(String key,Personnel value) {mapPersonnels.put(key,value);}

}
